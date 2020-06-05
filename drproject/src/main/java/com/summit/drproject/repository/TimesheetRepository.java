package com.summit.drproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summit.drproject.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet,String> {

}
