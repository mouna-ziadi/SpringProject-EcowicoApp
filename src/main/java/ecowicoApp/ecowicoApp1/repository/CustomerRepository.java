package ecowicoApp.ecowicoApp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecowicoApp.ecowicoApp1.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
