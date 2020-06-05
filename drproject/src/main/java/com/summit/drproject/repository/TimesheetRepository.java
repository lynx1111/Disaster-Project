<<<<<<< HEAD
package com.summit.drproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summit.drproject.entity.Timesheet;


public interface TimesheetRepository extends JpaRepository<Timesheet, Long>{

}
=======
package com.summit.drproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summit.drproject.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet,String> {

}
>>>>>>> dc7e47f18f2776b8ef4c40e84eea71c2b166de95
