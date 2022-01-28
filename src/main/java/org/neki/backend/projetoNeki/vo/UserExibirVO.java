package org.neki.backend.projetoNeki.vo;

import java.time.LocalDate;

import org.neki.backend.projetoNeki.entity.UserEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserExibirVO {

	private Long idUser;
	private String login;
	private String password;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate lastLoginDate;
	
	public UserExibirVO() {
		super();
	}

	public UserExibirVO(UserEntity userEntity) {
		super();
		this.idUser = userEntity.getIdUser();
		this.login = userEntity.getLogin();
		this.password = userEntity.getPassword();
		this.lastLoginDate = userEntity.getLastLoginDate();
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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
