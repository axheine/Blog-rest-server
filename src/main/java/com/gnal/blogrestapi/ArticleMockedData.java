package com.gnal.blogrestapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gnal.blogrestapi.model.Article;

public class ArticleMockedData {
	private List<Article> articles;
	
	private static ArticleMockedData instance = null;
	
	public static ArticleMockedData getInstance() {
		if (instance == null) {
			instance = new ArticleMockedData();
		}
		return instance;
	}
	
	private ArticleMockedData() {
		articles = new ArrayList<Article>();
		articles.add(new Article(1L, "Go up, up and away with your Google Assistant",
                "With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport",
                        new Date()));
		articles.add(new Article(2L, "Get local help with your Google Assistant",
                "No matter what questions you’re asking—whether about local traffic or " +
                        "a local business—your Google Assistant should be able to help. And starting " +
                        "today, it’s getting better at helping you, if you’re looking for nearby services " +
                        "like an electrician, plumber, house cleaner and more",
                        new Date()));
		articles.add(new Article(3L, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices " +
                        "that use technology like the Google Assistant. And with the availability of maker-friendly " +
                        "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action " +
                        "and adding voice to their Internet of Things (IoT) projects.",
                        new Date()));
		articles.add(new Article(4L, "Learn more about the world around you with Google Lens and the Assistant",
                "Looking at a landmark and not sure what it is? Interested in learning more about a movie as " +
                        "you stroll by the poster? With Google Lens and your Google Assistant, you now have a helpful " +
                        "sidekick to tell you more about what’s around you, right on your Pixel.",
                        new Date()));
		articles.add(new Article(5L, "7 ways the Assistant can help you get ready for Turkey Day",
                "Thanksgiving is just a few days away and, as always, your Google Assistant is ready to help. " +
                        "So while the turkey cooks and the family gathers, here are some questions to ask your Assistant.",
                        new Date()));
	}
	
	public List<Article> fetchArticles() {
		return articles;
	}
	
	public Article getArticleById(Long id) {
		for (Article a: articles) {
			if (a.getArticle_id() == id) {
				return a;
			}
		}
		return null;
	}
	
	public List<Article> searchArticles(String searchTerm) {
		List<Article> searchedArticles = new ArrayList<Article>();
		for (Article a: articles) {
			if (a.getArticle_title().toLowerCase().contains(searchTerm.toLowerCase()) ||
				a.getArticle_body().toLowerCase().contains(searchTerm.toLowerCase())) {
				searchedArticles.add(a);
			}
		}
		return searchedArticles;
	}
	
	public Article createArticle(Long id, String title, String content, Date releaseDate) {
		Article newArticle = new Article(id, title, content, releaseDate);
		articles.add(newArticle);
		return newArticle;
	}
	
	public Article updateArticle(Long id, String title, String content, Date releaseDate) {
		for (Article a: articles) {
			if (a.getArticle_id() == id) {
				int articleIndex = articles.indexOf(a);
				
				a.setArticle_title(title);
				a.setArticle_body(content);
				a.setRelease_date(releaseDate);
				
				articles.set(articleIndex, a);
				return a;
			}
		}
		return null;
	}
	
	public boolean delete(Long id) {
		int articleIndex = -1;
		for (Article a: articles) {
			if (a.getArticle_id() == id) {
				articleIndex = articles.indexOf(a);
				continue;
			}
		}
		// avoid java.util.ConcurrentModificationException
		if (articleIndex > -1) {
			articles.remove(articleIndex);
			return true;
		}
		return false;
	}
}
