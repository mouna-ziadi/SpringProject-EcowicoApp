package ecowicoApp.ecowicoApp1.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private Integer amountBilled;
	private Integer taxesBilled;
	private Date InvcDate;
	private String type;
    
	
	/*
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customer;*/
    
	
	//@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
	
	/* @OneToOne
	 *  @JoinColumn(name = "customer_id", nullable = false)
	private Customer customer; */


	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Invoice(Long id, Integer amountBilled, Integer taxesBilled, Date invcDate, Customer customer, String type) {
		super();
		this.id = id;
		this.amountBilled = amountBilled;
		this.taxesBilled = taxesBilled;
		InvcDate = invcDate;
		this.customer = customer;
		this.type = type;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getAmountBilled() {
		return amountBilled;
	}


	public void setAmountBilled(Integer amountBilled) {
		this.amountBilled = amountBilled;
	}


	public Integer getTaxesBilled() {
		return taxesBilled;
	}


	public void setTaxesBilled(Integer taxesBilled) {
		this.taxesBilled = taxesBilled;
	}


	public java.util.Date getInvcDate() {
		return InvcDate;
	}


	public void setInvcDate(Date invcDate) {
		InvcDate = invcDate;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", amountBilled=" + amountBilled + ", taxesBilled=" + taxesBilled + ", InvcDate="
				+ InvcDate + ", type=" + type + ", customer=" + customer + "]";
	}

	
}
