import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)


public class TestAddIngredient {

    @Mock
    praktikum.Burger Burger;

    @Test
    public void addIngredient() {
        Ingredient Ingredient = new Ingredient(SAUCE,"Пример", 50.5F);
        Burger.addIngredient(Ingredient);// вызвали метод с аргументом
        Mockito.verify(Burger).addIngredient(Ingredient);
    }


}
