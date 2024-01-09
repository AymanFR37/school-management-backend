package com.example.school_management.services;

import com.example.school_management.entities.AttendanceEntity;
import com.example.school_management.enums.AttendanceStatus;
import com.itextpdf.text.DocumentException;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    void recordAttendance(Long studentId, LocalDate date, AttendanceStatus attendanceStatus);
    List<AttendanceEntity> getStudentAttendance(Long studentId);

    byte[] exportAttendanceReportToPdf(String startDate, String endDate, Long sectionId) throws DocumentException;
}
