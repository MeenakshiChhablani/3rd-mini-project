package in.ashokit.reports;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import in.ashokit.responsebinding.SearchResponse;

public class ExcelGenerator {
	/*
	 * public void generateExcel(List<SearchResponse> response, HttpServletResponse
	 * response) { HSSFWorkbook workBook = new HSSFWorkbook(); HSSFSheet sheet =
	 * workBook.createSheet("Plans"); HSSFRow headerRow = sheet.createRow(0);
	 * 
	 * headerRow.createCell(0).setCellValue("S No.");
	 * headerRow.createCell(1).setCellValue("Holder Name");
	 * headerRow.createCell(2).setCellValue("Holder SSN");
	 * headerRow.createCell(3).setCellValue("Plan Name");
	 * headerRow.createCell(4).setCellValue("Plan Status");
	 * headerRow.createCell(5).setCellValue("Start Date");
	 * headerRow.createCell(6).setCellValue("End Date");
	 * headerRow.createCell(7).setCellValue("Benefit Amount");
	 * headerRow.createCell(8).setCellValue("Denial Reason");
	 * 
	 * for(int i=1; i<response.size();i++ ){ HSSFRow dataRow = sheet.createRow(i +
	 * 1); SearchResponse record = response.get(i);
	 * dataRow.createCell(0).setCellValue(i + 1);
	 * dataRow.createCell(1).setCellValue(record.getHolderName());
	 * dataRow.createCell(2).setCellValue(record.getHolderSsn());
	 * dataRow.createCell(3).setCellValue(record.getPlanName());
	 * dataRow.createCell(4).setCellValue(record.getPlanStatus());
	 * dataRow.createCell(5).setCellValue(String.valueOf(record.getStartDate()));
	 * dataRow.createCell(6).setCellValue(String.valueOf(record.getEndDate()));
	 * dataRow.createCell(7).setCellValue(String.valueOf(record.getBenefirAmt()));
	 * dataRow.createCell(8).setCellValue(record.getDenialreason()); }
	 * 
	 * workBook.write(response.getOutputStream()); workBook.close(); }
	 */

	public void generateExcel(List<SearchResponse> response, HttpServletResponse httpResponse) throws Exception {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Plans");
		HSSFRow headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("S.No");
		headerRow.createCell(1).setCellValue("Holder Name");
		headerRow.createCell(2).setCellValue("Holder SSN");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benefit Amount");
		headerRow.createCell(8).setCellValue("Denial Reason");

		for (int i = 0; i < response.size(); i++) {
			HSSFRow dataRow = sheet.createRow(i + 1);
			SearchResponse record = response.get(i);
			dataRow.createCell(0).setCellValue(i + 1);

			if (record.getHolderName() != null)    // have to uncomment
				dataRow.createCell(1).setCellValue(record.getHolderName());

			if (record.getHolderSsn() != null) // have to uncomment
				dataRow.createCell(2).setCellValue(record.getHolderSsn());

			// if(record.getPlanName()!=null)                //added now have to comment
			dataRow.createCell(3).setCellValue(record.getPlanName());

			// if(record.getPlanName()!=null)          //added now have to comment
			dataRow.createCell(4).setCellValue(record.getPlanStatus());

			if (record.getStartDate() != null)// have to uncomment
				dataRow.createCell(5).setCellValue(String.valueOf(record.getStartDate()));

			if (record.getEndDate() != null)//// have to uncomment
				dataRow.createCell(6).setCellValue(String.valueOf(record.getEndDate()));

			if (record.getBenefirAmt() != null)// have to uncomment
				dataRow.createCell(7).setCellValue(String.valueOf(record.getBenefirAmt()));

			if (record.getDenialReason() != null)// have to uncomment
				dataRow.createCell(8).setCellValue(record.getDenialReason());
			
		}

		workbook.write(httpResponse.getOutputStream());
		workbook.close();
	}
}
