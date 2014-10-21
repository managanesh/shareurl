package com.sri.poc.entities;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Actor extends AbstractEntity {

	@RelatedTo(type = "topActor", direction = Direction.INCOMING)
    private Set<Movie> topActorIn;

    @RelatedTo(type = "ACTS_IN")
    private Set<Movie> movies;
}
