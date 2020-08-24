package telran.ashkelon2020.student.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.repository.PagingAndSortingRepository;

import telran.ashkelon2020.student.model.Student;

public interface StudentRepositoryMongoDB extends PagingAndSortingRepository<Student, Integer> {
	
		Stream<Student> findByName(String name);
		
		Stream<Student> findByNameAndIdGreaterThan(String name, int minId);
}
