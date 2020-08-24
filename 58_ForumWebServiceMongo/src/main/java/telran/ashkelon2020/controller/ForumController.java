package telran.ashkelon2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.dto.PostDto;
import telran.ashkelon2020.dto.ResponseDto;
import telran.ashkelon2020.service.ForumService;

@RestController
public class ForumController {

	@Autowired
	ForumService forumService;
	

	@PostMapping("/forum/post/{author}")
	public ResponseDto addPost(@RequestBody PostDto postDto, @PathVariable String author) {
		return forumService.addPost(postDto, author);
	}

	@GetMapping("/forum/post/{id}")
	public ResponseDto findPostById(@PathVariable Integer id) {
		return forumService.findPost(id);

	}

	@DeleteMapping("/forum/post/{id}")
	public ResponseDto deletePost(@PathVariable Integer id) {
		return forumService.deletePost(id);

	}

	@PutMapping("/forum/post/{id}")
	public ResponseDto updatePost(@PathVariable Integer id, @RequestBody PostDto postDto) {
		return forumService.updatePost(id, postDto);

	}

}
	

