package in.codegram.codemarkerapplication.service;

import in.codegram.codemarkerapplication.domain.Batch;

public interface BatchService {

	Batch saveOrUpdate(Batch batch);
	Iterable<Batch> findAllBatches();

	void delete(String batchId);
}
