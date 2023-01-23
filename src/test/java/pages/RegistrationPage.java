package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPicture = $x("//input[@id='uploadPicture']"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            stateWrapper = $("#stateCity-wrapper"),
            submit = $("#submit"),
            closeLargeModal = $("#closeLargeModal");


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }


    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage clearLastName(){
        lastNameInput.clear();
        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
        }

    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile(String path){
        uploadPicture.uploadFile(new File(path));
        return this;
    }

    public RegistrationPage setAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        state.scrollTo();
        state.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
            executeJavaScript("arguments[0].click();", submit);
            return this;
        }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
    public RegistrationPage clickClose() {
        closeLargeModal.click();
        return this;
    }


}
