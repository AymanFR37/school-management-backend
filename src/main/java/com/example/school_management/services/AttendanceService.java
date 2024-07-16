package com.example.school_management.services;

import com.example.school_management.entities.AttendanceEntity;
import com.example.school_management.enums.AttendanceStatus;
import com.itextpdf.text.DocumentException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AttendanceService {
    void recordAttendance(UUID studentId, LocalDate date, AttendanceStatus attendanceStatus);

    List<AttendanceEntity> getStudentAttendance(UUID studentId);

    byte[] exportAttendanceReportToPdf(String startDate, String endDate, UUID sectionId) throws DocumentException;
}
