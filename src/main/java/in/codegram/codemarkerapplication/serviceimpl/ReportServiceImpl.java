package in.codegram.codemarkerapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.codegram.codemarkerapplication.domain.Report;
import in.codegram.codemarkerapplication.exception.ReportIdException;
import in.codegram.codemarkerapplication.repository.ReportRepository;
import in.codegram.codemarkerapplication.service.ReportSerivce;



@Service
public class ReportServiceImpl implements ReportSerivce {
	@Autowired
	private ReportRepository reportRepository;

	@Override
	public Report saveorUpdate(Report report) {

		try {
			return reportRepository.save(report);

		} catch (Exception ex) {
			// handling logic --------rethrow exception to send till ui layer
			throw new ReportIdException("Report Id :" + report.getReportIdentifier() + " already exists");
		}
	}

	@Override
	public Iterable<Report> findAllReport() {

		return reportRepository.findAll();
	}

	@Override
	public void delete(String reportIdentifier) {
		Report report = reportRepository.findByReportIdentifier(reportIdentifier);
//		TODO: Check for custom exp

		reportRepository.delete(report);
	}

}
