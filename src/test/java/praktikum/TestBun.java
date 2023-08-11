package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestBun {


    Bun bun = new Bun("Краторная булка N-200i", 1255);

    // Проверка присвоения имени
    @Test
    public void testGetName() {
        String expectedName = "Краторная булка N-200i"; //ожидаемое имя
        String actualName = bun.getName();              //фактическое имя используемое в конструкторе bun

        assertEquals(expectedName, actualName);         //сравнение фактического и ожидаемого результата
    }

    // Проверка присвоения цены
    @Test
    public void testGetPrice() {
        float expectedPrice = 1255;                     // ожидаемая цена
        float actualPrice = bun.getPrice();             // фактическая цена используемая в конструкторе bun

        assertEquals(expectedPrice, actualPrice, 0); ////сравнение фактического и ожидаемого результата
    }
}

