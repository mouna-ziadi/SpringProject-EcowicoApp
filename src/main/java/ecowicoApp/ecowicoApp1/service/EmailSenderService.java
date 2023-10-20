package ecowicoApp.ecowicoApp1.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {



	void sendSimpleEmail(String to, String subject, String text);

	

}
