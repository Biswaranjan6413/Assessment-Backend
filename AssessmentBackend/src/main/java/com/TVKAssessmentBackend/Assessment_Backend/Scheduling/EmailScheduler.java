package com.TVKAssessmentBackend.Assessment_Backend.Scheduling;

import com.TVKAssessmentBackend.Assessment_Backend.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
@Autowired
private EmailService emailService;
    @Scheduled(cron = "0 0 10 * * ?")
    public void sendScheduledEmail() {
        emailService.sendEmail();
    }
}
