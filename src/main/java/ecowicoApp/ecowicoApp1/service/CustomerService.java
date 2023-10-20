package ecowicoApp.ecowicoApp1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecowicoApp.ecowicoApp1.model.Customer;

@Service
public interface CustomerService {
	
	List<Customer> findall();
	Customer save(Customer customer);
	Customer findById(Long id);
    void delete(Long id);
	Customer update(Customer customer);
	//Customer findByIsbn(String isbn);

}
