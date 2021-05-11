package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
@Table(name = "employers")
public class Employer {
	@Id
	@GeneratedValue
	@Column(name = "employer_id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	@Column(name = "email")
	private String eMail;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "password")
	private String password;

	
	public Employer() {
		
	}
	
	public Employer(int id, String companyName, String webSite, String eMail, String phoneNumber, String password) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webSite = webSite;
		this.eMail = eMail;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	
	
}
