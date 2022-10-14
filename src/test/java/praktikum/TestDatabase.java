package praktikum;

import org.junit.Test;

import javax.xml.crypto.Data;

import java.util.List;

import static org.junit.Assert.*;

public class TestDatabase {

    Database db = new Database();

    @Test
    public void testAvailableBuns(){
        List<Bun> buns = db.availableBuns();
        assertFalse(buns.isEmpty());
        assertEquals(3, buns.size());
    }

    @Test
    public void testAvailableIngredients(){
        List<Ingredient> ingredients = db.availableIngredients();
        assertFalse(ingredients.isEmpty());
        assertEquals(6, ingredients.size());
    }
}
