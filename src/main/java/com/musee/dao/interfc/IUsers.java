/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.musee.dao.interfc;

import java.util.List;

import com.musee.domain.Users;

/**
 *
 * @author Ngango
 */
public interface IUsers {
	public Users saveUsers(Users users);

	public List<Users> getListUsers();

	public Users gettUserById(int userId, String primaryKeyclomunName);

	public Users UpdateUsers(Users users);

	public String myNane();

	public Users getUsersWithQuery(final String[] propertyName, final Object[] value, final String hqlStatement);
}
