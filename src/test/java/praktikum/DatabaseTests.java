package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTests {

    @Mock
    private Ingredient mockSauce;

    @Mock
    private Bun mockBun;

    @Test
    public void ingredientCanBeAddedToDatabaseTest(){
        Database database = new Database();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(mockSauce);
        assertEquals(1, ingredients.size());
    }

    @Test
    public void bunCanBeAddedToDatabaseTest(){
        List<Bun> buns = new ArrayList<>();
        buns.add(mockBun);
        assertEquals(1, buns.size());
    }
    @Test
    public void databaseBunsCanBeReturnedTest(){
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertEquals(3, buns.size());
    }

    @Test
    public void databaseIngredientsCanBeReturnedTest(){
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(6, ingredients.size());}
}
