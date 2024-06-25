package mobile.data;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class TestTextData {

    List<String> expectedTextMainPage = Arrays.asList("КРАСОТА","ПИТАНИЕ", "ШАГОМЕР", "БЕРЕМЕННОСТЬ");
    List<String> expectedTextForFirstOnboardingPage = Arrays.asList(
            "Добро пожаловать в приложение",
            "Индивидуальный гормональный календарь",
            "График динамики изменений веса и объема",
            "Шагомер",
            "Калоризатор и личное КБЖУ",
            "Кладезь ценных советов для беременных");
    String expectedFirstTextForSecondOnboardingPage = "Правила использования приложения";
    String expectedSecondTextForSecondOnboardingPage = "Разработчики не несут ответственности за какие-либо решения, принятые вами на основании данной информации, предоставляемой в порядке общих сведений, а не в качестве альтернативы рекомендациям лечащего врача.";
    String expectedThirdTextForSecondOnboardingPage = "Размещенная в приложении информация не заменит личной консультации квалифицированного специалиста.";
}