package com.tenant.RoomMate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tenant.RoomMate.model.Student;
import com.tenant.RoomMate.service.StudentService;

@Controller
public class UiController {
	
	@Autowired
	private StudentService studentService;
	

//	public UiController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}

	
	@GetMapping("/all-student")
	public String listStudent(Model model)
	{
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/student/new")
	public String addStudent(Model model)
	{
		// Create a student object for hold student data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/student")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.createStudent(student);
		return "redirect:/all-student";
	}
	
	@GetMapping("/student/edit/{id}")
	public String editStudentForm(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable("id") int id, @ModelAttribute("student") Student student, Model model)
	{
		Student savedstudent = studentService.getStudentById(id);
		savedstudent.setFirstname(student.getFirstname());
		savedstudent.setLastname(student.getLastname());
		savedstudent.setEmail(student.getEmail());
		
		studentService.updateStudent(savedstudent);
		return "redirect:/all-student";
	}
	
	@GetMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		studentService.delStudent(id);
		return "redirect:/all-student";
	}
	
}