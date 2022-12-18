package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class BunTest {
        Bun bun;

        @Before
        public void setup() {
            bun = new Bun("Булочка с кунжутом", 100);
        }

        @Test // проверка получения названия булочки
        public void shouldGetName() {
            String actual = "Булочка с кунжутом";
            assertEquals(actual, bun.getName());
        }

        @Test // проверка получения стоимости булочки
        public void shouldGetPrice() {
            float actual = 100;
            assertEquals(actual, bun.getPrice(),0);
        }
    }
}
