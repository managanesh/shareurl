package com.sri.shareurl.addurl.neo4j.repo;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.sri.shareurl.addurl.neo4j.relationships.Shares;

/**
 * 
 * @author ganesh.vallabhaneni
 *
 */
public interface SharesRepository extends GraphRepository<Shares>{

	

}
