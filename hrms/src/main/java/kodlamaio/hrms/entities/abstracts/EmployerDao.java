package kodlamaio.hrms.entities.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao  extends JpaRepository<Employer,Integer>{

}