package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
}
	@Override
	public Result add(Employer employer) {
		if(isEmailExist(employer.getEMail()).isSuccess() && employer.getEMail().split("@")[1].equals(employer.getWebSite())) {
		this.employerDao.save(employer);
		return new SuccessResult("İş veren sisteme eklendi.");
		}
		return new ErrorResult("İş veren sisteme eklenemedi. E-posta sistemde kayıtlı veya şirkete ait değil.");
	}
	
	public Result isEmailExist(String eMail) {
        if(employerDao.findByeMail(eMail).isPresent()){
            return new ErrorResult("Girilen e-posta sistemde kayıtlı.");
        }
        return new SuccessResult();
 }
	
}