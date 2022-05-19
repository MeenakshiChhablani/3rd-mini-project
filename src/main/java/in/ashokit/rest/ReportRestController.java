package in.ashokit.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.reports.ExcelGenerator;
import in.ashokit.reports.PdfGenerator;
import in.ashokit.requestbinding.SearchRequest;
import in.ashokit.responsebinding.SearchResponse;
import in.ashokit.service.ReportService;

@RestController
public class ReportRestController {

@Autowired
private ReportService service;
	
@GetMapping("/plans")
public List<String>  getPlans() {
	return service.getPlanNames();
	
}

@GetMapping("/planstatus")
public 	List<String> getStatuses(){
	return service.getPlanStatuses();
}

@GetMapping("/search")
public 	List<SearchResponse> search(SearchRequest request){
	return service.searchPlans(request);
	
	
	
}
@GetMapping("/excel")
		public void  generateExcel(HttpServletResponse response ) throws Exception {
		
	response.setContentType("application/octet-stream");
	String headerKey="Content-Disposition";  //contenttype header
	String headerValue="attachment; filename=Plans.xls";
	response.setHeader(headerKey, headerValue);
	
	List<SearchResponse> records = service.searchPlans(null);
	
	ExcelGenerator excel=new ExcelGenerator();
	excel.generateExcel(records, response);
			
			
}	 
@GetMapping("/pdf")
public void  generatePdf(HttpServletResponse httpResponse ) throws Exception {
	
	httpResponse.setContentType("application/pdf");
	String headerKey="Content-Disposition";
	String headerValue="attachment; filename=Plans.pdf";
	httpResponse.setHeader(headerKey, headerValue);
	
	List<SearchResponse> records = service.searchPlans(null);//
	PdfGenerator pdfGen=new PdfGenerator();
	pdfGen.generatePdf(records, httpResponse);
			
		}
}
