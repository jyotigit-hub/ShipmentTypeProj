package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.ShipmentType;




public class ShipmentTypePdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	Paragraph p=new Paragraph("ShipmentType DATA in PDF Format");
	response.addHeader("Content-Disposition", "attachment;filename=ShipmentType.pdf") ;
	document.add(p);
	PdfPTable t=new PdfPTable(6);
	t.addCell("shipId");
	t.addCell("shipMode");
	t.addCell("shipCode");
	t.addCell("enbShip");
	t.addCell("shipGrade");
	t.addCell("shipDesc");
	List<ShipmentType> list=(List<ShipmentType>) model.get("list");
	for(ShipmentType st:list) {
		t.addCell(st.getShipId().toString());
		t.addCell(st.getShipMode());
		t.addCell(st.getShipCode());
		t.addCell(st.getEnbShip());
		t.addCell(st.getShipGrade());
		t.addCell(st.getShipDesc());
		
	}
	//add element to document
	document.add(t);
	Paragraph p1=new Paragraph(new Date().toString());	
	document.add(p1);
	}

	

}
