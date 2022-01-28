package org.neki.backend.projetoNeki.vo;

import org.neki.backend.projetoNeki.entity.UserEntity;

public class UserInserirVO {

	private String login;
	private String password;
	
	public UserInserirVO() {
		super();
	}

	public UserInserirVO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public UserInserirVO(UserEntity userEntity) {
		super();
		this.login = userEntity.getLogin();
		this.password = userEntity.getPassword();
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
	
}
