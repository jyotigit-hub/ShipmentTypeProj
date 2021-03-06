package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.ShipmentType;

public class ShipmentTypeExcleView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Sheet s=workbook.createSheet("ShipmentType");
		 setHeader(s);
		 @SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		 setBody(s,list);

	}

	private void setBody(Sheet s, List<ShipmentType> list) {
		int count=1;
		for(ShipmentType st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getShipId());
			r.createCell(1).setCellValue(st.getShipMode());
			r.createCell(2).setCellValue(st.getShipCode());
			r.createCell(3).setCellValue(st.getEnbShip());
			r.createCell(4).setCellValue(st.getShipGrade());
			r.createCell(5).setCellValue(st.getShipDesc());
	
			
		}
		
	}

	private void setHeader(Sheet s) {
		//create one row in sheet
		Row r=s.createRow(0);
		//create cell in row
		r.createCell(0).setCellValue("shipId");
		r.createCell(1).setCellValue("shipMode");
		r.createCell(2).setCellValue("shipCode");
		r.createCell(3).setCellValue("enbShip");
		r.createCell(4).setCellValue("shipGrade");
		r.createCell(5).setCellValue("shipDesc");
	
		
	}



	
		
	}

	
