package praktikum;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    Faker faker = new Faker();
    private String NAME = faker.resolve("food.ingredients");
    private float PRICE = new Random().nextFloat();

    @Mock
    Bun bun;

    @Before
    public void initBun() {
        bun = new Bun(NAME, PRICE);
    }


    @Test
    public void checkGetNameTest() {
        assertEquals(NAME, bun.getName());
        System.out.println(NAME);
    }
    @Test
    public void checkGetPrice(){
        assertEquals(PRICE, bun.getPrice(), 0);
        System.out.println(PRICE);
    }
}


