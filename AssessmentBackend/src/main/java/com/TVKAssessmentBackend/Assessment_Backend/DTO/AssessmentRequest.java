package com.TVKAssessmentBackend.Assessment_Backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class AssessmentRequest {
    private String username;
    private Map<Integer,String>answers;

    public Map<Integer,String> getAnswers(){
        return getAnswers();
    }

//    public Map<Integer, String> getAnswers() {
//    return getAnswers();
//   }
}
