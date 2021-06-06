package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"endDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),"Aktif iş ilanları bitiş tarihine göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCompanyNameAndActivity(String companyName, boolean activity) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyNameAndActivity(companyName, activity),"Firmaya ait iş ilanları listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı eklendi.");
	}

}
