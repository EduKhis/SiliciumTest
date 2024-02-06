package com.edhis.page_object_model;

import com.edhis.locators.PageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage {
    public WebDriver webDriver;
    public PageLocators pageLocators = new PageLocators();

    public PracticeFormPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void setFirstName(String firstName) {
        this.webDriver.findElement(pageLocators.getFirstNameField()).sendKeys(firstName);
    }

    public void setSecondName(String secondName) {
        this.webDriver.findElement(pageLocators.getSecondNameField()).sendKeys(secondName);
    }

    public void setEmail(String email) {
        this.webDriver.findElement(pageLocators.getEmailField()).sendKeys(email);
    }

    public void selectGender(String gender) {
        this.webDriver.findElement(choiceGender(gender)).click();

    }

    public void setMobileNumber(String number) {
        this.webDriver.findElement(pageLocators.getMobileNumberField()).sendKeys(number);
    }

    public void setDate(String date) {
        for (int i = 0; i < 10; i++) {
            this.webDriver.findElement(pageLocators.getDateField())
                    .sendKeys(Keys.BACK_SPACE);
        }
        this.webDriver.findElement(pageLocators.getDateField()).sendKeys(date);
    }

    public void setSubject(String subject) {
        this.webDriver.findElement(pageLocators.getSubjectField()).sendKeys(subject);
        this.webDriver.findElement(pageLocators.getSubjectField()).sendKeys(Keys.ENTER);
    }

    public void selectPicture(String picture){
        this.webDriver.findElement(pageLocators.getPictureOption()).sendKeys(picture);
    }

    public void setAddress(String address) {
        this.webDriver.findElement(pageLocators.getAddressField()).sendKeys(address);
    }

    public void setState(String state) {
        By stateOption = pageLocators.getStateOption();
        this.webDriver.findElement(stateOption).sendKeys(state);
        this.waitForElementLoad(stateOption);
        this.webDriver.findElement(stateOption).sendKeys(Keys.ENTER);
    }

    public void setCity(String city) {
        By cityOption = pageLocators.getCityOption();
        this.webDriver.findElement(cityOption).sendKeys(city);
        this.waitForElementLoad(cityOption);
        this.webDriver.findElement(cityOption).sendKeys(Keys.ENTER);
    }

    public void clickSubmitButton() {
        WebElement element = this.webDriver.findElement(pageLocators.getSubmitButton());
        Actions action = new Actions(this.webDriver);
        action.moveToElement(element).click().build().perform();
    }

    private void waitForElementLoad(By elementToLoad) {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(10), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(this.webDriver.findElement(elementToLoad)));
    }

    private By choiceGender(String gender) {
        return switch (gender) {
            case "Male" -> pageLocators.getGenderMale();
            case "Female" -> pageLocators.getGenderFemale();
            default -> pageLocators.getGenderOther();
        };
    }
}
