package org.neki.backend.projetoNeki.vo;

import java.time.LocalDate;

import org.neki.backend.projetoNeki.entity.SkillEntity;
import org.neki.backend.projetoNeki.entity.UserEntity;
import org.neki.backend.projetoNeki.entity.UserSkillEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserSkillExibirVO {

	private Long id;
	private Long knowledgeLevel;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate created_at;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate updated_at;
	private SkillEntity skillEntity;
	private UserEntity userEntity;
	
	public UserSkillExibirVO() {
		super();
	}

	public UserSkillExibirVO(Long id, Long knowledgeLevel, LocalDate created_at, LocalDate updated_at,
			SkillEntity skillEntity, UserEntity userEntity) {
		super();
		this.id = id;
		this.knowledgeLevel = knowledgeLevel;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.skillEntity = skillEntity;
		this.userEntity = userEntity;
	}

	public UserSkillExibirVO(UserSkillEntity userSkillEntity) {
		super();
		this.id = userSkillEntity.getId();
		this.knowledgeLevel = userSkillEntity.getKnowledgeLevel();
		this.created_at = userSkillEntity.getCreated_at();
		this.updated_at = userSkillEntity.getUpdated_at();
		this.skillEntity = userSkillEntity.getSkillEntity();
		this.userEntity = userSkillEntity.getUserEntity();
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
	
}
