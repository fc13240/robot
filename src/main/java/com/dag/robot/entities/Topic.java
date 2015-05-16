package com.dag.robot.entities;

// Generated 2015-5-13 19:55:40 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Topic generated by hbm2java
 */
@Entity
@Table(name = "topic", catalog = "db_expert_robot")
public class Topic implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer topicId;
	private String name;
	private Set<User> users = new HashSet<User>(0);
	private Set<RelExpertTopic> relExpertTopics = new HashSet<RelExpertTopic>(0);
	private Set<Paper> papers = new HashSet<Paper>(0);
	private Set<RelFieldTopic> relFieldTopics = new HashSet<RelFieldTopic>(0);

	public Topic() {
	}

	public Topic(String name) {
		this.name = name;
	}

	public Topic(String name, Set<User> users,
			Set<RelExpertTopic> relExpertTopics, Set<Paper> papers,
			Set<RelFieldTopic> relFieldTopics) {
		this.name = name;
		this.users = users;
		this.relExpertTopics = relExpertTopics;
		this.papers = papers;
		this.relFieldTopics = relFieldTopics;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "topicId", unique = true, nullable = false)
	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "topics")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<RelExpertTopic> getRelExpertTopics() {
		return this.relExpertTopics;
	}

	public void setRelExpertTopics(Set<RelExpertTopic> relExpertTopics) {
		this.relExpertTopics = relExpertTopics;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "topics")
	public Set<Paper> getPapers() {
		return this.papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<RelFieldTopic> getRelFieldTopics() {
		return this.relFieldTopics;
	}

	public void setRelFieldTopics(Set<RelFieldTopic> relFieldTopics) {
		this.relFieldTopics = relFieldTopics;
	}

}
