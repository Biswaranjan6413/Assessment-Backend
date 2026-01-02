package com.TVKAssessmentBackend.Assessment_Backend.Controller;

import com.TVKAssessmentBackend.Assessment_Backend.Entity.Contact;
import com.TVKAssessmentBackend.Assessment_Backend.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactReq")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @PostMapping("/post")
    public ResponseEntity<Contact>saveContact(@RequestBody Contact contact){
     Contact saved=contactService.saveContact(contact);
     return ResponseEntity.ok(saved);
    }
    @GetMapping("/get")
    public List<Contact> getAll(){
        return contactService.getAll();
    }

    @GetMapping("/get{id}")
    public Contact getContactId(@PathVariable Long id){
        return contactService.getContactId(id);
    }
}
