package com.example.springlearn.psa;

public class EmailService {
	private final EmailSender emailSender;

	// 인터페이스를 구현한 구현체가 들어오기에 다른 기능을 사용하려면 해당 구현체를 사용하면 된다.
	public EmailService(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendEmail(String to, String subject, String body) {
		/*// SMTP를 사용하여 이메일 발송하는 코드
		System.out.println("SMTP: Sending email to " + to);*/
		emailSender.sendEmail(to, subject, body);
	}
}