package by.b_p.productionmanagementserver.controller;

import by.b_p.productionmanagementserver.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface UserController {
    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ROLE_SYSADMIN')")
    ResponseEntity<?> getAll();

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ROLE_SYSADMIN')")
    ResponseEntity<?> getById(@PathVariable("id") Long id);

    @DeleteMapping ("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_SYSADMIN')")
    ResponseEntity<?> delete(@PathVariable("id") Long id);

    @PutMapping ("/update/{id}")
    @PreAuthorize("hasRole('ROLE_SYSADMIN')")
    ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody User user);
}
