package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "İş arayanlar listelendi");
	}
	
	@Override
	public Result add(Employee employee) {
		if(isNationalityNumberExist(employee.getNationalityNumber()).isSuccess() && 
				isEmailExist(employee.getEMail()).isSuccess()) {
			this.employeeDao.save(employee);
			return new SuccessResult("İş arayan sisteme eklendi.");
		}
		return new ErrorResult("İş arayan sisteme eklenemedi. E-posta veya TC no sistemde kayıtlı.");
		
	}
	
	 private Result isNationalityNumberExist(String nationalityNumber) {
	        if (employeeDao.findByNationalityNumber(nationalityNumber).isPresent()) {
	            return new ErrorResult("Girilen TC no sistemde kayıtlı.");
	        }
	        return new SuccessResult();
	 }
	 public Result isEmailExist(String Email) {
	        if(employeeDao.findByeMail(Email).isPresent()){
	            return new ErrorResult("Girilen e-posta sistemde kayıtlı.");
	        }
	        return new SuccessResult();

	 }
}