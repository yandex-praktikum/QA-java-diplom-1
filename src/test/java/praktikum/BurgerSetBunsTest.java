package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Юнит-тест сеттера класса Burger
 */
@RunWith(MockitoJUnitRunner.class)
public class BurgerSetBunsTest {
    // Вместо реального создания булки используем мок
    @Mock
    private Bun bun;

    // Проверяем что сеттер SetBuns добавляет в бургер булку из параметра
    @Test
    public void checkSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(burger.getBuns(), bun);
    }
}
