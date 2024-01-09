package com.example.school_management.services;

import com.example.school_management.entities.AttendanceEntity;
import com.example.school_management.entities.StudentEntity;
import com.example.school_management.enums.AttendanceStatus;
import com.example.school_management.repositories.AttendanceRepository;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    private final AttendanceRepository attendanceRepository;
    private final StudentService studentService;
    private PdfGenerationService pdfGenerationService;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, StudentService studentService, PdfGenerationService pdfGenerationService) {
        this.attendanceRepository = attendanceRepository;
        this.studentService = studentService;
        this.pdfGenerationService = pdfGenerationService;
    }

    @Override
    public void recordAttendance(Long studentId, LocalDate date, AttendanceStatus attendanceStatus) {
        StudentEntity student = studentService.getStudentById(studentId);
        if (student != null){
            AttendanceEntity attendance = new AttendanceEntity(student,date,attendanceStatus);
            attendanceRepository.save(attendance);
        }
    }

    @Override
    public List<AttendanceEntity> getStudentAttendance(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    public byte[] exportAttendanceReportToPdf(String startDate, String endDate, Long sectionId) throws DocumentException {
        List<AttendanceEntity> attendanceList = attendanceRepository.findByDateBetweenAndSection(startDate, endDate, sectionId);
        return pdfGenerationService.generatePdf(attendanceList);
    }
}
