package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);
    @Mock
    Ingredient ingredientMock;

    //сравнение ингридиентов - начинка
    @Test
    public void shouldBeTwoIngredientTypesEquals() {
        Assert.assertEquals("Должна быть начинка (FILLING)", IngredientType.FILLING, ingredient.getType());
    }
    //сравнение разных типов ингридиентов
    @Test
    public void shouldBeTwoIngredientTypesNotEquals() {
        Assert.assertNotEquals("Соуса быть не должно!", IngredientType.SAUCE, ingredient.getType());
    }
    //мок Проверить аргументы
    @Test
    public void checkArgumentsMock() {
        ingredientMock.getType();
        Mockito.verify(ingredientMock).getType();
    }
    //сравнение названий ингридиентов
    @Test
    public void shouldBeTwoIngredientNamesEquals() {
        Assert.assertEquals("Должен быть Сыр с астероидной плесенью", "Сыр с астероидной плесенью", ingredient.getName());
    }
    //сравнение разных наименований начинок
    @Test
    public void shouldBeTwoIngredientNamesNotEquals() {
        Assert.assertNotEquals("Выбери другую начинку", "Говяжий метеорит (отбивная)", ingredient.getName());
    }
    //мок Проверить, сколько раз вызвали метод
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
    //сравнение цены ингридиентов
    @Test
    public void shouldBeTwoIngredientPricesEquals() {
        Assert.assertEquals("Стоимость начинки должна быть равна 4142", 4142, ingredient.getPrice(), 0);
    }
}