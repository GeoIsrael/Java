package telran.ashkelon2020.student.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import telran.ashkelon2020.student.model.Student;

@Component
public class StudentRepositoryImpl implements StudentRepository {
	Map<Integer, Student> students = new ConcurrentHashMap<>();

	@Override
	public boolean addStudent(Student student) {
		return students.putIfAbsent(student.getId(), student) == null;
	}

	@Override
	public Student findStudentById(int id) {
		return students.get(id);
	}

	@Override
	public Student deleteStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(int id, String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addScore(int id, String exam, int score) {
		// TODO Auto-generated method stub
		return false;
	}

}
