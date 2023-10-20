package ecowicoApp.ecowicoApp1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	@NotEmpty(message="the name should be not empty!!")
	private String name;
	private String email;
	private String phone;
	private String imageUrl;
	
	/* @OneToMany
	  private List<Invoice> invoices = new ArrayList<>();*/
	
    
    @OneToMany
    private List<Invoice> invoices = new ArrayList<>();

	 /*@OneToMany
	 (mappedBy = "customer", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	            (cascade = CascadeType.ALL, mappedBy = "customer")
	            private Set<Invoice> invoices;
	 private List<Invoice> invoices = new ArrayList<>();*/
	 
	 
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Customer(Long id) {
		super();
		this.id = id;
	}


	public Customer(Long id, @NotEmpty(message = "the name should be not empty!!") String name, String email,
			String phone, String imageUrl,Invoice invoices) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.invoices = (List<Invoice>) invoices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Invoice> getInvoices() {
		 return (List<Invoice>) invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = (List<Invoice>) invoices;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", imageUrl="
				+ imageUrl + ", invoices=" + invoices + "]";
	}
	
	

}
