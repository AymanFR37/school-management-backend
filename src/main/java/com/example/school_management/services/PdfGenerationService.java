package com.example.school_management.services;

import com.example.school_management.entities.AttendanceEntity;
import com.example.school_management.entities.StudentEntity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfGenerationService {
    public byte[] generatePdf(StudentEntity student) throws DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("Student Details"));
            document.add(new Paragraph("ID: " + student.getId()));
            document.add(new Paragraph("Name: " + student.getFirstName() + " " + student.getLastName()));
            // Add more details as needed

        } finally {
            document.close();
        }

        return outputStream.toByteArray();
    }

    public byte[] generatePdf(List<AttendanceEntity> attendanceList) throws DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();

            document.add(new Paragraph("Attendance Report"));

            for (AttendanceEntity attendance : attendanceList) {
                document.add(new Paragraph("Date: " + attendance.getDate()));
                document.add(new Paragraph("Status: " + attendance.getAttendanceStatus()));
                // Add more details as needed
                document.add(new Paragraph("\n")); // Add a new line for separation
            }
        } finally {
            document.close();
        }

        return outputStream.toByteArray();
    }
}
