package edu.mum.library.service;

import org.springframework.stereotype.Component;

import edu.mum.library.model.Staff;

@Component
public class SessionManager {

	private Staff activeStaff;

	public void setLoginUser(Staff loginStaff) {
		this.activeStaff = loginStaff;
	}

	public void logout() {

		activeStaff = null;

	}

	public Staff getLoginUser() {
		return activeStaff;
	}
}
