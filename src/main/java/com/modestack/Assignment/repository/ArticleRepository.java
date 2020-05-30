package com.modestack.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modestack.Assignment.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	//public List<Article> findAll();

}
