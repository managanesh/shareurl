package com.sri.shareurl.addurl.services;

import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;

import com.sri.shareurl.addurl.neo4j.entities.URL;
import com.sri.shareurl.addurl.neo4j.entities.User;

public interface IfcURLService {

	public abstract URL addURL(String username, String scope, String url)
			throws IOException;

}