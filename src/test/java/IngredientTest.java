import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);
    @Mock
    Ingredient ingredientMock;

    @Test
    public void shouldBeTwoIngredientTypesEquals() {
        Assert.assertEquals("Должна быть начинка (FILLING)", IngredientType.FILLING, ingredient.getType());
    }
    @Test
    public void shouldBeTwoIngredientTypesNotEquals() {
        Assert.assertNotEquals("Соуса быть не должно!", IngredientType.SAUCE, ingredient.getType());
    }
    @Test
    public void checkArgumentsMock() {
        ingredientMock.getType();
        Mockito.verify(ingredientMock).getType();
    }
    @Test
    public void shouldBeTwoIngredientNamesEquals() {
        Assert.assertEquals("Должен быть Сыр с астероидной плесенью", "Сыр с астероидной плесенью", ingredient.getName());
    }
    @Test
    public void shouldBeTwoIngredientNamesNotEquals() {
        Assert.assertNotEquals("Выбери другую начинку", "Говяжий метеорит (отбивная)", ingredient.getName());
    }
    @Test
    public void howManyTimesOtherMethodCalledMock() {
        ingredientMock.getName();
        ingredientMock.getName();
        ingredientMock.getName();
        ingredientMock.getName();
        ingredientMock.getName();
        ingredientMock.getName();
        ingredientMock.getName();
        Mockito.verify(ingredientMock, Mockito.times(7)).getName();
    }
    @Test
    public void shouldBeTwoIngredientPricesEquals() {
        Assert.assertEquals("Стоимость начинки должна быть равна 4142", 4142, ingredient.getPrice(), 0);
    }
}

