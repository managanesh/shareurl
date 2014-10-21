package com.sri.shareurl.addurl.neo4j.repo;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.sri.shareurl.addurl.neo4j.entities.URL;

public interface URLRepository extends GraphRepository<URL>{
	
}