package in.ashokit.service;

import java.util.List;



import in.ashokit.requestbinding.SearchRequest;
import in.ashokit.responsebinding.SearchResponse;


public interface ReportService {

public 	List<String> getPlanNames();   //purpose of this method to load the data from dropdown 
public 	List<String> getPlanStatuses();

public 	List<SearchResponse> searchPlans(SearchRequest request);  //to get the data based on search 


//public void exportExcel(List<SearchResponse> record);
//public void exportPdf(List<SearchResponse> record);
//we can cfeate separate class for excel and pdf export 	
}
