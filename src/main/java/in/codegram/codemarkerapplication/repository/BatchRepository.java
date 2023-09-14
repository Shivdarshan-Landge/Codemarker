package in.codegram.codemarkerapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codegram.codemarkerapplication.domain.Batch;

@Repository
public interface BatchRepository extends CrudRepository<Batch, Long>{

	Batch findByBatchIdentifire(String batchId);
}
