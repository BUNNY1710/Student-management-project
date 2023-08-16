package com.tenant.RoomMate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenant.RoomMate.model.Student;
import com.tenant.RoomMate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add-student")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@GetMapping("/get-student/{id}")
	public Student getStudent(@PathVariable("id") int id)
	{
		return studentService.getStudent(id);
	}
	
	@PutMapping("/update-student/{id}")
	public Student editStudent(@PathVariable("id") int id, @RequestBody Student student)
	{
		return studentService.editStudent(id, student);
	}
	
	@DeleteMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		studentService.deleteStudent(id);
		return "Deleted Successfully";
	}
	
	@GetMapping("/all-student")
	public List<Student> allStudent()
	{
		return studentService.allStudent();
	}
	
}
