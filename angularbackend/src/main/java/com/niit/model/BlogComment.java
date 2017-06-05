package com.niit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="blogcomment_details")
public class BlogComment {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String body;
private Date commentedOn;
@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name="commentedby_id")
private User commentedBy;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="blogpost_id")
private BlogPost blogpost;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public Date getCommentedOn() {
	return commentedOn;
}
public void setCommentedOn(Date commentedOn) {
	this.commentedOn = commentedOn;
}
public BlogPost getBlogpost() {
	return blogpost;
}
public void setBlogpost(BlogPost blogpost) {
	this.blogpost = blogpost;
}
public User getCommentedBy() {
	return commentedBy;
}
public void setCommentedBy(User commentedBy) {
	this.commentedBy = commentedBy;
}


}
