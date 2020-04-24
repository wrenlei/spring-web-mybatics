package com.sl.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sl.dao.ArticleDao;
import com.sl.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class ArticleServiceDaoTest {

	@Autowired
	private ArticleDao articleDao;
	
	@Test
	public void getAllListTest() {
		List<Article> list=articleDao.getAllList();
		for(Article article:list) {
			System.out.println(article.getContent());
		}
	}
	
	@Test
	public void getListByParamsTest() {
		Article article = new Article();
		article.setClassify("2");
		List<Article> list=articleDao.getListByParams(article);
		for(Article article2:list) {
			System.out.println(article2.getContent());
		}
	}
	
	/**
	 * 不写入数据库
	 */
	@Test
	@Transactional
	public void addTest() {
		Article article = new Article();
		article.setClassify("2");
		article.setTitle("标题");
		article.setContent("内容");
		articleDao.insert(article);
	}
	
	/**
	 * 写入数据库
	 */
	@Test
	public void addTest2() {
		Article article = new Article();
		article.setClassify("2");
		article.setTitle("标题");
		article.setContent("内容");
		articleDao.insert(article);
	}
}
