package ecowicoApp.ecowicoApp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ecowicoApp.ecowicoApp1.model.Login;

@Service
public interface LoginService {

	Login login(String username, String password);

	List<Login> findall();

	Optional<Login> findByUsername(String username);
	
	
}
