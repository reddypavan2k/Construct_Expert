package org.servlet.resource;

import com.itextpdf.text.DocumentException;
import org.export.PDFExport;
import org.repository.ResourceRepository;
import org.repository.ResourceRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

@WebServlet(name = "ExportResources", value = "/ExportResources")
public class ExportResources extends HttpServlet {
    ResourceRepository resourceRepository = new ResourceRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        PDFExport pdfExport = new PDFExport();
        try {
            byteArrayInputStream = pdfExport.export(resourceRepository.getAllResource());
        } catch (DocumentException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Resources.pdf\"");
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = byteArrayInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        byteArrayInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}