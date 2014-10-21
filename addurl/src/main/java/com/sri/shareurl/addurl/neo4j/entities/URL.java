package com.sri.shareurl.addurl.neo4j.entities;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * 
 * @author ganesh.vallabhaneni
 * 
 */

@NodeEntity
public class URL extends AbstractEntity {

	String title;

	@Indexed(unique = true, indexType = IndexType.FULLTEXT,indexName = "URLPath")
	String path;

	@RelatedTo(type = "SHARED_TO")
	@Fetch Set<User> sharedBy;

	public URL(){
		super();
	}
	public URL(String title,String path){
		this.title = title;
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<User> getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(Set<User> sharedBy) {
		this.sharedBy = sharedBy;
	}

}
