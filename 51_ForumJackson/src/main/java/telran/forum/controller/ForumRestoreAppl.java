package telran.forum.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.forum.model.Post;

public class ForumRestoreAppl {
	static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Map<String, Post> forum = mapper.readValue(new File("forum.json"), 
				new TypeReference<Map<String, Post>>() {
		});
		forum.forEach((k, v) -> System.out.println(k + " -> " + v));

	}

}
