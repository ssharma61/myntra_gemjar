package com.qa.myntra;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Label;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gemini.generic.ui.utils.DriverAction.*;


public class myStepdefs {
    WebElement profileIcon;
     String currentUrl;
    static ArrayList<String> handles;

    @Given("^Myntra icon and Profile icon is displayed$")
    public void myntraIconAndProfileIconIsDisplayed() {
        WebElement myntraIcon = DriverManager.getWebDriver().findElement(myntraLocators.myntraIcon);
        profileIcon = DriverManager.getWebDriver().findElement(myntraLocators.profileIcon);
        if (myntraIcon.isDisplayed() && profileIcon.isDisplayed()){
            GemTestReporter.addTestStep("HomePage Icon search","HomePage Icon search result is as expected", STATUS.PASS, takeSnapShot());
        } else GemTestReporter.addTestStep("HomePage Icon search","HomePage Icon search result is not as expected", STATUS.FAIL, takeSnapShot());
        }

    @Then("^Main elements are available on screen$")
    public void mainElementsAreAvailableOnScreen() {
        List<WebElement> mainPageElements1List = DriverManager.getWebDriver().findElements(myntraLocators.mainPageElements1);
        List<String> mainPageElement1Text = new ArrayList<>();
        for (WebElement element : mainPageElements1List) {
            mainPageElement1Text.add(element.getText());
        }
        List<String> manualList1 = Arrays.asList("MEN", "WOMEN", "KIDS", "HOME & LIVING", "BEAUTY", "STUDIO");
        Assert.assertEquals(mainPageElement1Text, manualList1);
        List<WebElement> mainPageElements2List = DriverManager.getWebDriver().findElements(myntraLocators.mainPageElements2);
        List<String> mainPageElement2Text = new ArrayList<>();
        for (WebElement element : mainPageElements2List) {
            mainPageElement2Text.add(element.getText());
        }
        List<String> manualList2 = Arrays.asList("Profile", "Wishlist", "Bag");
        Assert.assertEquals(mainPageElement2Text, manualList2);
        GemTestReporter.addTestStep("HomePage main elements available","HomePage main elements result is as expected", STATUS.PASS, takeSnapShot());
    }


