package com.TVKAssessmentBackend.Assessment_Backend.Repository;

import com.TVKAssessmentBackend.Assessment_Backend.Entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepo extends JpaRepository<AssessmentResult,Long> {
}
