package telran.ashkelon2020.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.dao.ForumRepositoryMongoDB;
import telran.ashkelon2020.dto.PostDto;
import telran.ashkelon2020.dto.ResponseDto;
import telran.ashkelon2020.dto.exceptions.PostNotFoundException;
import telran.ashkelon2020.model.Post;

@Service
public class forumServiceImpl implements ForumService {

	private Integer currentPostNumber = 0;
	
	@Autowired
	ForumRepositoryMongoDB forumRepository;
	

	
	
	@Override
	public ResponseDto addPost(PostDto postDto, String author) {
//		currentPostNumber = forumRepository.findLastPostNumber();    //читаем из базы ID пследнего сохраненного поста
		currentPostNumber += 1;
		Post post = new Post(currentPostNumber, author, postDto.getTitle(), postDto.getContent(), postDto.getTags());
		if (forumRepository.existsById(post.getId())) {
			return null;
		}else {
			forumRepository.save(post);
		return convertPostToResponseDto(post);
		}
	}

		
	@Override
	public ResponseDto findPost(int id) {
		Post post = forumRepository.findById(id).orElseThrow(()-> new PostNotFoundException(id));
		return convertPostToResponseDto(post);
	}
	
	
	
	@Override
	public ResponseDto deletePost(int id) {
		Post post = forumRepository.findById(id).orElseThrow(()-> new PostNotFoundException(id));
		forumRepository.delete(post);
		return convertPostToResponseDto(post);
	}
	
	
	
	@Override
	public ResponseDto updatePost(int id, PostDto postDto) {
		Post post = forumRepository.findById(id).orElseThrow(()-> new PostNotFoundException(id));
		String author = post.getAuthor();
		forumRepository.delete(post);
		Post updatedPost = new Post(id, author, postDto.getTitle(), postDto.getContent(), postDto.getTags());
		updatedPost.setId(id);
		forumRepository.save(updatedPost);
		return convertPostToResponseDto(updatedPost);
		}
		
		
	
	private ResponseDto convertPostToResponseDto(Post post) {
		return ResponseDto.builder()
				.id(post.getId())
				.title(post.getTitle())
				.content(post.getContent())
				.author(post.getAuthor())
				.dateTime(post.getDateTime())
				.tags(post.getTags())
				.likes(post.getLikes())
				.comments(post.getComments())
				.build();
	}



}
