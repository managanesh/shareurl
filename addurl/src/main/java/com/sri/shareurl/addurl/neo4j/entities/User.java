package com.sri.shareurl.addurl.neo4j.entities;


import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.sri.shareurl.addurl.neo4j.relationships.Shares;

@NodeEntity

public class User extends AbstractEntity {

	String name;

	String email; 

	@RelatedToVia(type = "SHARED_TO")
	Set<Shares> shares = new HashSet();
	
	public Shares Sharing(URL url, String scope){
		
		Shares shares = new Shares(this,url,scope);
		this.shares.add(shares);
		return shares;
	}
	
	public Set<Shares> getShares() {
		return shares;
	}

	public void setShares(Set<Shares> shares) {
		this.shares = shares;
	}

	public User(){
		super();
	}
	public User(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
