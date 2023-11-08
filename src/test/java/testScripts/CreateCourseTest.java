package testScripts;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateCourseTest  extends BaseClass{
	
	@Test
	public void createCourseTest() {
		SoftAssert soft=new SoftAssert();
		home.clickCourseTab();
		home.clickCourseListLink();
		soft.assertTrue(course.getpageHeader().contains("Course List"));
		
		course.ClickNewButton();
		Thread.sleep(2000);
		soft.assertEquals(addCourse.getpageHeader(), "Add New Course");
		Map<String, String>map=excel.readFromExcel("Sheet1","Add  Course");
		String courseName=map.get("Name")+jutil.generateRandomNum(100);
		addCourse.setName(courseName);
		addCourse.selectCategory(webUtil, map.get("category"));
		addCourse.setPrice(map.get("price"));
		addCourse.uploadPhoto(map.get("photo"));
		
		addCourse.setDescrition(webUtil, map.get("Description"));
		addCourse.clickSaveButton();
		soft.assertTrue(course.getSuccessMessage().contains("Success"));
		
		boolean isPresent=false;
		List<WebElement>courseNameList=course.getCourseList();
		for(WebElement name : courseNameList) {
			if(name.getText().equals(courseNameList)) {
				isPresent = true;
				break;
			}
		}
		soft.assertTrue(isPresent);
		
		course.clickDeleteButton(courseName, driver);
		course.clickDelete();
		soft.assertTrue(course.getSuccessMessage().contains("Success"));
		if(course.getSuccessMessage().contains("Success"))
		excel.writeToExcel("Sheet1","Add Course","pass",IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("Sheet1","Add Course","Fail",IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
	
	}
}
		
		
		



