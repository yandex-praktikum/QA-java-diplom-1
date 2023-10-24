package praktikum;
import com.github.javafaker.Faker;
import org.junit.*;
import static org.junit.Assert.assertEquals;


public class BunTest {
    Faker faker = new Faker();
    String name = faker.name().name();
    float price =(float)faker.number().randomDouble(2, 0, 10000);

    Bun testBun = new Bun(name, price); //создаем булочку со случайными значениями названия и цены

    @Test
    public void checkName(){ //проверяем, что название булочки такое, как было задано
    String expectedName = name;
        assertEquals(expectedName, testBun.getName());
    }

    @Test
    public void checkPrice(){//проверяем, что цена булочки такая, как была задана
        float expectedPrice = price;
        assertEquals(expectedPrice, testBun.getPrice(), 0.0);
        System.out.println(price);
    }
}
