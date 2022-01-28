package org.neki.backend.projetoNeki.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private SkillEntity skillEntity;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	public UserSkillEntity() {
		super();
	}

	public UserSkillEntity(Long idUserSkill, Long sankhyaId, LocalDate created_at, LocalDate updated_at,
			List<SkillEntity> skillEntity, List<UserEntity> userEntity) {
		super();
		this.idUserSkill = idUserSkill;
		this.sankhyaId = sankhyaId;
		this.created_at = created_at;
		this.updated_at = updated_at;

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

	@Override
	public int hashCode() {
		return Objects.hash(created_at, idUserSkill, sankhyaId, updated_at);
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
		return Objects.equals(created_at, other.created_at) && Objects.equals(idUserSkill, other.idUserSkill)
				&& Objects.equals(sankhyaId, other.sankhyaId) && Objects.equals(updated_at, other.updated_at);
	}

	@Override
	public String toString() {
		return "UserSkillEntity [idUserSkill=" + idUserSkill + ", sankhyaId=" + sankhyaId + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	
}
