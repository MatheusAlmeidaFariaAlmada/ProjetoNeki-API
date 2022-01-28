package org.neki.backend.projetoNeki.entity;

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
@Table(name = "skill")
public class SkillEntity {

	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Long idSkill;
	
	@Column (name = "name", length = 100, nullable= false )	
	private String name;
	
	@Column (name = "version", length = 10, nullable= true )	
	private String version;
	
	@Column (name = "description", length = 255, nullable= false )	
	private String description;
	
	@Column (name = "image_url", length = 100, nullable= true )	
	private String imageUrl;
	
	@OneToMany(mappedBy = "skillEntity")
	private List<SkillEntity> skillEntity;

	public SkillEntity() {
		super();
	}

	public SkillEntity(Long idSkill, String name, String version, String description, String imageUrl) {
		super();
		this.idSkill = idSkill;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Long getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Long idSkill) {
		this.idSkill = idSkill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, idSkill, imageUrl, name, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillEntity other = (SkillEntity) obj;
		return Objects.equals(description, other.description) && Objects.equals(idSkill, other.idSkill)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Objects.equals(version, other.version);
	}

	@Override
	public String toString() {
		return "SkillEntity [idSkill=" + idSkill + ", name=" + name + ", version=" + version + ", description="
				+ description + ", imageUrl=" + imageUrl + "]";
	}

}
