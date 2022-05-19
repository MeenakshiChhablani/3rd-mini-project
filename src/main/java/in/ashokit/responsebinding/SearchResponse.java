package in.ashokit.responsebinding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {

	//private Long caseNumber;
	private String planName;
	private String planStatus;
	private Double benefirAmt;
	private LocalDate startDate;
	private LocalDate endDate;
	private String denialReason;
	private String holderName;
	private Long holderSsn;

}
