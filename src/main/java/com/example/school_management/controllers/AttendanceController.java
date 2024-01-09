package com.example.school_management.controllers;

import com.example.school_management.entities.AttendanceEntity;
import com.example.school_management.enums.AttendanceStatus;
import com.example.school_management.services.AttendanceService;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/recordAttendance")
    public ResponseEntity<Void> recordAttendance(@RequestBody Long studentId,
                                           @RequestBody LocalDate date,
                                           @RequestBody AttendanceStatus attendanceStatus){
        attendanceService.recordAttendance(studentId, date, attendanceStatus);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student/{studentId}")
    public List<AttendanceEntity> getStudentAttendance(@PathVariable Long studentId) {
        return attendanceService.getStudentAttendance(studentId);
    }

    @GetMapping(value = "/export-pdf", produces = "application/pdf")
    public ResponseEntity<byte[]> exportAttendanceReportToPdf(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) Long sectionId) throws DocumentException {
        byte[] pdfContent = attendanceService.exportAttendanceReportToPdf(startDate, endDate, sectionId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=attendance_report.pdf");

        return new ResponseEntity<>(pdfContent, headers, org.springframework.http.HttpStatus.OK);
    }
}
