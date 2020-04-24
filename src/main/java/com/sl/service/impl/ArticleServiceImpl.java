package com.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.dao.ArticleDao;
import com.sl.entity.Article;
import com.sl.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public void add(Article article) {
		articleDao.insert(article);
	}

	@Override
	public void delete(Integer id) {
		articleDao.delete(id);
	}

	@Override
	public Article getById(Integer id) {
		return articleDao.getById(id);
	}

	@Override
	public List<Article> getListByParams(Article article) {
		return articleDao.getListByParams(article);
	}

	@Override
	public List<Article> getAllList() {
		return articleDao.getAllList();
	}

	@Override
	public void update(Article article) {
		articleDao.update(article);
	}

}
