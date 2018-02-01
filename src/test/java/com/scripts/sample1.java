package com.scripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.libraries.BaseClass;
import com.libraries.GenericClass;
import com.pages.HomePage;
import com.pages.RfcPage;
import com.pages.SavedPage;
import com.pages.SearchPage;

import net.sourceforge.tess4j.TesseractException;



public class sample1 extends BaseClass {
	
	
	
	@Test
	public void verifysample() throws InterruptedException, IOException, TesseractException{
	HomePage home=new HomePage(driver);
	SearchPage sp=new SearchPage(driver);
	SavedPage savep=new SavedPage(driver);
	RfcPage rp=new RfcPage(driver);
	try{
		Assert.assertTrue(home.welComePage.isDisplayed(), "WelcomePage is not displayed");
		NXGReports.addStep("WelcomePage is not displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	home.continueBtn.click();
	}
	catch(Exception e){
	}
	Assert.assertTrue(home.searchIcon.isDisplayed(), "The search Icon is displayed");
	NXGReports.addStep("The search Icon is displayed", LogAs.PASSED, null);
	home.searchIcon.click();
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(sp.searchTB));
	Assert.assertTrue(sp.searchTB.isDisplayed(), "The search text box is not displayed");
	NXGReports.addStep("The search text box is displayed", LogAs.PASSED, null);
	sp.searchTB.sendKeys(GenericClass.getData(1, 1, "verizon_pocketRFC"));
	GenericClass.clickOnEnter(driver);
	Thread.sleep(1000);
	WebElement rfcTitle=sp.retreiveRfc(GenericClass.getData(1, 2, "verizon_pocketRFC"));
	String text=rfcTitle.getText();
	rfcTitle.click();
	//String rfcID=sp.retreiveSelectedRfcNum(rfcTitle);
	wait.until(ExpectedConditions.visibilityOf(rp.favoriteIcon));
	Assert.assertTrue(rp.favoriteIcon.isDisplayed(), "Favorite Icon is not displayed");
	NXGReports.addStep("Favorite Icon is displayed", LogAs.PASSED, null);
	rp.favoriteIcon.click();
	String favoriteAddToastMessage=GenericClass.verifyToastMessage(driver);
	Assert.assertTrue(favoriteAddToastMessage.contains(GenericClass.getData(1, 3, "verizon_pocketRFC")), "'RFC marked as favorite' is not displayed");
	NXGReports.addStep("'RFC marked as favorite' is displayed", LogAs.PASSED, null);
	Assert.assertTrue(rp.favoriteIcon.isEnabled(), "Favorite Icon is not selected");
	NXGReports.addStep("Favorite Icon is selected", LogAs.PASSED, null);
	Assert.assertTrue(rp.optionsMenuIcon.isDisplayed(), "Option Menu Icon is not displayed");
	NXGReports.addStep("Option Menu Icon is displayed", LogAs.PASSED, null);
	rp.optionsMenuIcon.click();
	Assert.assertTrue(rp.saveOption.isDisplayed(), "Save option is not displayed");
	NXGReports.addStep("Save option is displayed", LogAs.PASSED, null);
	rp.saveOption.click();
	Assert.assertTrue(rp.AcceptPopupOption.isDisplayed(), "Save popup is not displayed");
	NXGReports.addStep("Save popup is displayed", LogAs.PASSED, null);
	rp.AcceptPopupOption.click();
	wait.until(ExpectedConditions.elementToBeClickable(rp.backIcon));
	String SaveToastMessage=GenericClass.verifyToastMessage(driver);
	Assert.assertTrue(SaveToastMessage.contains(GenericClass.getData(1, 4, "verizon_pocketRFC")), "'Document saved to your downloads folder!' is not displayed");
	NXGReports.addStep("'Document saved to your downloads folder!' is displayed", LogAs.PASSED, null);
	wait.until(ExpectedConditions.elementToBeClickable(rp.backIcon));
	Assert.assertTrue(rp.backIcon.isDisplayed(), "RFC page Back icon is not displayed");
	NXGReports.addStep("RFC page Back icon is displayed", LogAs.PASSED, null);
	rp.backIcon.click();
	Assert.assertTrue(sp.backIcon.isDisplayed(), "Search page Back icon is not displayed");
	NXGReports.addStep("Search page Back icon is displayed", LogAs.PASSED, null);
	sp.backIcon.click();
	Assert.assertTrue(home.hamburgerMenu.isDisplayed(), "HomePage Hamburger menu icon is not displayed");
	NXGReports.addStep("HomePage Hamburger menu icon is displayed", LogAs.PASSED, null);
	home.hamburgerMenu.click();
	Assert.assertTrue(savep.savedMenuOption.isDisplayed(), "HomePage Hamburger menu is not displayed");
	NXGReports.addStep("HomePage Hamburger menu is displayed", LogAs.PASSED, null);
	savep.savedMenuOption.click();
	Assert.assertEquals(savep.checkSavedPagePresent(text),true);
	NXGReports.addStep("Saved page is displayed", LogAs.PASSED, null);
	System.out.println(savep.checkSavedPagePresent(text));
	sp.retreiveRfc("HTTP/1.0").click();
	wait.until(ExpectedConditions.visibilityOf(rp.optionsMenuIcon));
	Assert.assertTrue(rp.optionsMenuIcon.isDisplayed(), "Option Menu Icon is not displayed");
	NXGReports.addStep("Option Menu Icon is displayed", LogAs.PASSED, null);
	rp.optionsMenuIcon.click();
	Assert.assertTrue(rp.deleteOption.isDisplayed(), "Delete option is not displayed");
	NXGReports.addStep("Delete option is displayed", LogAs.PASSED, null);
	rp.deleteOption.click();
	Assert.assertTrue(rp.AcceptPopupOption.isDisplayed(), "Save popup is not displayed");
	NXGReports.addStep("Save popup is displayed", LogAs.PASSED, null);
	rp.AcceptPopupOption.click();
	wait.until(ExpectedConditions.elementToBeClickable(rp.backIcon));
	String DeleteToastMessage=GenericClass.verifyToastMessage(driver);
	Assert.assertTrue(DeleteToastMessage.contains(GenericClass.getData(1, 5, "verizon_pocketRFC")), "'Document deleted from your downloads folder!' is not displayed");
	NXGReports.addStep("'Document deleted from your downloads folder!' is displayed", LogAs.PASSED, null);
	
	wait.until(ExpectedConditions.elementToBeClickable(rp.backIcon));
		
	}
	
	

}
