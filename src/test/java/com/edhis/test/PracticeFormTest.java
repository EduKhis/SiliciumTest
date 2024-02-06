package com.edhis.test;

import com.edhis.page_object_model.PracticeFormPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PracticeFormTest {
    private static WebDriver webDriver;
    private static PracticeFormPage practiceFormPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ed_his/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        webDriver.get("https://demoqa.com/automation-practice-form/");
        practiceFormPage = new PracticeFormPage(webDriver);
    }

    @Test
    public void loginTest() {
        fillInAForm(practiceFormPage);
    }

    @AfterClass
    public static void quit() {
        webDriver.quit();
    }

    private void fillInAForm(PracticeFormPage page) {
        page.setFirstName("Ed");
        page.setSecondName("Khis");
        page.setEmail("ed@gmail.com");
        page.selectGender("Male");
        page.setMobileNumber("8999111111");
        page.setDate("08 04 1993");
        page.setSubject("arts");
        page.selectPicture("C:/Users/ed_his/Desktop/desktop/App.jpg");
        page.setAddress("RedFord");
        page.setState("NCR");
        page.setCity("Delhi");

        page.clickSubmitButton();
    }
}
