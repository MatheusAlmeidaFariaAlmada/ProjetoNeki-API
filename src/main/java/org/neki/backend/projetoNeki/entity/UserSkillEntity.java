package org.neki.backend.projetoNeki.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user_skill")
public class UserSkillEntity {

	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name = "knowledge_level", nullable= false )	
	@ApiModelProperty(value="Nivel de conhecimento")
	private Long knowledgeLevel;
	
	@Column (name = "created_at", nullable= false )
	@ApiModelProperty(value="Data de criação")
	private LocalDate created_at;
	
	@Column (name = "updated_at", nullable= true )
	@ApiModelProperty(value="Data de Atualização")
	private LocalDate updated_at;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private SkillEntity skillEntity;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	public UserSkillEntity() {
		super();
	}

	public UserSkillEntity(Long id, Long knowledgeLevel, LocalDate created_at, LocalDate updated_at,
			SkillEntity skillEntity, UserEntity userEntity) {
		super();
		this.id = id;
		this.knowledgeLevel = knowledgeLevel;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.skillEntity = skillEntity;
		this.userEntity = userEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKnowledgeLevel() {
		return knowledgeLevel;
	}

	public void setKnowledgeLevel(Long knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public LocalDate getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}

	public SkillEntity getSkillEntity() {
		return skillEntity;
	}

	public void setSkillEntity(SkillEntity skillEntity) {
		this.skillEntity = skillEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(created_at, id, knowledgeLevel, skillEntity, updated_at, userEntity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSkillEntity other = (UserSkillEntity) obj;
		return Objects.equals(created_at, other.created_at) && Objects.equals(id, other.id)
				&& Objects.equals(knowledgeLevel, other.knowledgeLevel)
				&& Objects.equals(skillEntity, other.skillEntity) && Objects.equals(updated_at, other.updated_at)
				&& Objects.equals(userEntity, other.userEntity);
	}

	@Override
	public String toString() {
		return "UserSkillEntity [id=" + id + ", knowledgeLevel=" + knowledgeLevel + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", skillEntity=" + skillEntity + ", userEntity="
				+ userEntity + "]";
	}
	
}
