package com.modestack.Assignment.controller;

import java.util.List;

import org.hibernate.JDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.modestack.Assignment.entity.Article;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;
import com.modestack.Assignment.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	ArticleService articleService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String createArticle(@RequestBody Article article) {
		LOGGER.info("Inside the method of createArticle()");
		
		try {
			articleService.saveArticle(article);
			LOGGER.info("Exit from the method of createArticle()");
			return "new article created";
		}
		catch(JDBCException ex) {
			LOGGER.info("Exception Occured at the method createArticle()"  + ex.getMessage());
			return "Unable to add Article";
		}
		catch(AssignmentServiceException ex) {
			LOGGER.info("Exception Occured at the method createArticle()"  + ex.getMessage());
			return "Unable to add Article";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Article> showArticles() throws AssignmentServiceException {
		LOGGER.info("Inside the method of showArticles()");
		
		try {
			articleService.findAllArticles();
			LOGGER.info("Exit from the method of showArticles()");
		}
		catch(JDBCException ex) {
			LOGGER.info("Exception Occured at the method createArticle()"  + ex.getMessage());
		}
		catch(AssignmentServiceException ex) {
			LOGGER.info("Exception Occured at the method createArticle()"  + ex.getMessage());
		}
		return articleService.findAllArticles();
	}
}
