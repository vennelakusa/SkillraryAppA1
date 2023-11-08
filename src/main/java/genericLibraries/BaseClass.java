package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import PomPages.AddNewCategoryPage;
import PomPages.AddNewCoursePage;
import PomPages.AddNewUserPage;
import PomPages.AdminHomePage;
import PomPages.CategoryPage;
import PomPages.CourseListPage;
import PomPages.Loginpage;
import PomPages.UserPage;

public class BaseClass 
{
	
	//@BeforeSuite
	//@BeforeTest
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected WelcomePage welcome;
	protected Loginpage login;
	protected AdminHomePage home;
	protected UserPage  users;    
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage addUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	@BeforeClass
	public void classConfig() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		webUtil=new WebDriverUtility();
				
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		driver=webUtil.launchBrowser(property.readFromPropertiesString("browser"));
		
		sdriver=driver;
		sjutil=jutil;
	}
	
	@BeforeMethod
	public void methodConfig() {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		welcome=new WelcomePage(driver);
		login=new Loginpage(driver);
		home=new AdminHomePage(driver);
		users=new UserPage(driver);
		course=new CourseListPage(driver);
		category=new CategoryPage(driver);
		addUser=new AddNewUserPage(driver);
		addCourse=new AddNewCoursePage(driver);
		addCategory=new AddNewCategoryPage(driver);
		
		webUtil.navigateToApp(property.readFromPropertiesString("url"));
		Assert.assertEquals(welcome.getLogo(),"skillRary-ECommerce");
		
		long time=Long.parseLong(property.readFromPropertiesString("timeouts"));
		webUtil.waitTillElementFound(time);
		
	welcome.clickLoginButton();
	Assert.assertEquals(login.getPageHeader(), "Login");
	
	login.setEmail(property.readFromPropertiesString("username"));
	login.setPassword(property.readFromPropertiesString("password"));
	login.clickLogin();
	
	Assert.assertEquals(home.getAdminIcon(), "SkillRary Admin");
	}
	@AfterMethod
	public void methodTeardown() {
		excel.closeExcel();
		home.signOutApp();
	}
	
	@AfterClass
	public void classTeardown() {
		webUtil.closeAllWindows();
	}
	//@AfterTest
	//@AfterSuite
}

	
	
		
		
		
	
		
		
				
	
	

	


