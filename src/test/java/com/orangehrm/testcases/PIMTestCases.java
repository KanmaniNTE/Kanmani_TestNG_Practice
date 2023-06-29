package com.orangehrm.testcases;

import org.testng.annotations.Test;

import com.orangehrm.base.Generic;
import com.orangehrm.pages.CommonPage;
import com.orangehrm.pages.LoginPage;

public class PIMTestCases extends Generic {
	//Search Employee by Name - create method
	//TC01_SearchEmployeeByName
	//TC02_Delete a Employee by using name/id
	//TC02_Valididate deleting a row in EmployeeList
	

	@Test
	public void TC02_ValididateDeletingARowInEmployeeList() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.loginOrangeHRM("Admin", "admin123");
		CommonPage commonPage = new CommonPage(getDriver());
		commonPage.goToGivenPageInOrangehrm("PIM");
	}
	
//	@BeforeTest
//	public void method1() {
//		System.out.println("222222222222");
//	}

}
