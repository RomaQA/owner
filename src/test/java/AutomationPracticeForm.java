import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void startTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Vasin");
        $("#userEmail").setValue("test@mail.com");
        $x("//label[contains(.,'Male')]").click();
        $("#userNumber").setValue("79200000000");
       $("#dateOfBirthInput").click();
        for (int i=0; i<10; i++) {
            $("#dateOfBirthInput").sendKeys(Keys.BACK_SPACE);
        }
        $("#dateOfBirthInput").setValue("2 Jan 1990");
        $("#dateOfBirthInput").pressEnter();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").sendKeys("E");
        $("#subjectsInput").pressEnter();

        $x("//label[contains(.,'Sports')]").click();
        $x("//input[@id='uploadPicture']").uploadFile(new File("C:\\file.jpg"));
        $("#currentAddress").setValue("TestAddress");
        $x("//div[@id='state']").scrollTo();
        $x("//div[@id='state']").click();
        $x("//div[contains(text(),'NCR')]").click();
        $x("//div[contains(text(),'Select City')]").click();
        $x("//div[contains(text(),'Delhi')]").click();
        $x("//div[contains(text(),'Delhi')]").click();
        executeJavaScript("arguments[0].click();", $x("//button[@id='submit']"));
        $("#example-modal-sizes-title-lg").shouldBe(Condition.visible);
        $$x("//table[@class='table table-dark table-striped table-bordered table-hover']").shouldHave(CollectionCondition.texts(
                "Label Values\n" +
                        "Student Name Roman Vasin\n" +
                        "Student Email test@mail.com\n" +
                        "Gender Male\n" +
                        "Mobile 7920000000\n" +
                        "Date of Birth 12 January,1990\n" +
                        "Subjects English\n" +
                        "Hobbies Sports\n" +
                        "Picture file.jpg\n" +
                        "Address TestAddress\n" +
                        "State and City NCR Delhi"
        ));
        $("#closeLargeModal").click();







 //      $x("//div[@id='stateCity-wrapper'][contains(text(),'Select State')]").click();







    }
}
