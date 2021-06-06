package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllSortDate")
	public DataResult<List<JobAdvertisement>> getAllSortDate() {
		return jobAdvertisementService.getAllSortDate();
	}
	
	@GetMapping("/getByCompanyNameAndActivity")
	public DataResult<List<JobAdvertisement>> getByCompanyNameAndActivity(@RequestParam("companyName") String companyName, @RequestParam("activity") boolean activity) {
		return jobAdvertisementService.getByCompanyNameAndActivity(companyName, activity);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
}
