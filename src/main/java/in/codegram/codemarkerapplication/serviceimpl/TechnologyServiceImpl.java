package in.codegram.codemarkerapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.codemarkerapplication.domain.Technology;
import in.codegram.codemarkerapplication.exception.TechnologyIdException;
import in.codegram.codemarkerapplication.repository.TechnologyRepository;
import in.codegram.codemarkerapplication.service.TechnologyService;

@Service
public class TechnologyServiceImpl implements TechnologyService{
	
	@Autowired
	private TechnologyRepository technologyRepository;

	@Override
	public Technology saveOrUpdate(Technology technology) {
		
		try {
			return technologyRepository.save(technology);
		}catch(Exception ex) {
			throw new TechnologyIdException("Test Id : "+technology.getTechnologyIdentifier()+"already exists");
		}
	}

	@Override
	public Iterable<Technology> findAllTechnologies() {
		// TODO Auto-generated method stub
		return technologyRepository.findAll();
	}

	@Override
	public void delete(String technologyId) {
		Technology technology=technologyRepository.findByTechnologyIdentifier(technologyId);
		
		technologyRepository.delete(technology);
	
	
	}

}
