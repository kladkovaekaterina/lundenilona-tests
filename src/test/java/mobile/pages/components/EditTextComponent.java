package mobile.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;

public class EditTextComponent {

    public void setValueInEditTextLocator(int indexNumber, int value) {
        $(className("android.widget.EditText"), indexNumber).click();
        $(className("android.widget.EditText"), indexNumber).sendKeys(String.valueOf(value));
    }
}