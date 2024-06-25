package web.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    public static String liMainPageLink = "https://lundenilona.ru/",
                         wrongUserPass = generateRandomUserPass();

    public static String generateRandomUserPass() {
        return faker.bothify("??????###", false);
    }
}