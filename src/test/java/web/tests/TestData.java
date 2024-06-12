package web.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    public static String href = "https://lundenilona.ru/",
                         userLogin = "kladkova92@mail.ru",
                         userName = "Екатерина",
                         userPass = "Kkater12!",
                         wrongUserPass = generateRandomUserPass();

    public static String generateRandomUserPass() {
        return faker.bothify("??????###", false);
    }
}