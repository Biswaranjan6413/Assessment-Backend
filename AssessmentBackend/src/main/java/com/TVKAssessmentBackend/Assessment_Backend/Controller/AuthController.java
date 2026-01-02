package com.TVKAssessmentBackend.Assessment_Backend.Controller;

import com.TVKAssessmentBackend.Assessment_Backend.DTO.LoginRequest;
import com.TVKAssessmentBackend.Assessment_Backend.DTO.RegisterRequest;
import com.TVKAssessmentBackend.Assessment_Backend.Entity.Users;
import com.TVKAssessmentBackend.Assessment_Backend.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Users user = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(
                Map.of(
                        "username", user.getUsername(),
                        "message", "Login successful"
                )
        );

    }
        @PostMapping("/register")
        public ResponseEntity<?> register (@RequestBody RegisterRequest request){

            Users user = new Users();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());

            authService.register(user);

            return ResponseEntity.ok("Registration successful");
        }
//    @GetMapping("/test")
//    public String test() {
//        return "API is working";
//    }

}
