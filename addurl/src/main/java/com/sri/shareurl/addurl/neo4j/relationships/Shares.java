package com.sri.shareurl.addurl.neo4j.relationships;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.sri.shareurl.addurl.neo4j.entities.AbstractEntity;
import com.sri.shareurl.addurl.neo4j.entities.URL;
import com.sri.shareurl.addurl.neo4j.entities.User;

@RelationshipEntity(type = "SHARED_TO")
public class Shares extends AbstractEntity {

	@StartNode
	User user;
	
	@EndNode
	URL url;

	String scope;
	
	public Shares(){
		
	}
	
	public Shares(User user,URL url, String scope){
		this.user = user;
		this.url = url;
		this.scope = scope;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
