package web.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    public static String href = "https://lundenilona.ru/",
                         userLogin = "testqaguru25kladkova@gmail.com",
                         userName = "testqaguru",
                         userPass = "Testqaguru25kladkova!",
                         wrongUserPass = generateRandomUserPass();

    public static String generateRandomUserPass() {
        return faker.bothify("??????###", false);
    }
}