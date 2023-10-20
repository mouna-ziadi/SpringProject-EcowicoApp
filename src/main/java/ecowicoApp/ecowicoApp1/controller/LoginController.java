package ecowicoApp.ecowicoApp1.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ecowicoApp.ecowicoApp1.model.Customer;
import ecowicoApp.ecowicoApp1.model.Login;
import ecowicoApp.ecowicoApp1.repository.LoginRepository;
import ecowicoApp.ecowicoApp1.service.LoginService;



@RestController
@RequestMapping("/ecowico")
@CrossOrigin("*")
public class LoginController {
	@Autowired
    private LoginService userService;
	private LoginRepository repo;
	 @PostMapping("/loginUser")
	 public ResponseEntity<?> loginUser(@RequestBody Login loginData){
		 System.out.println(loginData);
		 Login login= repo.findByUsernameAndPassword(loginData.getUsername(),loginData.getPassword());
		 if (loginData.getPassword().equals(loginData.getPassword()))
			 return ResponseEntity.ok(login);
		 return (ResponseEntity<?>) ResponseEntity.internalServerError();
	 }
	 @GetMapping("/logintest")
	 public String logintest(){
		 
		 return "mchet sayee";
	 }
	 
	 @GetMapping("/allUsers")
		public ResponseEntity<List<Login>> get(){
			List<Login> users = userService.findall();
			return new ResponseEntity<List<Login>>(users,HttpStatus.OK);
	}
	 
	 @GetMapping("/users/{username}")
		public ResponseEntity<Login> login(@PathVariable String username){
			Optional<Login> cat = userService.findByUsername(username);
			return cat.map(ResponseEntity::ok)
					.orElseGet(()-> ResponseEntity.notFound()
							.build());
	}
	
	
}
