package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTests {

    Bun bun;
    Ingredient ingredient;

    @Test
    public void shouldHaveBunsInDB() {
        Database database = new Database();
        database.availableBuns().add(bun);
        assertTrue(database.availableBuns().contains(bun));
    }
    @Test
    public void shouldHaveIngredientsInDB(){
        Database database = new Database();
        database.availableIngredients().add(ingredient);
        assertTrue(database.availableIngredients().contains(ingredient));
    }

}