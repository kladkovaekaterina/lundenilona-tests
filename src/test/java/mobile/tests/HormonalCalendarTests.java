package mobile.tests;

import io.qameta.allure.Owner;
import mobile.pages.subsidiary.HormonalCalendarPage;
import mobile.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Tag("hormonal-module")
@Owner("e.kladkova")
@DisplayName("Проверка модуля 'Гормональный календарь'")
public class HormonalCalendarTests extends TestBaseMob {

    HormonalCalendarPage hormonalCalendarPage = new HormonalCalendarPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Проверка, что при установлении корректной информации открывается Гормональный календарь на текущую дату")
    void checkCalendarOpensWithCurrentDateIfCorrectDataIsSetTest() {
        String currentDay = String.valueOf(LocalDate.now().getDayOfMonth());
        String currentMonth = LocalDate.now().getMonth().toString();
        hormonalCalendarPage.openHormonalCalendarPage("Гормональный календарь")
                .setDate(randomUtils.day, randomUtils.month, randomUtils.year)
                .setLength(7)
                .setDaysAmount(30)
                .clickReadyButton()
                .checkCurrentWindowOpensWithCurrentDate(currentDay, currentMonth);
    }
}