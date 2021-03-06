package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;
@Repository
public class BlogDaoImpl implements BlogDao{
@Autowired
private SessionFactory sessionFactory;
	public void saveBlogPost(BlogPost blogPost) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.save(blogPost);
		session.flush();
		trans.commit();
		session.close();
		
	}
	public List<BlogPost> getBlogPosts(int approved) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from BlogPost where approved="+approved);
		List<BlogPost> blogPosts=query.list();
		trans.commit();
		session.close();
		return blogPosts;
	}
	
	public BlogPost getBlogPost(int id) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		BlogPost blogPost=(BlogPost)session.get(BlogPost.class, id);
		trans.commit();
		session.close();
		return blogPost;
		} 
	
	public void addBlogComment(BlogComment blogComment) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.save(blogComment);
		session.flush();
		trans.commit();
		session.close();
	}
	
	public List<BlogComment> getBlogComment(int blogPostId) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		BlogPost blogPost=(BlogPost)session.get(BlogPost.class, blogPostId);
		List<BlogComment> blogcomments=blogPost.getBlogcomments();
		trans.commit();
		session.close();
		return blogcomments;

	}
	public void update(BlogPost blogpost) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.update(blogpost);
		session.flush();
		trans.commit();
		session.close();
	}
	


	

}