package com.musee.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.musee.dao.impl.UserCategoryImpl;
import com.musee.dao.impl.UserImpl;
import com.musee.domain.UserCategory;
import com.musee.domain.Users;

import musee.common.DbConstant;
import musee.common.JSFBoundleProvider;
import musee.common.JSFMessagers;
import musee.common.SessionUtils;

@ManagedBean
@SessionScoped
public class LoadUserInformationsController implements Serializable, DbConstant {
	private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	private String CLASSNAME = "LoadUserInformationsController :: ";
	private static final long serialVersionUID = 1L;
	/* to manage validation messages */
	private boolean isValid;
	/* end manage validation messages */
	private int notifSize;
	private Users users;
	private UserCategory userCategory;
	private List<Users> usersDetail = new ArrayList<Users>();

	/* class injection */

	JSFBoundleProvider provider = new JSFBoundleProvider();
	UserImpl usersImpl = new UserImpl();
	UserCategoryImpl categoryImpl = new UserCategoryImpl();
	private String userCatName;
	private String dob;
	@SuppressWarnings("unused")
	private String notifName;
	/* end class injection */
	Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		HttpSession session = SessionUtils.getSession();
		if (users == null) {
			users = new Users();
		}
		if (userCategory == null) {
			userCategory = new UserCategory();
		}

		users = (Users) session.getAttribute("userSession");
		if (null != users) {
			try {
				
			} catch (Exception e) {
				LOGGER.info(CLASSNAME + "... " + e.getMessage());
			}
			LOGGER.info("HHH>>" + users.getUserCategory().getUsercategoryName());
			userCategory = users.getUserCategory();
			userCatName = users.getUserCategory().getUsercategoryName();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy/dd/MM");
			if (null != users && users.getDateOfBirth() != null)
				dob = fmt.format(users.getDateOfBirth());
			try {
				
			} catch (Exception e) {
				LOGGER.info("error loading generic menu:::");
				setValid(false);
				JSFMessagers.addErrorMessage(getProvider().getValue("com.server.side.internal.error"));
				LOGGER.info(e.getMessage());
				e.printStackTrace();
			}
		}

	}

	public String getContextPath() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return request.getContextPath();
	}

	public String rootPath() {
		return Root_Path;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public UserImpl getUsersImpl() {
		return usersImpl;
	}

	public void setUsersImpl(UserImpl usersImpl) {
		this.usersImpl = usersImpl;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public JSFBoundleProvider getProvider() {
		return provider;
	}

	public void setProvider(JSFBoundleProvider provider) {
		this.provider = provider;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	public String getUserCatName() {
		return userCatName;
	}

	public void setUserCatName(String userCatName) {
		this.userCatName = userCatName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getNotifSize() {
		return notifSize;
	}

	public void setNotifSize(int notifSize) {
		this.notifSize = notifSize;
	}

	public List<Users> getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(List<Users> usersDetail) {
		this.usersDetail = usersDetail;
	}

	public UserCategoryImpl getCategoryImpl() {
		return categoryImpl;
	}

	public void setCategoryImpl(UserCategoryImpl categoryImpl) {
		this.categoryImpl = categoryImpl;
	}

	public String getNotifName() {
		return notifName;
	}

	public void setNotifName(String notifName) {
		this.notifName = notifName;
	}

}
