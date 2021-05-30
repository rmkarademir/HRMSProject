package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.dataAccess.abstracts.StaffDao;

@Service
public class StaffManager {
	private StaffDao staffDao;

	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}
	
}
