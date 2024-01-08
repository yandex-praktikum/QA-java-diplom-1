import com.github.javafaker.Faker;
import org.junit.Test;
import praktikum.Bun;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

public class BunTest {

    Faker faker = new Faker();

    @Test
    //Булочке можно дать название и назначить цену
    public void setNameAndPriseFoNewBun() {
        String name = faker.letterify("???? ????");
        int prise = faker.number().numberBetween(10, 500);
        Float priseFloat = (float) prise;

        Bun bun = new Bun(name, priseFloat);

        assertEquals("Неверное название булочки", name, bun.getName());
        assertEquals("Неверная цена булочки", Optional.of(priseFloat), Optional.of(bun.getPrice()));
    }

}