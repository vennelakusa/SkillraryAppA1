package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	//Declaration
		@FindBy(xpath="//span[text()='SkillRary Admin']")
		private WebElement  adminIcon;
		
		@FindBy(xpath="//span[text()='Users']")
		private WebElement  userTab;
		

		@FindBy(xpath="//span[text()='Courses']")
		private WebElement  courseTab;
		
		@FindBy(xpath=" //a[text()='Course List']]")
		private WebElement  courselistLink;
		
		@FindBy(xpath=" //a[text()=' Category']]")
		private WebElement  categoryLink;
		
		
		
		@FindBy(xpath="//a[text()='Sign out']]")
		private WebElement  signoutLink;
		
		//Initialization
		public AdminHomePage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public String getAdminIcon() {
			return adminIcon.getText();
		}
		public void clickUserTab() {
			userTab.click();
		}
		public void clickCourseTab() {
			courseTab.click();
		}
		public void clickCourseListLink() {
			courseTab.click();
		}
		public void clickCategoryLink() {
			categoryLink.click();
		}
		public void signOutApp() {
			adminIcon.click();
			signoutLink.click();
		}


		

		
		}
			
		
		
		
		
		


