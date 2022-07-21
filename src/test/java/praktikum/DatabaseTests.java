package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTests {

    @Mock
    Bun bun;

    @Mock
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