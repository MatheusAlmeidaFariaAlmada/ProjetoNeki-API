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
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.AUTO)
	private Long idUser;
	
	@Column (name = "login", length = 12, nullable= false )	
	private String login;
	
	@Column (name = "password", length = 100, nullable= false )	
	private String password;
	
	@Column (name = "last_login_date", nullable= true )
	private LocalDate lastLoginDate;
	
	@OneToMany(mappedBy = "userEntity")
	private List<UserEntity> userEntity;

	public UserEntity() {
		super();
	}

	public UserEntity(Long idUser, String login, String password, LocalDate lastLoginDate) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
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

	@Override
	public int hashCode() {
		return Objects.hash(idUser, lastLoginDate, login, password);
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
		return Objects.equals(idUser, other.idUser) && Objects.equals(lastLoginDate, other.lastLoginDate)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "UserEntity [idUser=" + idUser + ", login=" + login + ", password=" + password + ", lastLoginDate="
				+ lastLoginDate + "]";
	}
	
}
