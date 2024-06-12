package mobile.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        String date = String.format("%s %s %s", day, month, year);
        $(accessibilityId(date)).click();
    }
}