package in.codegram.codemarkerapplication.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import in.codegram.codemarkerapplication.domain.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
	Report findByReportIdentifier(String reportIdentifier);
}
