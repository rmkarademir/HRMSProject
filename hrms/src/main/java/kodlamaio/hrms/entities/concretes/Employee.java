package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;
@Data
@Entity
@Table(name = "employes")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality_number")
	private String nationalityNumber;
	
	@Column(name = "birth_year")
	private int birthYear;
	
	@Column(name = "email")
	private String eMail;
	
	@Column(name = "password")
	private String password;

	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String nationalityNumber, int birthYear, String eMail, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityNumber = nationalityNumber;
		this.birthYear = birthYear;
		this.eMail = eMail;
		this.password = password;
	}
	
	
	
}
