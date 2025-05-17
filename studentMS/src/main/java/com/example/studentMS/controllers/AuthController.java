package com.example.studentMS.controllers;

import com.example.studentMS.models.UserPrinciple;
import com.example.studentMS.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth") // Optional: helps organize endpoints
public class AuthController {

    @GetMapping("/home")
    public ResponseEntity<?> home() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof UserPrinciple)) {
            return ResponseEntity.status(401).body("Unauthorized access");
        }

        UserPrinciple userPrinciple = (UserPrinciple) principal;
        Users user = userPrinciple.getUser();
        String email = user.getEmail();
        String role = user.getRole().getRoleName();

        Map<String, Object> response = new HashMap<>();
        response.put("email", email);
        response.put("role", role);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/greet")
    public String greet(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPrinciple userPrinciple = (UserPrinciple) principal;
        Users user = userPrinciple.getUser();
        String firstName = user.getFirstName();
        String lastname = user.getLastName();

        return "hello "+firstName+" "+lastname;
    }
}
