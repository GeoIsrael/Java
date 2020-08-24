package telran.ashkelon2020.service;

import telran.ashkelon2020.dto.PostDto;
import telran.ashkelon2020.dto.ResponseDto;

public interface ForumService {

	ResponseDto addPost (PostDto postDto, String author);
	ResponseDto findPost (int id);
	ResponseDto deletePost (int id);
	ResponseDto updatePost (int id, PostDto postDto);
	
}
