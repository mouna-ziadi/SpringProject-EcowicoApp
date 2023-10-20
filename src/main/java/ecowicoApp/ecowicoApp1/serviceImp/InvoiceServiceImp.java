package ecowicoApp.ecowicoApp1.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ecowicoApp.ecowicoApp1.model.Customer;
import ecowicoApp.ecowicoApp1.model.Invoice;
import ecowicoApp.ecowicoApp1.repository.InvoiceRepository;

import ecowicoApp.ecowicoApp1.service.InvoiceService;


@Service
public class InvoiceServiceImp implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> findall() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice save(Invoice invoice) {
		invoiceRepository.save(invoice);
		return invoice;
	}

	@Override
	public Invoice findById(Long id) {
		if(invoiceRepository.findById(id).isPresent()) {
			return invoiceRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Invoice invoice = findById(id);
		invoiceRepository.delete(invoice);
		
	}

	@Override
	public Invoice update(Invoice invoice) {
		invoiceRepository.save(invoice);
		return invoice;
	}

	 @Override
	public List<Object> getPercentageGroupByType() {
		
		return invoiceRepository.getPercentageGroupByType();
	}

	/*@Override
	public List<CountType> getPercentageGroupByType(){
		return invoiceRepository.getPercentageGroupByType();
	}*/
	
}
