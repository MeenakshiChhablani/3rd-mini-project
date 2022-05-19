package in.ashokit.repository;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.EligibilityDetailsEntity;

public interface EligibilityDtlsRepo  extends JpaRepository<EligibilityDetailsEntity , Integer >{

	@Query("select distinct(planName) from EligibilityDetailsEntity")
	public List<String>  getUniquePlanNames();
	
	
	@Query("select distinct(planStatus) from EligibilityDetailsEntity")
	public List<String>  getUniquePlanStatues();


	//public List<EligibilityDetailsEntity> findAll(Example of);  //need to check about this method
	

	
}


//we will go for find by method when we have to apply where condition in query 

//in this we have retrieve unique plan name so we used custom query 
