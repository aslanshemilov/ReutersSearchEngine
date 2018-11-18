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

/**
 * Returns a list of content related to query.
 * 
 * @author shilpakancharla
 */

@RestController
public class ContentResource {

	/** Database of content */
	@Autowired
	private ContentRepository contentRepository;

	/**
 	 * Retrieving requested data from database.
 	 *
	 * @return list of content requested
	 */

	@GetMapping("/list-content")
	public List<Content> retrieveAllStudents() {
		return contentRepository.findAll();
	}
}