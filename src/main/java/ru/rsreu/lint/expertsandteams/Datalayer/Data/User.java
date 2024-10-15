package ru.rsreu.lint.expertsandteams.Datalayer.Data;

public class User {

	private Long id;

	private String login;

	private String password;

	private String name;

	private String email;

	private String role;

	public User(Long id, String login, String password, String name, String email, String role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
