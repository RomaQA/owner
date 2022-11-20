package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;


import java.io.File;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }
    @Test
    void startTest() {
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName("Vasin")
                .setEmail("test@mail.com")
                .setGender("Male")
                .setPhone("79200000000")
                .setBirthDate("15","May","2000")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadFile("src/test/resources/file.jpg")
                .setAddress("TestAddress")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();
        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", "Roman Vasin")
                        .verifyResult("Student Email", "test@mail.com")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "7920000000")
                        .verifyResult("Date of Birth", "15 May,2000")
                        .verifyResult("Subjects", "English")
                        .verifyResult("Hobbies", "Sports")
                        .verifyResult("State and City", "NCR Delhi");
        registrationPage.clickClose();
    }
}
