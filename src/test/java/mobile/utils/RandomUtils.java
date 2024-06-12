package mobile.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class RandomUtils {

    Faker faker = new Faker();
    SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
    SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", new Locale("en"));
    SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    public Date randomlyGerenatedDate = faker.date().past(10, TimeUnit.DAYS);

    public int littleNumber = generateRandomLittleNumber(),
               regularNumber = generateRandomRegularNumber();

    public String day = generateRandomDay(randomlyGerenatedDate),
                  month = generateRandomMonth(randomlyGerenatedDate),
                  year = generateRandomYear(randomlyGerenatedDate);

    public int generateRandomLittleNumber() {
        return faker.number().numberBetween(1, 10);
    }

    public int generateRandomRegularNumber() {
        return faker.number().numberBetween(11, 99);
    }

    public String generateRandomDay(Date randomlyGerenatedDate) {
        return sdfDay.format(randomlyGerenatedDate);
    }

    public String generateRandomMonth(Date randomlyGerenatedDate) {
        return sdfMonth.format(randomlyGerenatedDate);
    }

    public String generateRandomYear(Date randomlyGerenatedDate) {
        return sdfYear.format(randomlyGerenatedDate);
    }
}