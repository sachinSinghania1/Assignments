package com.modestack.Assignment.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modestack.Assignment.entity.Article;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;
import com.modestack.Assignment.repository.ArticleRepository;
import com.modestack.Assignment.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Autowired
	ArticleRepository articleRepo;

	@Override
	public List<Article> saveArticle(Article article) throws AssignmentServiceException {
		LOGGER.info("Inside the method of saveArticle()");
		try {
			articleRepo.save(article);
			LOGGER.info("Exit from the method of saveArticle()");
		}
		catch(Exception ex) {
			LOGGER.info("Exception occured in the method saveArticle() " +ex.getMessage());
			throw new AssignmentServiceException("Unable to add Article");
		}
		
		return null;
	}

	@Override
	public List<Article> findAllArticles() throws AssignmentServiceException {
		LOGGER.info("Inside the method of findAllArticles()");
		try {
			articleRepo.findAll();
			LOGGER.info("Exit from the method of findAllArticles()");
		}
		catch(Exception ex) {
			LOGGER.info("Exception occured in the method findAllArticles() " +ex.getMessage());
			throw new AssignmentServiceException("Unable to find Article");
		}
		
		return articleRepo.findAll();
	}

}
