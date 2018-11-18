package com.h2o.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Query creation. Declare an interface, type it to domain class
 * and ID type it will handle.
 * 
 * @author shilpakancharla
 */

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>{

}
