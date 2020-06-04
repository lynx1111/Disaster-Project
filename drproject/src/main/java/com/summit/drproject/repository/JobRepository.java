package com.summit.drproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.drproject.entity.Job;



@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
