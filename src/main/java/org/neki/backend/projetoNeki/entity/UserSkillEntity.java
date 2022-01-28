package org.neki.backend.projetoNeki.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_skill")
public class UserSkillEntity {

	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Long idUserSkill;
	
	@Column (name = "knowledge_level", nullable= false )	
	private Long sankhyaId;
	
	@Column (name = "created_at", nullable= false )
	private LocalDate created_at;
	
	@Column (name = "updated_at", nullable= true )
	private LocalDate updated_at;
	
	@Column (name = "user_id", nullable= false )	
	private Long UserId;
	
	@Column (name = "skill_id", nullable= false )	
	private Long SkillId;
	
	@OneToMany(mappedBy = "UserSkillEntity")
	private List<SkillEntity> skillEntity;
	
	@OneToMany(mappedBy = "UserSkillEntity")
	private List<UserEntity> userEntity;

	public UserSkillEntity() {
		super();
	}

	public UserSkillEntity(Long idUserSkill, Long sankhyaId, LocalDate created_at, LocalDate updated_at, Long userId,
			Long skillId, List<SkillEntity> skillEntity, List<UserEntity> userEntity) {
		super();
		this.idUserSkill = idUserSkill;
		this.sankhyaId = sankhyaId;
		this.created_at = created_at;
		this.updated_at = updated_at;
		UserId = userId;
		SkillId = skillId;
		this.skillEntity = skillEntity;
		this.userEntity = userEntity;
	}

	public Long getIdUserSkill() {
		return idUserSkill;
	}

	public void setIdUserSkill(Long idUserSkill) {
		this.idUserSkill = idUserSkill;
	}

	public Long getSankhyaId() {
		return sankhyaId;
	}

	public void setSankhyaId(Long sankhyaId) {
		this.sankhyaId = sankhyaId;
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

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public Long getSkillId() {
		return SkillId;
	}

	public void setSkillId(Long skillId) {
		SkillId = skillId;
	}

	public List<SkillEntity> getSkillEntity() {
		return skillEntity;
	}

	public void setSkillEntity(List<SkillEntity> skillEntity) {
		this.skillEntity = skillEntity;
	}

	public List<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(List<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(SkillId, UserId, created_at, idUserSkill, sankhyaId, skillEntity, updated_at, userEntity);
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
		return Objects.equals(SkillId, other.SkillId) && Objects.equals(UserId, other.UserId)
				&& Objects.equals(created_at, other.created_at) && Objects.equals(idUserSkill, other.idUserSkill)
				&& Objects.equals(sankhyaId, other.sankhyaId) && Objects.equals(skillEntity, other.skillEntity)
				&& Objects.equals(updated_at, other.updated_at) && Objects.equals(userEntity, other.userEntity);
	}

	@Override
	public String toString() {
		return "UserSkillEntity [idUserSkill=" + idUserSkill + ", sankhyaId=" + sankhyaId + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", UserId=" + UserId + ", SkillId=" + SkillId + ", skillEntity="
				+ skillEntity + ", userEntity=" + userEntity + "]";
	}
	
}
