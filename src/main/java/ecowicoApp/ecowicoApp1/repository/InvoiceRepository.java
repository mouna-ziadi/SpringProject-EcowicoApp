package ecowicoApp.ecowicoApp1.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import ecowicoApp.ecowicoApp1.model.Invoice;

public interface InvoiceRepository  extends JpaRepository<Invoice, Long> {
	
	
	
	//@Query(value="select new ecowicoApp.ecowicoApp1.Data.Count(count(*)/(select count(*) from Invoice)*100, status) from Invoice group by status")
	@Query(value="select (count(*)/(select count(*) from invoice)*100), type from invoice group by type",nativeQuery = true)
	public List<Object> getPercentageGroupByType();
	
	
	

	/*@Query(value="select (count(*)/(select count(*) from invoice)*100), status from invoice group by status")
	List<CountType> getPercentageGroupByType();*/

	 //JPA query
   
	//List<Invoice> findByCustomer(Customer customer);

}
