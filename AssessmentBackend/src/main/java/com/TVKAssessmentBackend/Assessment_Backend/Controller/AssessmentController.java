package com.TVKAssessmentBackend.Assessment_Backend.Controller;

import com.TVKAssessmentBackend.Assessment_Backend.DTO.AssessmentRequest;
import com.TVKAssessmentBackend.Assessment_Backend.Entity.AssessmentResult;
import com.TVKAssessmentBackend.Assessment_Backend.Entity.Users;
import com.TVKAssessmentBackend.Assessment_Backend.Repository.AssessmentRepo;
import com.TVKAssessmentBackend.Assessment_Backend.Repository.UserRepo;
import com.TVKAssessmentBackend.Assessment_Backend.Service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ass")
public class AssessmentController {
    @Autowired
    private UserRepo userRepo;
    private final AssessmentService assessmentService;
    private final AssessmentRepo assessmentRepo;

    public AssessmentController(AssessmentService assessmentService, AssessmentRepo assessmentRepo) {
        this.assessmentService = assessmentService;
        this.assessmentRepo = assessmentRepo;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitAssessment(@RequestBody AssessmentRequest request) {

        Users user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        int score = assessmentService.calculateScore(request.getAnswers());

        AssessmentResult result = new AssessmentResult();
        result.setUsername(user.getUsername());
        result.setScore(score);

        assessmentRepo.save(result);

        return ResponseEntity.ok(
                Map.of(
                        "username", user.getUsername(),
                        "score", score,
                        "message", "Assessment submitted successfully"
                )
        );
    }
}