    @And("Validate if Search tab is available")
    public void validateIfSearchTabIsAvailable() {
        WebElement searchTab = DriverManager.getWebDriver().findElement(myntraLocators.searchTab);
        Assert.assertTrue(searchTab.isDisplayed());
        GemTestReporter.addTestStep("search bar is available","search bar result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Given("I have clicked on Signup or login button under profile")
    public void iHaveClickedOnSignupOrLoginButtonUnderProfile() {
        String myntraUrl = DriverAction.getCurrentURL();
            Assert.assertTrue(myntraUrl.equalsIgnoreCase("https://www.myntra.com/"));
        DriverAction.hoverOver(myntraLocators.profileIcon);
        DriverAction.click(myntraLocators.loginOption);
            GemTestReporter.addTestStep("login button click","login button click is as expected", STATUS.PASS, takeSnapShot());
    }

    @Then("Validate the UI is redirected to login or signup page")
    public void validateTheUIIsRedirectedToLoginOrSingupPage() {
        String loginUrl = DriverAction.getCurrentURL();
        Assert.assertEquals(loginUrl, "https://www.myntra.com/login?referer=https://www.myntra.com/");
//        Assert.assertTrue(loginUrl.equalsIgnoreCase("https://www.myntra.com/login?referer=https://www.myntra.com/"));
        GemTestReporter.addTestStep("URL Validation","URL populating is as expected", STATUS.PASS, takeSnapShot());
    }

    @And("User should not able to proceed with invalid mobile number")
    public void userShouldNotAbleToProceedWithInvalidMobileNumber() {
            WebElement mobileNumberField = DriverManager.getWebDriver().findElement(myntraLocators.mobileNumberField);
            DriverAction.click(mobileNumberField);
            DriverAction.typeText(mobileNumberField, "123456");
        GemTestReporter.addTestStep("mobile number field exist", "Input is sent", STATUS.PASS, takeSnapShot());
        DriverAction.click(myntraLocators.continueButton);
            String invalidMobileNumberError = DriverManager.getWebDriver().findElement(myntraLocators.invalidMobileNoError).getText();
            Assert.assertTrue(invalidMobileNumberError.contains("Please enter a valid mobile number"));
        GemTestReporter.addTestStep("Continue Button clickable", "Continue Button clicked", STATUS.PASS, takeSnapShot());
    }

    @Then("User to validate the termsofuse and privacypolicy link")
    public void userToValidateTheTermsofuseAndPrivacypolicyLink() throws InterruptedException {
        WebElement termsOfUse = DriverAction.getElement(myntraLocators.termsOfUse);
        WebElement privacyPolicy = DriverAction.getElement(myntraLocators.privacyPolicy);
        if (termsOfUse.isDisplayed() && privacyPolicy.isDisplayed()) {
            DriverAction.click(myntraLocators.termsOfUse);
            String termsOfUseURL = DriverManager.getWebDriver().getCurrentUrl();
            Assert.assertTrue(termsOfUseURL.contains("https://www.myntra.com/termsofuse"), "Url Validation Pass");
            DriverAction.navigateBack();
            DriverAction.click(myntraLocators.privacyPolicy);
            String privacyPolicyUrl = DriverManager.getWebDriver().getCurrentUrl();
            Assert.assertTrue(privacyPolicyUrl.contains("https://www.myntra.com/privacypolicy"), "Url Validation Pass");
            DriverAction.navigateBack();
            GemTestReporter.addTestStep("Terms of use and Privacy Policy", "Terms of Use and Privacy Policy Validation", STATUS.PASS, takeSnapShot());
        }
    }

    @Then("^click on search text and provide \\\"(.*)\\\" and validate the url$")
    public void clickOnSearchTextAndProvideAndValidateTheUrl(String saree) {
        WebElement searchTab = DriverManager.getWebDriver().findElement(myntraLocators.searchTab);
        searchTab.sendKeys(saree, Keys.ENTER);
        String searchUrl = DriverAction.getCurrentURL();
        Assert.assertTrue(searchUrl.contains("https://www.myntra.com/"+saree));
        GemTestReporter.addTestStep("Search tab and saree elements available","Search tab and saree elements available result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Then("Validate navigated page opened correctly")
    public void validateNavigatedPageOpenedCorrectly() {
List<WebElement>filterTagElement = DriverManager.getWebDriver().findElements(myntraLocators.filterTagElement);
        List<String> filterTagElement1Text = new ArrayList<>();
        for (WebElement element : filterTagElement) {
            filterTagElement1Text.add(element.getText());
        }
        List<String> manualList3 = Arrays.asList("CATEGORIES", "BRAND", "PRICE", "COLOR", "DISCOUNT RANGE");
        Assert.assertEquals(filterTagElement1Text, manualList3);
        GemTestReporter.addTestStep("Navigated page open correctly", "navigated page Validation", STATUS.PASS, takeSnapShot());
    }

    @Then("Validate data under all filter tags")
    public void validateDataUnderAllFilterTags() {
        List<WebElement> categoriesList = DriverAction.getElements(myntraLocators.categoryTag);
        List<WebElement> brandList = DriverAction.getElements(myntraLocators.brandTag);
        List<WebElement> priceList = DriverAction.getElements(myntraLocators.priceTag);
        List<WebElement> discountRangeList = DriverAction.getElements(myntraLocators.discountRangeTag);
        List<WebElement> colorList = DriverAction.getElements(myntraLocators.colorTag);
        Assert.assertNotNull(categoriesList);
        Assert.assertNotNull(brandList);
        Assert.assertNotNull(priceList);
        Assert.assertNotNull(discountRangeList);
        Assert.assertNotNull(colorList);
        GemTestReporter.addTestStep("filter tag elements available","filter tag elements available result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Then("validate the navigated page elements")
    public void validateTheNavigatedPageElements() {
        List<WebElement> sortTabList = DriverAction.getElements(myntraLocators.sortTab);
        Assert.assertTrue(sortTabList.size()>0, "Validation Pass");
        GemTestReporter.addTestStep("Elements available on navigated page","Elements available on navigated page result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Given("^Hover on \\\"(.*)\\\" and click on \\\"(.*)\\\"$")
    public void hoverOnAndClickOn(String Women, String Dresses) {
        String women = "//div[@class='desktop-navContent']/div/a[contains(text(), '%s')]";
        DriverAction.hoverOver(By.xpath(String.format(women, Women)));
        WebElement womenContainer = DriverAction.getElement(myntraLocators.desktopContainerWomen);
        Assert.assertTrue(womenContainer.isDisplayed());
        String dresses = "//div[@class='desktop-categoryContainer']/li/ul/li/a[contains(text(), '%s')]";
        DriverManager.getWebDriver().findElement(By.xpath(String.format(dresses, Dresses))).click();
        GemTestReporter.addTestStep("Hover on women and click on dresses","Hover and click result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Then("Validate the URL on navigated women jacket page")
    public void validateTheUrlOnNavigatedWomenJacketPage() {
        currentUrl = DriverAction.getCurrentURL();
        Assert.assertTrue(currentUrl.contains("https://www.myntra.com/dresses"));
        GemTestReporter.addTestStep("URL navigated","URL navigated result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Then("Validate the images are visible on screen")
    public void validateTheImagesAreVisibleOnScreen() {
        List<WebElement> topWearImgValidation = DriverAction.getElements(myntraLocators.homePageImg);
        Assert.assertTrue(topWearImgValidation.size()>0, "Validation Pass");
        List<WebElement> homePageBrandName = DriverAction.getElements(myntraLocators.homePageBrandName);
        for (int i = 0; i < homePageBrandName.size(); i++) {
            String homePageBrandNameListText = homePageBrandName.get(i).getText();
            if (homePageBrandName.isEmpty()) {
                System.out.println("No Brand Names");
            }
            if (homePageBrandNameListText.matches("[a-zA-Z]+")) { //Matches with (a-z or A-Z)
                System.out.println("Data present" + homePageBrandNameListText);
            }
            if(homePageBrandNameListText.matches("[0-9]+")) {
                System.out.println("No brand available");
            }
        }
        GemTestReporter.addTestStep("Images available","Images available result is as expected", STATUS.PASS, takeSnapShot());
    }
    @Then("Check brand button search functionality")
    public void checkBrandButtonSearchFunctionality() throws InterruptedException {
        DriverAction.click(myntraLocators.brandMoreTag);
        WebElement brandMorePageOpen = DriverAction.getElement(myntraLocators.brandMorePageOpen);
        WebElement searchBrandTag = DriverAction.getElement(myntraLocators.searchBrandTag);
        Assert.assertTrue(brandMorePageOpen.isDisplayed() && searchBrandTag.isDisplayed());
        List<WebElement> searchTabTextList1 = DriverManager.getWebDriver().findElements(myntraLocators.brandTextInSearchTab);
        DriverAction.getElement(myntraLocators.searchBrandTag).sendKeys("Nike");
        List<WebElement> searchTabTextList2 = DriverAction.getElements(myntraLocators.brandTextInSearchTab);
        Assert.assertTrue(searchTabTextList1.size()>searchTabTextList2.size());
        DriverAction.click(myntraLocators.brandCheckBox);
        DriverAction.click(myntraLocators.brandPageCloseButton);
        Thread.sleep(2000);
        List<WebElement> homePageBrandName1 = DriverAction.getElements(myntraLocators.homePageBrandName);
        for (int i = 0; i < homePageBrandName1.size(); i++) {
            String homePageBrandNameListText1 = homePageBrandName1.get(i).getText();
            Assert.assertTrue(homePageBrandNameListText1.contains("Nike"), "Validation Pass");
        }
        GemTestReporter.addTestStep("Brand button search is available","Brand button search available result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Then("Go to the end of page and validate the number of pages and available buttons")
    public void goToTheEndOfPageAndValidateTheNumberOfPagesAndAvailableButtons() throws InterruptedException {
        DriverAction.click(By.xpath("//label[@class='filter-summary-removeFilter']"));
        WebElement nextButton = DriverManager.getWebDriver().findElement(myntraLocators.nextButton);
        DriverAction.click(nextButton);
        String nextButtonUrl = DriverAction.getCurrentURL();
        System.out.println(nextButtonUrl);
        Assert.assertTrue(nextButtonUrl.contains("p=2"));
        WebElement previousButton = DriverManager.getWebDriver().findElement(myntraLocators.previousButton);
        if (previousButton.isDisplayed()){
            DriverAction.click(previousButton);
            String previousURL = DriverAction.getCurrentURL();
            Assert.assertEquals(previousURL, currentUrl);
        }
    }

    @Given("Click on image and validate if it opens in new window")
    public void clickOnImageAndValidateIfItOpensInNewWindow() throws InterruptedException {
        clickOnSearchTextAndProvideAndValidateTheUrl("saree");
        Thread.sleep(1000);
        DriverAction.click(myntraLocators.firstImgClick);
        handles = new ArrayList<String>(DriverAction.getWindowHandles());
        Assert.assertEquals(handles.size(), 2);
        GemTestReporter.addTestStep("Validate window handles","window handles result is as expected", STATUS.PASS, takeSnapShot());
    }

    @Then("Validate the URL and text on the window")
    public void validateTheURLAndTextOnTheWindow() {
        WebElement firstImgOldWindow = DriverAction.getElement(myntraLocators.firstImgText(1));
        String firstImgOldWindowText = firstImgOldWindow.getText();
        DriverAction.switchToWindow(handles.get(1));
        String newTabUrl = DriverAction.getCurrentURL();
        System.out.println(newTabUrl);
        Assert.assertTrue(newTabUrl.contains("https://www.myntra.com/sarees"));
        WebElement firstImgNewWindow = DriverAction.getElement(myntraLocators.firstImgNewWindow);
        String firstImgNewWindowText = firstImgNewWindow.getText();
        Assert.assertEquals(firstImgNewWindowText, firstImgOldWindowText);
        GemTestReporter.addTestStep("Validate URL and text of new window","New window validation result is as expected", STATUS.PASS, takeSnapShot());
    }

    @And("Validate a click on ADD TO BAG, it should ask for size")
    public void validateAClickOnADDTOBAGItShouldAskForSize() {

    }

    @Then("^Select the size \\\"(.*)\\\" and click on ADD TO BAG and validate item added to bag$")
    public void selectTheSizeAndClickOnADDTOBAGAndValidateItemAddedToBag(String M) {
    }

    @And("Validate checkout page")
    public void validateCheckoutPage() {
        
    }

    @Then("Validate Remove and wishlist functionality")
    public void validateRemoveAndWishlistFunctionality() {
    }
}