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
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	@ApiModelProperty(value = "Identificador único do usuário")
	private Long id;
	
	@Column (name = "login", length = 12, nullable= false )	
	@Size(max=12)
	@ApiModelProperty(value="Login do usuário")
	private String login;
	
	@Column (name = "password", length = 100, nullable= false )	
	@Size(max=100)
	@ApiModelProperty(value="Senha do usuário")
	private String password;
	
	@Column (name = "last_login_date", nullable= true )
	@ApiModelProperty(value="Data de Login")
	private LocalDate lastLoginDate;
	
	@OneToMany(mappedBy = "userEntity")
	private List<UserEntity> userEntity;

	public UserEntity() {
		super();
	}

	public UserEntity(Long id, String login, String password, LocalDate lastLoginDate) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
	}

	public Long getId() {
		return id;
	}

	public void setIdUser(Long id) {
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

	@Override
	public int hashCode() {
		return Objects.hash(id, lastLoginDate, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(lastLoginDate, other.lastLoginDate)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "UserEntity [idUser=" + id + ", login=" + login + ", password=" + password + ", lastLoginDate="
				+ lastLoginDate + "]";
	}
	
}
