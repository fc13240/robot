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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Paper generated by hbm2java
 */
@Entity
@Table(name = "paper", catalog = "db_expert_robot")
public class Paper implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer paperId;
	private String title;
	private String abs;
	private String keywords;
	private Set<RelPaperJournal> relPaperJournals = new HashSet<RelPaperJournal>(
			0);
	private Set<Topic> topics = new HashSet<Topic>(0);
	private Set<RelExpertPaper> relExpertPapers = new HashSet<RelExpertPaper>(0);

	public Paper() {
	}

	public Paper(String title, String abs) {
		this.title = title;
		this.abs = abs;
	}

	public Paper(String title, String abs, String keywords,
			Set<RelPaperJournal> relPaperJournals, Set<Topic> topics,
			Set<RelExpertPaper> relExpertPapers) {
		this.title = title;
		this.abs = abs;
		this.keywords = keywords;
		this.relPaperJournals = relPaperJournals;
		this.topics = topics;
		this.relExpertPapers = relExpertPapers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "paperId", unique = true, nullable = false)
	public Integer getPaperId() {
		return this.paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "abs", nullable = false, length = 65535)
	public String getAbs() {
		return this.abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	@Column(name = "keywords", length = 65535)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paper")
	public Set<RelPaperJournal> getRelPaperJournals() {
		return this.relPaperJournals;
	}

	public void setRelPaperJournals(Set<RelPaperJournal> relPaperJournals) {
		this.relPaperJournals = relPaperJournals;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rel_paper_topic", catalog = "db_expert_robot", joinColumns = { @JoinColumn(name = "paperId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "topicId", nullable = false, updatable = false) })
	public Set<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paper")
	public Set<RelExpertPaper> getRelExpertPapers() {
		return this.relExpertPapers;
	}

	public void setRelExpertPapers(Set<RelExpertPaper> relExpertPapers) {
		this.relExpertPapers = relExpertPapers;
	}

}
