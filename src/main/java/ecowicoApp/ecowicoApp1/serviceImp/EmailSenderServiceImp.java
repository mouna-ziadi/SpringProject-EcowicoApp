package ecowicoApp.ecowicoApp1.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ecowicoApp.ecowicoApp1.repository.InvoiceRepository;
import ecowicoApp.ecowicoApp1.service.EmailSenderService;
import ecowicoApp.ecowicoApp1.service.InvoiceService;

@Service
public class EmailSenderServiceImp implements EmailSenderService{

	@Autowired
	private JavaMailSender mailSender;
	


	@Override
	public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("ziadimouna2@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		
		mailSender.send(message);
		System.out.println("mail send successfully!!!");
		
	}


	
}
