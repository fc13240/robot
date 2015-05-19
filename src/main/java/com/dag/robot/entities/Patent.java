package com.dag.robot.entities;

// Generated 2015-5-19 19:31:02 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Patent generated by hbm2java
 */
@Entity
@Table(name = "patent", catalog = "db_expert_robot")
public class Patent implements java.io.Serializable {

	private int patentId;
	private String title;
	private String abs;
	private Date date;
	private String applicant;
	private String inventor;
	private Set<RelExpertPatent> relExpertPatents = new HashSet<RelExpertPatent>(
			0);

	public Patent() {
	}

	public Patent(int patentId, String title, String abs, Date date,
			String applicant, String inventor) {
		this.patentId = patentId;
		this.title = title;
		this.abs = abs;
		this.date = date;
		this.applicant = applicant;
		this.inventor = inventor;
	}

	public Patent(int patentId, String title, String abs, Date date,
			String applicant, String inventor,
			Set<RelExpertPatent> relExpertPatents) {
		this.patentId = patentId;
		this.title = title;
		this.abs = abs;
		this.date = date;
		this.applicant = applicant;
		this.inventor = inventor;
		this.relExpertPatents = relExpertPatents;
	}

	@Id
	@Column(name = "patentId", unique = true, nullable = false)
	public int getPatentId() {
		return this.patentId;
	}

	public void setPatentId(int patentId) {
		this.patentId = patentId;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "applicant", nullable = false, length = 50)
	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	@Column(name = "inventor", nullable = false, length = 50)
	public String getInventor() {
		return this.inventor;
	}

	public void setInventor(String inventor) {
		this.inventor = inventor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patent")
	public Set<RelExpertPatent> getRelExpertPatents() {
		return this.relExpertPatents;
	}

	public void setRelExpertPatents(Set<RelExpertPatent> relExpertPatents) {
		this.relExpertPatents = relExpertPatents;
	}

}
