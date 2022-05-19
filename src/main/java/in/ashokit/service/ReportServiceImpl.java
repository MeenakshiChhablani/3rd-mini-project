package in.ashokit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.EligibilityDetailsEntity;
import in.ashokit.repository.EligibilityDtlsRepo;
import in.ashokit.requestbinding.SearchRequest;
import in.ashokit.responsebinding.SearchResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private EligibilityDtlsRepo repository;

	@Override
	public List<String> getPlanNames() {
		// List<String> uniquePlanNames = repository.getUniquePlanNames();
		return repository.getUniquePlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {

		return repository.getUniquePlanStatues();
	}

	@Override
	public List<SearchResponse> searchPlans(SearchRequest request) {
		List<EligibilityDetailsEntity> eligibleRecords = null;
		if (request == null) {  //changes
		//if(isSearchRequestEmpty(request)) {vchanges
			// List<EligibilityDetailsEntity> allRecords = repository.findAll();
			eligibleRecords = repository.findAll();
		} else {
			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();

			EligibilityDetailsEntity entity = new EligibilityDetailsEntity();
			if (planName != null && !planName.equals("")) {
				entity.setPlanName(planName);
			}
			if (planStatus != null && !planStatus.equals("")) {
				entity.setPlanStatus(planStatus);
			}
			if (startDate != null && endDate != null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}

			/* Example<EligibilityDetailsEntity>  of=Example.of(entity);
			eligibleRecords = repository.findAll(of);*/
			
			Example<EligibilityDetailsEntity>  of=Example.of(entity);
			eligibleRecords = repository.findAll(of);
		}
		
		List<SearchResponse> response =new ArrayList<>();
		for(EligibilityDetailsEntity records : eligibleRecords) {
			SearchResponse sr=new SearchResponse();
			BeanUtils.copyProperties(records, sr);
			response.add(sr);
		}
		return response;
	}
//if here dates was not available hen we could go with query by example but here date is there so use Criteria 
	
	/*public boolean isSearchRequestEmpty(SearchRequest request ) {
		//boolean isEmpty=true;
		if(request.getPlanName() !=null && !request.getPlanName().equals("")) {
			return false;
		}
		if(request.getPlanStatus() !=null && !request.getPlanStatus().equals("")) {
			return false;
		}
		if(request.getStartDate() !=null && !request.getStartDate().equals("")) {
			return false;
		}
		if(request.getEndDate() !=null && !request.getEndDate().equals("")) {
			return false;
		}//end date condition not required 
		//return true;
		return true;
	}*///changes
	//and one more thing by one condition also we can check object is empty or not ..so other not required 
	
}
