package ecowicoApp.ecowicoApp1.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ecowicoApp.ecowicoApp1.model.Customer;
import ecowicoApp.ecowicoApp1.model.Invoice;


@Service
public interface InvoiceService {
	
	List<Invoice> findall();
	Invoice save(Invoice invoice);
	Invoice findById(Long id);
    void delete(Long id);
    Invoice update(Invoice invoice);
    List<Object> getPercentageGroupByType();
    //List<Invoice> findByCustomer(Customer customer, Sort sort);
    //List<Invoice> findByCustomer(Customer customer);
	
	/*@Query(value="select (count(*)/(select count(*) from invoice)*100), status from invoice group by status")
	List<CountType> getPercentageGroupByType();*/

}
