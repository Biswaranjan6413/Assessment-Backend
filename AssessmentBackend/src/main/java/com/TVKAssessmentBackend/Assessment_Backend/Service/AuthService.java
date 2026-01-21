package com.TVKAssessmentBackend.Assessment_Backend.Service;

import com.TVKAssessmentBackend.Assessment_Backend.Entity.Users;
import com.TVKAssessmentBackend.Assessment_Backend.Exception.InvalidCredentialsException;
import com.TVKAssessmentBackend.Assessment_Backend.Exception.UserAlreadyExistsException;
import com.TVKAssessmentBackend.Assessment_Backend.Exception.UserNotFoundException;
import com.TVKAssessmentBackend.Assessment_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

//     BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;

//    private PasswordEncoder passwordEncoder;

        public Users login(String username, String password) {
            Users user = userRepo.findByUsername(username)
                    .orElseThrow(() -> new UserNotFoundException("User not found"));

            if (!user.getPassword().equals(password)) {
                throw new InvalidCredentialsException("Invalid password");
            }

            return user;
        }


        public void register(Users user) {
            if (userRepo.existsByUsername(user.getUsername())) {
                throw new UserAlreadyExistsException("Username already exists") ;
            }
            userRepo.save(user);
        }
    }


