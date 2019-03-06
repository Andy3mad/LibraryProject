package edu.mum.library.mock;

import java.util.Arrays;
import java.util.List;

import edu.mum.library.model.AuthorizationLevel;
import edu.mum.library.model.Staff;

public class StaffTableMock {
	private StaffTableMock() {
	};

	public static List<Staff> getStaffList() {
		Staff staff1 = new Staff("augusto", "otsugua", AuthorizationLevel.ADMIN);
		Staff staff2 = new Staff("dong", "gnod", AuthorizationLevel.LIBRARIAN);
		Staff staff3 = new Staff("andrew", "werdna", AuthorizationLevel.BOTH);

		return Arrays.asList(staff1, staff2, staff3);
	}

}
