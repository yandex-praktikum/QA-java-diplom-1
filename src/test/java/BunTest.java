import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

        @Test
        public void getBunNameTest(){
            Bun bun = new Bun(null, 0.0f);
            String expectedResult = null;
            String actualResult = bun.getName();

            Assert.assertEquals("Неправильное имя булки", actualResult, expectedResult);
        }

        @Test
        public void getBunPriceTest() {
            Bun bun = new Bun(null, 0.0f);
            float expectedResult = 0.0f;
            float actualResult = bun.getPrice();

            Assert.assertEquals("Неправильное значение", expectedResult, actualResult, 0.0f);
        }
}
