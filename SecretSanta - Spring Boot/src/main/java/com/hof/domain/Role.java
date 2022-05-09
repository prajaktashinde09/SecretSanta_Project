package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;

	private String roleName;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="role")
	@JsonIgnore
	private List<User> users;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRole(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRole(null);

		return user;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}
	

}