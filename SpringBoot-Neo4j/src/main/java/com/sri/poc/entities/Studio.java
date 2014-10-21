package com.sri.poc.entities;

import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Studio extends AbstractEntity {
	
	
	String name;

	public Studio(){
		
	}
	public Studio(String name) {
		this.name = name;
	}



}