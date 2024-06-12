package mobile.tests;

import io.qameta.allure.Owner;
import mobile.pages.subsidiary.CaloriesCalculationPage;
import mobile.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("calories-module")
@Owner("e.kladkova")
@DisplayName("Проверка модуля 'Расчет калорий'")
public class CaloriesCalculationTests extends TestBaseMob {

    CaloriesCalculationPage caloriesCalculationPage = new CaloriesCalculationPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Проверка, что при негативном числе рассчитанных калорий кнопка Next не кликабельна")
    void nextWindowDoesNotOpenAfterNegativeCaloriesCalculationTest() {
        caloriesCalculationPage.openCaloriesCalculationPage("Расчет калорий")
                .setWeight(randomUtils.littleNumber)
                .setHeight(randomUtils.littleNumber)
                .setAge(randomUtils.littleNumber)
                .caloriesCalculationResultShouldStartWithMinusSign()
                .clickNextButton()
                .checkCurrentWindowDoesNotHaveText("Расчет калорийности с учетом двигательной активности");
    }

    @Test
    @DisplayName("Проверка, что при положительном числе рассчитанных калорий кнопка Next кликабельна и ведет на следующий экран")
    void nextWindowOpensAfterCorrectCaloriesCalculationTest() {
        caloriesCalculationPage.openCaloriesCalculationPage("Расчет калорий")
                .setWeight(randomUtils.regularNumber)
                .setHeight(randomUtils.regularNumber)
                .setAge(randomUtils.regularNumber)
                .clickNextButton()
                .checkCurrentWindowDoesHaveText("Расчет калорийности с учетом двигательной активности");
    }
}