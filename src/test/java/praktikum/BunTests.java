package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BunTests {

    @Test
    void getBunParams() {
        String name = "testName";
        Float price = 10F;
        Bun bun = new Bun(name, price);
        Assertions.assertAll(
                () -> Assertions.assertEquals(name, bun.getName(), "полученное имя не соответствует"),
                () -> Assertions.assertEquals(price, bun.getPrice(), "полученная цена не соответствует")
        );
    }
}
