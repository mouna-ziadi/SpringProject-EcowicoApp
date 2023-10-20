package ecowicoApp.ecowicoApp1.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecowicoApp.ecowicoApp1.model.Customer;
import ecowicoApp.ecowicoApp1.model.Login;
import ecowicoApp.ecowicoApp1.repository.LoginRepository;

import ecowicoApp.ecowicoApp1.service.LoginService;

@Service
public class LoginServiceImp implements LoginService{
	@Autowired
	private LoginRepository repo;
	  
	@Override  
	public Login login(String username, String password) {
	  Login user = repo.findByUsernameAndPassword(username, password);
	   return user;
	  }

	@Override
	public List<Login> findall() {
		return repo.findAll();
	}

	@Override
	public Optional<Login> findByUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findByUsername(username));
	}

	
	
	

}
