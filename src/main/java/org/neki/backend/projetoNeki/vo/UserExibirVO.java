package org.neki.backend.projetoNeki.vo;

import java.time.LocalDate;

import org.neki.backend.projetoNeki.entity.UserEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserExibirVO {

	private Long id;
	private String login;
	private String password;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate lastLoginDate;
	
	public UserExibirVO() {
		super();
	}

	public UserExibirVO(Long id, String login, String password, LocalDate lastLoginDate) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
	}

	public UserExibirVO(UserEntity userEntity) {
		super();
		this.id = userEntity.getId();
		this.login = userEntity.getLogin();
		this.password = userEntity.getPassword();
		this.lastLoginDate = userEntity.getLastLoginDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDate lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
}
