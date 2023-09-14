package in.codegram.codemarkerapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.codemarkerapplication.domain.Batch;
import in.codegram.codemarkerapplication.exception.BatchIdException;
import in.codegram.codemarkerapplication.repository.BatchRepository;
import in.codegram.codemarkerapplication.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchRepository batchRepository;
	
	@Override
	public Batch saveOrUpdate(Batch batch) {
		
		try {
			return batchRepository.save(batch);
		}catch(Exception ex) {
			//handling logic --- rethrow exception to sent till ui layer
			throw new BatchIdException("Batch Id : "+batch.getBatchIdentifire()+" already exists");
		}
	}

	@Override
	public Iterable<Batch> findAllBatches() {
		
		return batchRepository.findAll();
	}

	@Override
	public void delete(String batchId) {
		Batch batch =batchRepository.findByBatchIdentifire(batchId);
		batchRepository.delete(batch);
	}

}
