package ecowicoApp.ecowicoApp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ecowicoApp.ecowicoApp1.model.Customer;
import ecowicoApp.ecowicoApp1.model.Invoice;
import ecowicoApp.ecowicoApp1.service.CustomerService;
import ecowicoApp.ecowicoApp1.service.EmailSenderService;

//@CrossOrigin("Access-Control-Allow-Origin")

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ecowico")
@CrossOrigin("*")


public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	EmailSenderService senderService;
	public CustomerController (EmailSenderService senderService) {
		this.senderService = senderService;
	}
	
	@PostMapping("/sendEmail")
	String sendEmailMessage() {
		this.senderService.sendSimpleEmail(
				"ecowico2022@gmail.com",
				 "Smart Ecowico Technology", 
				 "Avec ecowico, ouvrez vous à de nouvelles opportunités !\r\n"
				 + "\r\n"
				 + "Notre équipe sera toujours disponible si vous avez besoin de soutien, vous pouvez demander de l’aide via contact@ecowico.tn ou via nos numéros de contact");
		return "message send";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> get(){
		List<Customer> customers = customerService.findall();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> save(@RequestBody Customer customer){
		Customer customerOne = customerService.save(customer);
		return new ResponseEntity<Customer>(customerOne,HttpStatus.OK);
	}
	
	//@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/update")
	public ResponseEntity<Customer> update(@RequestBody Customer customer){
		Customer updateCustomer = customerService.update(customer);
		return new ResponseEntity<>(updateCustomer,HttpStatus.OK);
	}

	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> get(@PathVariable("id") Long id){
		Customer customer = customerService.findById(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		customerService.delete(id);
		return new ResponseEntity<String>("Customer is delete successfully !",HttpStatus.OK);
	}



}
