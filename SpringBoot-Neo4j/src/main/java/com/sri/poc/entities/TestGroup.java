package com.sri.poc.entities;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.Query;

@NodeEntity
public class TestGroup extends AbstractEntity{

	@Query("MATCH (m:Studio{name:\"test1\"}) return m")
	public Iterable<Studio> megaStudios;
}
