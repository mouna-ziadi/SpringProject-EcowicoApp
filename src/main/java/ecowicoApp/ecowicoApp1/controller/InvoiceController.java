package ecowicoApp.ecowicoApp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecowicoApp.ecowicoApp1.model.Invoice;
import ecowicoApp.ecowicoApp1.service.EmailSenderService;
import ecowicoApp.ecowicoApp1.service.InvoiceService;

@RestController
@RequestMapping("/ecowico")
@CrossOrigin("*")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	private EmailSenderService senderService;
	
    

	// @CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/allInvoices")
	public ResponseEntity<List<Invoice>> get() {
		List<Invoice> invoices = invoiceService.findall();
		return new ResponseEntity<List<Invoice>>(invoices, HttpStatus.OK);
	}
	
	/*@GetMapping("/percentCountType")
	public ResponseEntity<List<CountType>> getPercentageGroupByType()
	{
		List<CountType> countTypes = invoiceService.getPercentageGroupByType();
		return new ResponseEntity<List<CountType>>(countTypes, HttpStatus.OK);
	}*/
	
	@GetMapping("/percentCount")
	List<Object> getPercentageGroupByType(){
		return invoiceService.getPercentageGroupByType();
	}

	
	@PostMapping("/addInvoice")
	public ResponseEntity<Invoice> save(@RequestBody Invoice invoice) {
		Invoice invoiceOne = invoiceService.save(invoice);
		return new ResponseEntity<Invoice>(invoiceOne, HttpStatus.OK);
	}

	@PutMapping("/updateInvoice")
	public ResponseEntity<Invoice> update(@RequestBody Invoice invoice) {
		Invoice updateInvoices = invoiceService.update(invoice);
		return new ResponseEntity<>(updateInvoices, HttpStatus.OK);
	}

	@GetMapping("/invoice/{id}")
	public ResponseEntity<Invoice> get(@PathVariable("id") Long id) {
		Invoice invoice = invoiceService.findById(id);
		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
	}

	@DeleteMapping("/deleteInvoice/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		invoiceService.delete(id);
		return new ResponseEntity<String>("Invoice is delete successfully !", HttpStatus.OK);
	}
	
	
}
