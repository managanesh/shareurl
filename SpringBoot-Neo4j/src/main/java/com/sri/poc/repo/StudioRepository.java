package com.sri.poc.repo;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.sri.poc.entities.Studio;
import com.sri.poc.entities.TestGroup;
/**
 * 
 * @author ganesh.vallabhaneni
 *
 */
public interface StudioRepository extends GraphRepository<Studio> {


	@Query("MATCH (m:Studio{name:\"test1\"}) return m")
	public Iterable<Studio> megaStudios();
	
	@Query("MATCH (g:TestGroup)"
			+ "RETURN g")
	public TestGroup getTestGroup();
}
