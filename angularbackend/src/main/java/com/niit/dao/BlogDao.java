package com.niit.dao;

import java.util.List;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;

public interface BlogDao {

	void saveBlogPost(BlogPost blog);

	List<BlogPost> getBlogPosts(int approved);

	BlogPost getBlogPost(int id);
	void addBlogComment(BlogComment blogComment);
	
	List<BlogComment> getBlogComment(int blogPostId);
	
	void update(BlogPost blogpost);

	
}
