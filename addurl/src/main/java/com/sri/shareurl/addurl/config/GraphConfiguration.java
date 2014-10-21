package com.sri.shareurl.addurl.config;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author ganesh.vallabhaneni
 * 
 */
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "com.sri.shareurl.addurl.neo4j")
public class GraphConfiguration extends Neo4jConfiguration {
	Logger log = Logger.getLogger(getClass());
	
	public GraphConfiguration() {

		super.setBasePackage("com.sri.shareurl.addurl.neo4j.entities");
	}

	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() throws IOException {
		GraphDatabaseFactory f = new GraphDatabaseFactory();
		FileUtils.deleteRecursively(new File("target/test1.db"));
		return f.newEmbeddedDatabase("target/test1.db");
	}
	
	
	
	
}
