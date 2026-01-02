package com.TVKAssessmentBackend.Assessment_Backend.Service;

import com.TVKAssessmentBackend.Assessment_Backend.Entity.Contact;
import com.TVKAssessmentBackend.Assessment_Backend.Repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepo contactRepo;



    public Contact saveContact(Contact contact) {
     return contactRepo.save(contact);
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }


    public Contact getContactId(Long id) {
        return contactRepo.findById(id).orElse(null);
    }
}
