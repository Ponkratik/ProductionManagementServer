package by.b_p.productionmanagementserver.controller;

import by.b_p.productionmanagementserver.payload.request.SigninRequest;
import by.b_p.productionmanagementserver.payload.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface AuthController {
    @PostMapping("/signin")
    ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninRequest signinRequest);

    @PostMapping("/signup")
        //@PreAuthorize("hasRole('ROLE_SYSADMIN')")
    ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest);
}