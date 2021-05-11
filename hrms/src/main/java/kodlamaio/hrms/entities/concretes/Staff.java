package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


import lombok.Data;
@Data
@Entity
@Table(name = "staffs")
public class Staff {
	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "password")
	private String password;

	public Staff() {
		
	}
	
	public Staff(int id, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
}
