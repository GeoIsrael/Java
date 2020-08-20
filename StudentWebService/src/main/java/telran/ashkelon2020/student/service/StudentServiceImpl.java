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
			return StudentResponseDto.builder()
					.id(id)
					.name(student.getName())
					.scores(student.getScores())
					.build();
		}
		
	}

	@Override
	public StudentResponseDto deleteStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDto updateStudent(int id, StudentUpdateDto studentUpdateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addScore(int id, ScoreDto scoreDto) {
		// TODO Auto-generated method stub
		return false;
	}

}
