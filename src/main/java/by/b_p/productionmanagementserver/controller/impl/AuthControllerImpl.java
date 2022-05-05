package by.b_p.productionmanagementserver.controller.impl;

import by.b_p.productionmanagementserver.controller.AuthController;
import by.b_p.productionmanagementserver.model.Department;
import by.b_p.productionmanagementserver.model.User;
import by.b_p.productionmanagementserver.payload.request.SigninRequest;
import by.b_p.productionmanagementserver.payload.request.SignupRequest;
import by.b_p.productionmanagementserver.payload.response.JwtResponse;
import by.b_p.productionmanagementserver.payload.response.MessageResponse;
import by.b_p.productionmanagementserver.repository.DepartmentRepository;
import by.b_p.productionmanagementserver.repository.UserRepository;
import by.b_p.productionmanagementserver.security.jwt.JwtUtils;
import by.b_p.productionmanagementserver.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public ResponseEntity<?> registerUser(SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Ошибка: пользователь с таким логином уже существует"));
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setFio(signupRequest.getFio());
        user.setDepartmentByDepartmentId(signupRequest.getDepartmentByDepartmentId());

        userRepository.save(user);
        return new ResponseEntity<>(new MessageResponse("Пользователь успешно зарегистрирован"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> authenticateUser(SigninRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> departmentStrs = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        Department department = departmentRepository.findByDepartmentName(departmentStrs.get(0)).get();
        return new ResponseEntity<>(new JwtResponse(jwt,
                userDetails.getUsername(),
                department), HttpStatus.OK);
    }
}
