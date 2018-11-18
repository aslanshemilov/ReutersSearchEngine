package com.h2o.content;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
public class ContentResource {

	@Autowired
	private ContentRepository contentRepository;

	@GetMapping("/list-content")
	public List<Content> retrieveAllStudents() {
		return contentRepository.findAll();
	}

//	@GetMapping("/search-content/{keyword}")
//	@ApiOperation(value = "Search Content by keyword",
//    notes = "Returns list search results that matches the keyword")
//	public Resource<Student> retrieveStudent(@PathVariable String keyword) {
//		Optional<Student> student = contentRepository.findById(keyword);
//
//		if (!student.isPresent())
//			throw new StudentNotFoundException("id-" + id);
//
//		Resource<Student> resource = new Resource<Student>(student.get());
//
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());
//
//		resource.add(linkTo.withRel("all-students"));
//
//		return resource;
//	}
//
//	@DeleteMapping("/students/{id}")
//	public void deleteStudent(@PathVariable long id) {
//		contentRepository.deleteById(id);
//	}
//
//	@PostMapping("/students")
//	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
//		Student savedStudent = contentRepository.save(student);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedStudent.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//
//	}
//	
//	@PutMapping("/students/{id}")
//	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
//
//		Optional<Student> studentOptional = contentRepository.findById(id);
//
//		if (!studentOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		student.setId(id);
//		
//		contentRepository.save(student);
//
//		return ResponseEntity.noContent().build();
//	}
}
