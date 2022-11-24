package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;


import java.io.File;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    String  firstName = faker.name().firstName();
    String  lastName = faker.name().lastName();
    String  address = faker.address().streetAddress();
    String  email = faker.internet().emailAddress();
    String  number = faker.phoneNumber().subscriberNumber(10);
    String  gender = "Male",
            day = "15",
            month = "May",
            year = "2000",
            subject = "English",
            hobbies = "Sports",
            path = "src/test/resources/file.jpg",
            state = "NCR",
            city = "Delhi";

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void startTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(number)
                .setBirthDate(day,month,year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .uploadFile(path)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();
        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email",email)
                        .verifyResult("Gender", gender)
                        .verifyResult("Mobile", number)
                        .verifyResult("Date of Birth", day + " " + month + ","+year)
                        .verifyResult("Subjects", subject)
                        .verifyResult("Hobbies", hobbies)
                        .verifyResult("State and City", state + " " + city);
        registrationPage.clickClose();
    }
}
