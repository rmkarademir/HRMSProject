package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{
	Optional<Employee> findByeMail(String Email);
	Optional<Employee> findByNationalityNumber(String nationalityNumber);
}
