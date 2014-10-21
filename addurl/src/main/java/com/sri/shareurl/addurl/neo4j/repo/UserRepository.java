package com.sri.shareurl.addurl.neo4j.repo;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.sri.shareurl.addurl.neo4j.entities.User;

/**
 * 
 * @author ganesh.vallabhaneni
 *
 */
public interface UserRepository extends GraphRepository<User>{

	public User findByName(String name);
	

}
