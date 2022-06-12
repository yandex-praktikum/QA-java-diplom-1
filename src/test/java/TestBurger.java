import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;
    Burger burger = new Burger();

    @Test
    public void checkSetBun() {
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void checkAddIngridient() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        Assert.assertEquals("Не добавлен ингридиент бургера", 1, burger.ingredients.size() - initialSize);
    }

    @Test
    public void checkRemoveIngridient() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size() - 1);
        Assert.assertEquals("Не удалён ингридиент бургера", initialSize, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngridient() {
        String newIngredientName = "Тест";
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        int currentSize = burger.ingredients.size();
        int index = currentSize - 1;
        int newIndex = currentSize - 2;
        burger.moveIngredient(index, newIndex);
        Mockito.when(newIngredient.getName()).thenReturn(newIngredientName);
        Assert.assertEquals("Не добавлен ингридиент бургера", newIngredientName, burger.ingredients.get(newIndex).getName());
    }
}
