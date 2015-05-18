package com.dag.robot.entities;

// Generated 2015-5-18 19:36:10 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelExpertPaper generated by hbm2java
 */
@Entity
@Table(name = "rel_expert_paper", catalog = "db_expert_robot")
public class RelExpertPaper implements java.io.Serializable {

	private RelExpertPaperId id;
	private Expert expert;
	private Paper paper;
	private int authorOrder;

	public RelExpertPaper() {
	}

	public RelExpertPaper(RelExpertPaperId id, Expert expert, Paper paper,
			int authorOrder) {
		this.id = id;
		this.expert = expert;
		this.paper = paper;
		this.authorOrder = authorOrder;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "expertId", column = @Column(name = "expertId", nullable = false)),
			@AttributeOverride(name = "paperId", column = @Column(name = "paperId", nullable = false)) })
	public RelExpertPaperId getId() {
		return this.id;
	}

	public void setId(RelExpertPaperId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expertId", nullable = false, insertable = false, updatable = false)
	public Expert getExpert() {
		return this.expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paperId", nullable = false, insertable = false, updatable = false)
	public Paper getPaper() {
		return this.paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	@Column(name = "authorOrder", nullable = false)
	public int getAuthorOrder() {
		return this.authorOrder;
	}

	public void setAuthorOrder(int authorOrder) {
		this.authorOrder = authorOrder;
	}

}
