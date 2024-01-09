package com.example.school_management.controllers;

import com.example.school_management.entities.StudentEntity;
import com.example.school_management.services.PdfGenerationService;
import com.example.school_management.services.StudentService;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final PdfGenerationService pdfGenerationService;

    public StudentController(StudentService studentService, PdfGenerationService pdfGenerationService) {
        this.studentService = studentService;
        this.pdfGenerationService = pdfGenerationService;
    }

    @GetMapping("all")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity student){
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id,
                                                       @RequestBody StudentEntity student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{studentId}/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public void generatePdf(@PathVariable Long studentId,
                            HttpServletResponse response) throws IOException, DocumentException {
        StudentEntity student = studentService.getStudentById(studentId);

        if (student != null) {
            byte[] pdfBytes = pdfGenerationService.generatePdf(student);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=student_details.pdf");
            response.getOutputStream().write(pdfBytes);
        } else {
            // Handle case where student is not found
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
