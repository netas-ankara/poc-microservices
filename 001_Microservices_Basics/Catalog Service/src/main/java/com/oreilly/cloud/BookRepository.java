package com.oreilly.cloud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="book", collectionResourceRel="book")
public interface BookRepository extends JpaRepository<Book, Long> {

	@RestResource(rel="title", path="title")
	List<Book> findByTitle(@Param("title") String title);
		
}
