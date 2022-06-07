package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class BunClassTest {

    private String name;
    private float price;
    private Bun bun;

    private Database database = new Database();

    @Before
    public void setUp() {
        int number_bun = RandomUtils.nextInt(0,database.availableBuns().size()-1);
        name =  database.availableBuns().get(number_bun).name;
        price = database.availableBuns().get(number_bun).price;
        bun = database.availableBuns().get(number_bun);
    }

    @Test
    //проверить получение названия булочки
    public void getNameTest() {
        assertEquals("Ошибка в параметре name класса Bun", name, bun.getName());
    }

    @Test
    //проверить получение цены булочки
    public void getNamePrice() {
        assertEquals("Ошибка в параметре price класса Bun", price, bun.getPrice(), 1e-8);
    }
}
