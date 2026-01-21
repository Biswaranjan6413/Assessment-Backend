package com.TVKAssessmentBackend.Assessment_Backend.Service;

import com.TVKAssessmentBackend.Assessment_Backend.Entity.Users;
import com.TVKAssessmentBackend.Assessment_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public Users createUser(Users user) {
        return userRepo.save(user);
    }

//    public User getByUsername(String username) {
//        return userRepo.findByUsername(username).orElseThrow()
//    }



}
