package telran.ashkelon2020.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.ashkelon2020.model.Post;

public interface ForumRepositoryMongoDB extends MongoRepository<Post, Integer> {

	@Query("{'scores.?0':{'$gte':?1}}")
	Integer findLastPostNumber(); 
	
}
