package com.sri.shareurl.addurl.test.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sri.shareurl.addurl.neo4j.entities.User;
import com.sri.shareurl.addurl.neo4j.relationships.Shares;

public class RelationshipTest extends AbstractTest {

	Logger log = Logger.getLogger(getClass());

	@Test
	@Transactional
	public void testSaveUser() {
		Result<User> userResult = userRepository.findAll();
		User user = userResult.single();

		assertNotNull(user.getId());
		assertTrue(!user.getShares().isEmpty());

	}

	@Test
	@Transactional
	@Rollback(false)
	public void testPublicAccessAndUpdate() throws IOException {
		Result<User> userResult = userRepository.findAll();
		User user = userResult.single();
		log.info("User Retrieved::" + user.getName());
		user.getShares().forEach(new Consumer<Shares>() {
			public void accept(Shares t) {
				assertTrue(t.getScope().equalsIgnoreCase("public"));
				log.info("Scope for URL is::beforeSave" + t.getScope());
				t.setScope("private");

				t = sharesRepository.save(t);

				log.info("Scope for URL is::afterSave" + t.getScope());
			};
		});

	}

	@Test
	@Transactional
	public void testURLSharedWithPublic() throws IOException {

		Result<User> userResult = userRepository.findAll();
		User user = userResult.iterator().next();
		user.getShares().forEach(new Consumer<Shares>() {
			public void accept(Shares t) {
				assertTrue(!t.getScope().equalsIgnoreCase("public"));

			};
		});

	}

}
