package com.gnal.blogrestapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity
public class Article {
	//@Id
	//@GeneratedValue
	private Long article_id;
	private String article_title;
	private String article_body;
	private Date release_date;
	
	public Article(Long article_id, String article_title, String article_body, Date release_date) {
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_body = article_body;
		this.release_date = release_date;
	}

	public Long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_body() {
		return article_body;
	}

	public void setArticle_body(String article_body) {
		this.article_body = article_body;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", article_title=" + article_title + ", article_body="
				+ article_body + ", release_date=" + release_date + "]";
	}
}
