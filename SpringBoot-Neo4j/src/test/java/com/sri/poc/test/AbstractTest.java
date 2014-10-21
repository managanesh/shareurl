package com.sri.poc.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sri.poc.config.ApplicationConfig;
import com.sri.poc.entities.Studio;
import com.sri.poc.repo.StudioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class })
@Transactional
public class AbstractTest {

	@Autowired
	protected 	StudioRepository 		studioRepository;
	
	@Before
	public void setup(){
		Studio studio = new Studio("test1");
		Studio studio1 = new Studio("test1");
		
		studioRepository.save(studio);
		studioRepository.save(studio1);
	}
}
