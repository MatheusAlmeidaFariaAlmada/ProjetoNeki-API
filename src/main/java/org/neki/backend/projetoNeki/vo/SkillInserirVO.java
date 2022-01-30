package org.neki.backend.projetoNeki.vo;

import java.util.List;

import org.neki.backend.projetoNeki.entity.SkillEntity;

public class SkillInserirVO {

	private Long id;
	private String name;
	private String version;
	private String description;
	private String imageUrl;
	
	public SkillInserirVO() {
		super();
	}

	public SkillInserirVO(Long id, String name, String version, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	public SkillInserirVO(SkillEntity skillEntity) {
		super();
		this.id = skillEntity.getId();
		this.name = skillEntity.getName();
		this.version = skillEntity.getVersion();
		this.description = skillEntity.getDescription();
		this.imageUrl = skillEntity.getImageUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
}
