package com.walmart.delivery;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * Configuration to initialize the Neo4J repositories
 *  
 * @author josemanzoli
 * @since 2014-09-20
 * 
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.walmart.delivery")
public class Neo4jConfig extends Neo4jConfiguration{


	public Neo4jConfig() {
        setBasePackage("com.walmart.delivery");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("accessingdataneo4j.db");
    }
	
}
