package com.TVKAssessmentBackend.Assessment_Backend.Repository;

import com.TVKAssessmentBackend.Assessment_Backend.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {
}
