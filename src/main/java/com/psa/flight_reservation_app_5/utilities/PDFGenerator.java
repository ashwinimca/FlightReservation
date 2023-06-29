package com.psa.flight_reservation_app_5.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.psa.flight_reservation_app_5.entity.Reservation;

@Component
public class PDFGenerator {
//	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
//	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public void generateItinerary(Reservation reservation, String filePath) {
		Document document = new Document();
		try {

			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			document.open();
			document.add(generateTable(reservation));
			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());

		table.addCell("Operating Airline");
		table.addCell(reservation.getFlight().getOperatingAirline());

		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());

		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLasttName());

		table.addCell("Middle Name");
		table.addCell(reservation.getPassenger().getMiddletName());

		table.addCell("Contact Number");
		table.addCell(reservation.getPassenger().getPhone());

		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());

		return table;
	}

	public void generatePDF(String filePath, String name, String emailId, String phone, String operatingAirlines,
			String departureDate, String departureCity, String arrivalCity) {

	}

//	private static void addTitleAndTable(Document document, String name, String emailId, String phone,
//			String operatingAirlines, String departureDate, String departureCity, String arrivalCity)
//			throws DocumentException {
//		Paragraph preface = new Paragraph();
//		preface.add(new Paragraph("Flight Booking Details", catFont));
//		preface.add(
//				new Paragraph("Report generated by: " + "Flight Reservation Company" + ", " + new Date(), smallBold));
//		document.add(preface);
//		document.add(Chunk.NEWLINE);
//		document.add(Chunk.NEWLINE);
//
//		PdfPCell c1 = new PdfPCell(new Phrase("Passenger Details"));
//		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//		c1.setColspan(2);
//		table.addCell(c1);
//		table.addCell("Passenger name");
//		table.addCell(name);
//		table.addCell("Email Id");
//		table.addCell(emailId);
//		table.addCell("Phone Number");
//		table.addCell(phone);
//		table.addCell(table);
//
//		PdfPTable table1 = new PdfPTable(2);
//		table1.setWidthPercentage(100);
//
//		PdfPCell c2 = new PdfPCell(new Phrase("Flight Details"));
//		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
//		c2.setColspan(2);
//		table1.addCell(c2);
//		table1.addCell("Operating Airlines");
//		table1.addCell(operatingAirlines);
//		table1.addCell("Departure Date");
//		table1.addCell(departureDate);
//		table1.addCell("Departure City");
//		table1.addCell(departureCity);
//		table1.addCell("Arrival City");
//		table1.addCell(arrivalCity);
//		document.add(table1);
//		document.close();
//
//	}
//
//	private static void addMetaData(Document document) {
//		document.addTitle("My First pdf");
//		document.addSubject("Using iText");
//		document.addKeywords("Java, PDF, iText");
//		document.addAuthor("Lars Vogel");
//		document.addCreator("Lars Vogel");
//	}
}
