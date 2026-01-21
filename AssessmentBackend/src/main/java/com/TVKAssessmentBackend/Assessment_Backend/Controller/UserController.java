package com.TVKAssessmentBackend.Assessment_Backend.Controller;

import com.TVKAssessmentBackend.Assessment_Backend.Entity.Users;
import com.TVKAssessmentBackend.Assessment_Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody Users user){
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }
//    @GetMapping("/{username}")
//    public ResponseEntity<User> getUser(@PathVariable String username) {
//        return ResponseEntity.ok(userService.getByUsername(username));
//    }
}
