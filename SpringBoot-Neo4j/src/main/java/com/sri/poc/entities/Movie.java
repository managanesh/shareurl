package com.sri.poc.entities;

import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Movie extends AbstractEntity {

	private Actor topActor;
}
