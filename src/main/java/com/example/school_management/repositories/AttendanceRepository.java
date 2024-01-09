package com.example.school_management.repositories;

import com.example.school_management.entities.AttendanceEntity;
import com.example.school_management.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Long> {
    List<AttendanceEntity> findByStudentId(Long studentId);

    @Query(value = "select a from AttendanceEntity a join a.sectionEntity s " +
            "where s.id=:sectionId AND a.date between :startDate and :endDate")
    List<AttendanceEntity> findByDateBetweenAndSection(String startDate, String endDate, Long sectionId);
}
