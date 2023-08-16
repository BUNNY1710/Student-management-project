package com.tenant.RoomMate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenant.RoomMate.exception.StudentNotFoundException;
import com.tenant.RoomMate.model.Student;
import com.tenant.RoomMate.repository.StudentRepository;

import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student getStudent(int id)
	{
		Optional<Student> optionStudent = studentRepository.findById(id);
		if(optionStudent.isEmpty())
		{
			throw new StudentNotFoundException("There is no student of this id :" + id);
		}
		return studentRepository.findById(id).get();
	}
	
	public Student editStudent(int id, Student student)
	{
		Student savedstudent = studentRepository.findById(id).get();
		savedstudent.setFirstname(student.getFirstname());
		savedstudent.setLastname(student.getLastname());
		savedstudent.setEmail(student.getEmail());
		return studentRepository.save(savedstudent);
	}
	
	public void deleteStudent(int id)
	{
		Optional<Student> student1 = studentRepository.findById(id);
		if(student1.isEmpty())
		{
			throw new StudentNotFoundException("This student already deleted");
		}
		
		studentRepository.deleteById(id);
		
		
	}
	
	public List<Student> allStudent()
	{
		return studentRepository.findAll();
	}
	
	
	
//	ui
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public Student getStudentById(int id)
	{
		return studentRepository.findById(id).get();
	}
	
	public Student updateStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public void delStudent(int id)
	{
		studentRepository.deleteById(id);
	}
	
}
