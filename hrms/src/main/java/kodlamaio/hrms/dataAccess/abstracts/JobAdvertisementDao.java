package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
	@Query("from JobAdvertisement where companyName=:companyName and activity=:activity")
	List<JobAdvertisement> getByCompanyNameAndActivity(String companyName, boolean activity);
}
