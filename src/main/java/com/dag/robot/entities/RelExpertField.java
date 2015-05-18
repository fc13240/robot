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
 * RelExpertField generated by hbm2java
 */
@Entity
@Table(name = "rel_expert_field", catalog = "db_expert_robot")
public class RelExpertField implements java.io.Serializable {

	private RelExpertFieldId id;
	private Expert expert;
	private Field field;
	private Integer weight;

	public RelExpertField() {
	}

	public RelExpertField(RelExpertFieldId id, Expert expert, Field field) {
		this.id = id;
		this.expert = expert;
		this.field = field;
	}

	public RelExpertField(RelExpertFieldId id, Expert expert, Field field,
			Integer weight) {
		this.id = id;
		this.expert = expert;
		this.field = field;
		this.weight = weight;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "expertId", column = @Column(name = "expertId", nullable = false)),
			@AttributeOverride(name = "fieldId", column = @Column(name = "fieldId", nullable = false)) })
	public RelExpertFieldId getId() {
		return this.id;
	}

	public void setId(RelExpertFieldId id) {
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
	@JoinColumn(name = "fieldId", nullable = false, insertable = false, updatable = false)
	public Field getField() {
		return this.field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@Column(name = "weight")
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
