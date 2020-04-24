package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.web.response.Result;
import com.sl.entity.Article;
import com.sl.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Result add(Article article) {
		try {
			articleService.add(article);
			return new Result("添加成功！");
		} catch (Exception e) {
			return new Result("500","添加失败"+e);
		}
	}
	 
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(Integer id) {
		try {
			articleService.delete(id);
			return new Result("删除成功！");
		} catch (Exception e) {
			return new Result("500","删除失败！"+e);
		}
	}

	@RequestMapping("/getById")
	@ResponseBody
	public Article getById(Integer id) {
		return articleService.getById(id);
	}

	@RequestMapping("/getListByParams")
	@ResponseBody
	public List<Article> getListByParams(Article article) {
		return articleService.getListByParams(article);
	}

	@RequestMapping("/getAllList")
	@ResponseBody
	public List<Article> getAllList() {
		return articleService.getAllList();
	}

	@RequestMapping("/update")
	@ResponseBody
	public Result update(Article article) {
		try {
			articleService.update(article);
			return new Result("修改成功！");
		} catch (Exception e) {
			return new Result("500","修改失败！"+e);
		}
	}
	
    @RequestMapping(value = "detail")
    public String detail(Integer id, Model model) {
    	Article article = articleService.getById(id);
        model.addAttribute("article", article);
        return "page/detail";
    }
	
}
