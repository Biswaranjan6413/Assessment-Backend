package com.TVKAssessmentBackend.Assessment_Backend.Service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AssessmentService {

    private static final Map<Integer, String> CORRECT_ANSWERS = Map.of(
            1, "Option A",
            2, "Option B"
    );

    public int calculateScore(Map<Integer, String> answers) {
        int score = 0;
        for (Integer qId : answers.keySet()) {
            if (CORRECT_ANSWERS.get(qId).equals(answers.get(qId))) {
                score++;
            }
        }
        return score;
    }
}
