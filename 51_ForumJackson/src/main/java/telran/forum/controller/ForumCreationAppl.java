package telran.forum.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.forum.model.Comment;
import telran.forum.model.Post;

public class ForumCreationAppl {
	static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static void main(String[] args) throws JsonProcessingException {
		Map<String, Post> forum = new HashMap<>();
		Post post = new Post("Java EE", "Java is the best for backend", "JavaFan");
		forum.put(post.getId(), post);
		String json = mapper.writeValueAsString(forum);
		System.out.println(json);
		Comment comment = new Comment("Stranger", "Awesome!");
		forum.get(post.getId()).addComment(comment);
		forum.get(post.getId()).addLike();
		post = new Post("Hipe", "Hi!", "JavaFan");
		forum.put(post.getId(), post);
		json = mapper.writeValueAsString(forum);
		System.out.println(json);

	}

}
