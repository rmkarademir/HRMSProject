package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobAdvertisements")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	//@Column(name="position_id")
	//private int positionId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="city")
	private String city;
	
	@Column(name="min_pay")
	private int minPay;
	
	@Column(name="max_pay")
	private int maxPay;
	
	@Column(name="count_of_positions")
	private int countOfPositions;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="activity")
	private boolean activity;
	
	@Column(name="date_of_registration")
	private Date dateOfRegistration;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private Position position;
}
