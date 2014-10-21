package com.sri.shareurl.addurl.test.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sri.shareurl.addurl.config.AddURLApplication;
import com.sri.shareurl.addurl.neo4j.entities.URL;
import com.sri.shareurl.addurl.neo4j.entities.User;
import com.sri.shareurl.addurl.neo4j.relationships.Shares;
import com.sri.shareurl.addurl.neo4j.repo.SharesRepository;
import com.sri.shareurl.addurl.neo4j.repo.URLRepository;
import com.sri.shareurl.addurl.neo4j.repo.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AddURLApplication.class })
public class AbstractTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	URLRepository urlRepository;
	
	@Autowired
	SharesRepository sharesRepository;
	
	@Before
	public void setup() throws IOException {

		User user = new User("user1", "user@c.m");
		URL url = new URL("TestURL", "http://google.com");
		Shares shares = user.Sharing(url, "public");
		urlRepository.save(url);
		userRepository.save(user);
	}

	
	
}
