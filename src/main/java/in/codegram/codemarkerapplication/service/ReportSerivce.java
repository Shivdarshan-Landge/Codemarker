package in.codegram.codemarkerapplication.service;

import in.codegram.codemarkerapplication.domain.Report;

public interface ReportSerivce {
  Report saveorUpdate(Report reportt);
  Iterable<Report> findAllReport();
  void delete(String reportIdentifier);
  
}
