package com.modestack.Assignment.service;

import java.util.List;

import com.modestack.Assignment.entity.Article;
import com.modestack.Assignment.exception.helper.AssignmentServiceException;

public interface ArticleService {
	
	public List<Article> saveArticle(Article article) throws AssignmentServiceException;
	
	public List<Article> findAllArticles() throws AssignmentServiceException;

}
