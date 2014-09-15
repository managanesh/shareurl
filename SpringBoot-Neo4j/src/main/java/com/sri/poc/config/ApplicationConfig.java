package com.sri.poc.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring JavaConfig configuration class to setup a Spring container and infrastructure components.
 */
@Configuration
@ComponentScan(basePackages={"com.sri.poc"})
@EnableTransactionManagement
@EnableNeo4jRepositories("com.sri.poc.repo")

class ApplicationConfig extends Neo4jConfiguration {

	public ApplicationConfig(){
		super.setBasePackage("com.sri.poc");
	}
	
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		GraphDatabaseFactory f = new GraphDatabaseFactory();

		return f.newEmbeddedDatabase("target/graph.db");
	}

	
	 
}
