package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.entities.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;
@Service
public class PositionManager implements PositionService{

	private PositionDao positionDao;
	
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public List<Position> getAll() {
		
		return this.positionDao.findAll();
	}

}