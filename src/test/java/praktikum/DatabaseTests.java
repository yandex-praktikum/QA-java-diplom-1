package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class DatabaseTests {

    @Test
    void getAvailableBuns() {
        List<Bun> expectedList = List.of(new Bun("bun", 1F));
        Database fakeDatabase = Mockito.mock(Database.class);
        Mockito.when(fakeDatabase.availableBuns()).thenReturn(expectedList);
        Assertions.assertEquals(expectedList, fakeDatabase.availableBuns(),
                "полученный список не соответствует");
    }

    @Test
    void getAvailableIngredients() {
        List<Ingredient> expectedList = List.of(new Ingredient(IngredientType.FILLING, "ingredient", 1F));
        Database fakeDatabase = Mockito.mock(Database.class);
        Mockito.when(fakeDatabase.availableIngredients()).thenReturn(expectedList);
        Assertions.assertEquals(expectedList, fakeDatabase.availableIngredients(),
                "полученный список не соответствует");
    }
}
