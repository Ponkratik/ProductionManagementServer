package by.b_p.productionmanagementserver.controller.impl;

import by.b_p.productionmanagementserver.controller.UserController;
import by.b_p.productionmanagementserver.model.User;
import by.b_p.productionmanagementserver.payload.response.MessageResponse;
import by.b_p.productionmanagementserver.repository.DepartmentRepository;
import by.b_p.productionmanagementserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class UserControllerImpl implements UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<User> temp = userRepository.findById(id);
        User tempUser;
        if (temp.isEmpty()) {
            return new ResponseEntity<>(new MessageResponse("Не удалось найти пользователя, id: " + id), HttpStatus.NO_CONTENT);
        } else {
            tempUser = temp.get();
        }

        return new ResponseEntity<>(tempUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<User> temp = userRepository.findById(id);
        if (temp.isEmpty()) {
            return new ResponseEntity<>(new MessageResponse("Не удалось найти пользователя, id: " + id), HttpStatus.NO_CONTENT);
        } else {
            userRepository.deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(Long id, User user) {
        Optional<User> temp = userRepository.findById(id);
        User tempUser;
        if (temp.isEmpty()) {
            return new ResponseEntity<>(new MessageResponse("Не удалось найти пользователя, id: " + id), HttpStatus.NO_CONTENT);
        } else {
            tempUser = temp.get();
        }

        tempUser.setUsername(user.getUsername());
        tempUser.setFio(user.getFio());
        tempUser.setDepartmentByDepartmentId(user.getDepartmentByDepartmentId());

        userRepository.save(tempUser);
        return new ResponseEntity<>(new MessageResponse("Данные пользователя успешно обновлены"), HttpStatus.OK);
    }
}
