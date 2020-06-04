package com.summit.drproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summit.drproject.entity.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {

}
