package com.CGS.admission.studentAdmission.service;

public interface EmailService {
    void send(String from, String to, String body);
}