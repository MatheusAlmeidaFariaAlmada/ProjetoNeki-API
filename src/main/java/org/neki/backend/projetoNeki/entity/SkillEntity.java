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
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "skill")
public class SkillEntity {

	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	@ApiModelProperty(value = "Identificador único de habilidade")
	private Long id;
	
	@Column (name = "name", length = 100, nullable= false )	
	@Size(max=100)
	@ApiModelProperty(value="Nome da habilidade")
	private String name;
	
	@Column (name = "version", length = 10, nullable= true )	
	@Size(max=10)
	@ApiModelProperty(value="Versão da habilidade")
	private String version;
	
	@Column (name = "description", length = 255, nullable= false )	
	@Size(max=255)
	@ApiModelProperty(value="Descrição da habilidade")
	private String description;
	
	@Column (name = "image_url", length = 100, nullable= true )	
	@Size(max=100)
	@ApiModelProperty(value="Imagem da habilidade")
	private String imageUrl;
	
	@OneToMany(mappedBy = "skillEntity")
	private List<SkillEntity> skillEntity;

	public SkillEntity() {
		super();
	}

	public SkillEntity(Long id, String name, String version, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setIdSkill(Long id) {
		this.id = id;
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
		return Objects.hash(description, id, imageUrl, name, version);
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
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Objects.equals(version, other.version);
	}

	@Override
	public String toString() {
		return "SkillEntity [id=" + id + ", name=" + name + ", version=" + version + ", description="
				+ description + ", imageUrl=" + imageUrl + "]";
	}

}
