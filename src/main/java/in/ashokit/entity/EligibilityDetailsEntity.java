package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ELIGIBILITY_DTLS")
public class EligibilityDetailsEntity {

	@Id
	@GeneratedValue
	@Column(name="ELIG_ID")
	private Integer planId;

/*	@Column(name="CASE_NUM")
	private Integer caseNum;
*/
	@Column(name="PLAN_NAME")
	private String planName;

	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="HOLDER_NAME")
	private String holderName;

	@Column(name="HOLDER_SSN")
	private Long holderSsn;

	@Column(name="BENEFIT_AMT")
	private Double benefirAmt;

	@Column(name="START_DATE")
	private LocalDate startDate;

	@Column(name="END_DATE")
	private LocalDate endDate;
	
	@Column(name="DENIAL_REASN")
    private String denialReason;

}
