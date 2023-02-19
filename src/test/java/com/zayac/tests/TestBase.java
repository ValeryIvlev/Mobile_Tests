package com.zayac.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import com.zayac.config.WebDriverConfig;
import com.zayac.drivers.BrowserstackDriver;
import com.zayac.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

class TestBase {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("device", String.valueOf(System.getProperties()));
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();

        //Attach.attachScreenshot("Last screenshot");
        Attach.attachPageSource();

        closeWebDriver();
        Attach.attachVideo(sessionId);
    }
}
