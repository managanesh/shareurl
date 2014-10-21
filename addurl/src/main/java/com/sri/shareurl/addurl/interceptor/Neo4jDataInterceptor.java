package com.sri.shareurl.addurl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sri.shareurl.addurl.neo4j.entities.User;
import com.sri.shareurl.addurl.neo4j.repo.UserRepository;


public class Neo4jDataInterceptor extends HandlerInterceptorAdapter {

	Logger log = Logger.getLogger(getClass());
	
	public Neo4jDataInterceptor(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	UserRepository userRepository;

	@Override
	@Transactional
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		log.info("Handler::"+handler.getClass());
		User user = userRepository.findByName("Ganesh");

		if (user == null) {
			user = new User("Ganesh", "G@G.C");
			userRepository.save(user);
			log.info("default user created");
		}
		
		return super.preHandle(request, response, handler);
	}

}
