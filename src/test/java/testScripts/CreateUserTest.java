package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateUserTest  extends BaseClass{
	
	@Test
	public void createUserTest() {
		//This test has failed
		SoftAssert soft=new SoftAssert();
		home.clickUserTab();
		soft.assertTrue(users.getpageHeader().contains("Users"));
		
		users.clickNewButton();
		soft.assertEquals(addUser.getPageHeader(), "Add New User");
		Map<String, String> map=excel.readFormExcel("Sheet1","Add User");
		addUser.createNewUser(map.get("Email"), map.get("Password"), map.get("Firstname"), map.get("Lastname"), map.get("Address"), map.get("Contact Info"), map.get("Photo"));
		soft.assertTrue(users.getSuccessMessage().contains("Success"));
		
		if(course.getSuccessMessage().contains("Success"))
			excel.writeToExcel("Sheet1","Add User","pass",IConstantPath.EXCEL_PATH);
			else
				excel.writeToExcel("Sheet1","Add User","Fail",IConstantPath.EXCEL_PATH);
		soft.assertAll();
	}
}
			
		
	


