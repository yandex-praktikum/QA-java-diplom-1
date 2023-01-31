package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    Bun bun;


    @Test
    public void setBuns() {
        String name = "black bun";
        float price = 100F;
        Burger burger = new Burger();
        bun = new Bun(name, price);

        burger.setBuns(bun);

        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0);
    }

    @Test
    public void addIngredient() {
    }

    @Test
    public void removeIngredient() {
    }

    @Test
    public void moveIngredient() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getReceipt() {
    }
}