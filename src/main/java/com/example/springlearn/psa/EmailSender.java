package com.example.springlearn.psa;

public interface EmailSender {
	void sendEmail(String to, String subject, String body);
}