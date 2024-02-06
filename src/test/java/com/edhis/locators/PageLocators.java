package com.edhis.locators;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class PageLocators {
    /**
     * Поле для ввода имени
     */
    private final By firstNameField = By.id("firstName");

    /**
     * Поле для ввода фамилии
     */
    private final By secondNameField = By.id("lastName");

    /**
     * Поле для ввода почтового адреса
     */
    private final By emailField = By.id("userEmail");

    /**
     * Список для выбора пола
     */
    private final By genderMale = By.xpath(".//div[@id='genterWrapper']/div[2]//div[1]//label[1]");
    private final By genderFemale = By.xpath(".//div[@id='genterWrapper']/div[2]//div[1]//label[2]");
    private final By genderOther = By.xpath(".//div[@id='genterWrapper']/div[2]//div[1]//label[3]");

    /**
     * Поле для ввода телефона
     */
    private final By mobileNumberField = By.id("userNumber");

    /**
     * Поле для ввода даты
     */
    private final By dateField = By.id("dateOfBirthInput");

    /**
     * Поле для ввода комментария
     */
    private final By subjectField = By.id("subjectsInput");


    /**
     * Кнопка выбора изображения
     * */
    private final By pictureOption = By.id("uploadPicture");
    /**
     * Поле для ввода адреса
     */
    private final By addressField = By.id("currentAddress");

    /**
     * Список для выбора страны
     */
    private final By stateOption = By.id("react-select-3-input");

    /**
     * Список для выбора города
     */
    private final By cityOption = By.id("react-select-4-input");

    /**
     * Кнопка отправки формы
     */
    private final By submitButton = By.id("submit");

}
