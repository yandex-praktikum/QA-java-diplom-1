package praktikum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;
//    Pattern pattern = Pattern.compile("(?=[a-zA-Z]*\\s[a-zA-Z]*$)(.{0,19}$)");

    public Bun(String name, float price) {

        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}