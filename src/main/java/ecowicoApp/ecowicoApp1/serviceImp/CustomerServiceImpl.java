package ecowicoApp.ecowicoApp1.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecowicoApp.ecowicoApp1.model.Customer;
import ecowicoApp.ecowicoApp1.repository.CustomerRepository;
import ecowicoApp.ecowicoApp1.service.CustomerService;


@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findall() {
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	
	@Override
	public Customer update(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer findById(Long id) {
		if(customerRepository.findById(id).isPresent()) {
			return customerRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Customer customer = findById(id);
		customerRepository.delete(customer);
		
	}

	

}
