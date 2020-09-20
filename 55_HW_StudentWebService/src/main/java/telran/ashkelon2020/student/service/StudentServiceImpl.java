package telran.ashkelon2020.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.ashkelon2020.student.dao.StudentRepository;
import telran.ashkelon2020.student.dto.ScoreDto;
import telran.ashkelon2020.student.dto.StudentDto;
import telran.ashkelon2020.student.dto.StudentResponseDto;
import telran.ashkelon2020.student.dto.StudentUpdateDto;
import telran.ashkelon2020.student.model.Student;

@Component
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public boolean addStudent(StudentDto studentDto) {
		Student student = new Student(studentDto.getId(), studentDto.getName(), studentDto.getPassword());
		return studentRepository.addStudent(student);
	}

	@Override
	public StudentResponseDto findStudent(int id) {
		Student student = studentRepository.findStudentById(id);
		if (student == null) {
			return null;
		}else {
			return convertStudentToStudentResponseDto(student);
		}
		
	}

	@Override
	public StudentResponseDto deleteStudent(int id) {
		Student student = studentRepository.deleteStudent(id);
		if (student == null) {
			return null;
		}
		return convertStudentToStudentResponseDto(student);
	}

	private StudentResponseDto convertStudentToStudentResponseDto(Student student) {
		return StudentResponseDto.builder()
				.id(student.getId())
				.name(student.getName())
				.scores(student.getScores())
				.build();
	}

	@Override
	public StudentDto updateStudent(int id, StudentUpdateDto studentUpdateDto) {
		Student student = studentRepository.findStudentById(id);
		if (student == null) {
			return null;
		}
		String name = studentUpdateDto.getName();
		if (name == null) {
			name = student.getName();
		}
		String password = studentUpdateDto.getPassword();
		if (password == null) {
			password = student.getPassword();
		}
		return convertStudentToStudentDto(studentRepository.updateStudent(id, name, password));
	}

	private StudentDto convertStudentToStudentDto(Student student) {
		return StudentDto.builder()
				.id(student.getId())
				.name(student.getName())
				.password(student.getPassword())
				.build();
	}

	@Override
	public boolean addScore(int id, ScoreDto scoreDto) {
		return studentRepository.addScore(id, scoreDto.getExamName(), scoreDto.getScore());
	}

}
