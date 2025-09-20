package org.export;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.model.Resource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PDFExport {

    public ByteArrayInputStream export(List<Resource> resources) throws DocumentException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(11);

        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100);
        table.addCell("ID");
        table.addCell("Title");
        table.addCell("Type");
        table.addCell("Provider");
        table.addCell("Acquisition Date");
        table.addCell("Quantity");
        table.addCell("Availability");
        table.addCell("Resource Type");

        for (Resource resource : resources) {
            table.addCell(String.valueOf(resource.getId()));
            table.addCell(resource.getTitle());
            table.addCell(resource.getType());
            table.addCell(resource.getProvider());
            table.addCell(String.valueOf(resource.getAcquisitionDate()));
            table.addCell(resource.getQuantity());
            table.addCell(String.valueOf(resource.getAvailability()));
            table.addCell(String.valueOf(resource.getResourceType()));
        }

        document.add(new Paragraph("Resources :", font));
        document.add(table);
        document.close();

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}