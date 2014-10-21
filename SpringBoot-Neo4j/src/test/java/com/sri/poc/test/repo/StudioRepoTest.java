package com.sri.poc.test.repo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.Test;

import com.sri.poc.entities.Studio;
import com.sri.poc.entities.TestGroup;
import com.sri.poc.test.AbstractTest;
public class StudioRepoTest extends AbstractTest{

	@Test
	public void testHashCheckBeforeAndAfterSave(){
		Set<Studio> studios = new HashSet<Studio>();
		Studio studioDetach = new Studio("Ghibli");
		studios.add(studioDetach);
		
		Studio studio = studioRepository.save(studioDetach);
		studios.add(studio);
		assertThat(studios.size()==2,is(true));
		
		Studio sameStudio = studioRepository.findOne(studio.getId());
		assertThat(studio, is(equalTo(studioDetach)));
		assertThat(studios.contains(studioDetach), is(true));
		assertThat(studios.remove(studioDetach), is(true));
	}
	
	
	
	
	@Test
	public void testStudioGroup(){
		
		
		Iterable<Studio> iter=studioRepository.megaStudios();
		iter.forEach(new Consumer<Studio>(){

			@Override
			public void accept(final Studio t) {
				System.out.println(t);
			}
			
		});
		
	}
	
	@Test
	public void testGroup(){
		
		
		TestGroup group=studioRepository.getTestGroup();
		group.megaStudios.forEach(new Consumer<Studio>(){

			@Override
			public void accept(final Studio t) {
				System.out.println(t);
			}
			
		});
	}
}
