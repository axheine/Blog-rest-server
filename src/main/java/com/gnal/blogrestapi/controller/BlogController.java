package com.gnal.blogrestapi.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnal.blogrestapi.ArticleMockedData;
import com.gnal.blogrestapi.model.Article;

@RestController
public class BlogController {
	private ArticleMockedData articleMockedData = ArticleMockedData.getInstance();
	
	@GetMapping("/articles")
	public List<Article> index() {
		return articleMockedData.fetchArticles();
	}
	
	@GetMapping("/article/{id}")
	public Article show(@PathVariable String id) {
		Long articleId = Long.parseLong(id);
		return articleMockedData.getArticleById(articleId);
	}
	
	@PostMapping("/article/search")
	public List<Article> search(@RequestBody Map<String, String> body) {
		String searchTerm = body.get("text");
		return articleMockedData.searchArticles(searchTerm);
	}
	
	@PostMapping("/article")
	public Article create(@RequestBody Map<String, String> body) {
		Long id = Long.parseLong(body.get("id"));
		String title = body.get("title");
		String content = body.get("content");
		DateFormat format = DateFormat.getInstance();
		Date release = null;
		try {
			release = format.parse(body.get("releaseDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return articleMockedData.createArticle(id, title, content, release);
	}
	
	@PutMapping("/article/{id}")
	public Article update(@PathVariable String id, @RequestBody Map<String, String> body) {
		Long articleId = Long.parseLong(id);
		String title = body.get("title");
		String content = body.get("content");
		DateFormat format = DateFormat.getInstance();
		Date release = null;
		try {
			release = format.parse(body.get("releaseDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return articleMockedData.updateArticle(articleId, title, content, release);
	}
	
	@DeleteMapping("/article/{id}")
	public boolean delete(@PathVariable String id) {
		Long articleId = Long.parseLong(id);
		return articleMockedData.delete(articleId);
	}
}
