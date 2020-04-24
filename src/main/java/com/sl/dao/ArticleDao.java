package com.sl.dao;

import java.util.List;

import com.sl.entity.Article;

public interface ArticleDao {
	
	void insert(Article article);
	void delete(Integer id);
	Article getById(Integer id);
	List<Article> getListByParams(Article article);
	List<Article> getAllList();
	void update(Article article);
	
}
