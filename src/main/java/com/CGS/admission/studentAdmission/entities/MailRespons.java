package com.CGS.admission.studentAdmission.entities;

public class MailRespons {
    private Boolean status;
    private String message;

    public MailRespons() {
    }

    public MailRespons(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
