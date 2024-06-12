package web.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtilsWeb {

    Faker faker = new Faker();
    SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
    SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
    SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    public Date randomlyGerenatedBirthDate = faker.date().birthday();

    public String firstName = generateRandomFirstName(),
                  lastName = generateRandomLastName(),
                  email = generateRandomEmail(),
                  phone = generateRandomPhone(),
                  day = generateRandomBirthDay(randomlyGerenatedBirthDate),
                  month = generateRandomBirthMonth(randomlyGerenatedBirthDate),
                  year = generateRandomBirthYear(randomlyGerenatedBirthDate),
                  pass = generateRandomPass();

    public String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public String generateRandomLastName() {
        return faker.name().lastName();
    }

    public String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String generateRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String generateRandomBirthDay(Date randomlyGerenatedBirthDate) {
        return sdfDay.format(randomlyGerenatedBirthDate);
    }

    public String generateRandomBirthMonth(Date randomlyGerenatedBirthDate) {
        return sdfMonth.format(randomlyGerenatedBirthDate);
    }

    public String generateRandomBirthYear(Date randomlyGerenatedBirthDate) {
        return sdfYear.format(randomlyGerenatedBirthDate);
    }

    public String generateRandomPass() {
        return faker.bothify("??????###", false);
    }
}