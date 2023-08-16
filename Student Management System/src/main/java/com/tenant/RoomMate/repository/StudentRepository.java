package com.tenant.RoomMate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenant.RoomMate.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
