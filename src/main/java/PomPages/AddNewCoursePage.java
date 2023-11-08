package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class AddNewCoursePage {
//Declaration
	@FindBy(xpath="//b[text()='Add New Course']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameTF;
	
	
	@FindBy(xpath="category")
	private WebElement categoryDropdown;
	
	
	@FindBy(xpath="price")
	private WebElement priceTF;
	
	@FindBy(xpath="(//input[@id='photo'])[2]")
	private WebElement PhotoButton;
	
	@FindBy(xpath="//button[@name='add']")
	private WebElement saveButton;
	
	@FindBy(xpath="//html/body/p")
	private WebElement descriptionTextArea;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor,editor1']")
	private WebElement descriptionFrame;
	
	
	
	//Initialization
	public AddNewCoursePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}
	public void setName(String courseName) {
		nameTF.sendKeys(courseName);
	}
	public void selectCategory(WebDriverUtility web,String category) {
		web.handleDropdown(category, categoryDropdown);
	}
	public void setPrice(String price) {
		priceTF.sendKeys(price);
	}
	public void uploadPhoto(String photopath) {
		PhotoButton.sendKeys(photopath);
	}
	public void setDescrition(WebDriverUtility web,String text) {
		web.switchToFrame(descriptionFrame);
		descriptionTextArea.sendKeys(text);
		web.switchBackFromFrame();
	}
	public void clickSaveButton() {
		saveButton.click();
	}
}
	
	
	
		
	
	
	
	
	
	

