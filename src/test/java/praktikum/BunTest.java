package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;


public class BunTest {
    Bun bun = new Bun("Флюоресцентная булка R2-D3", 988.0F);

    @Test
    public void bunName() {
        MatcherAssert.assertThat("Название сиреневой булки", bun.getName(), containsString("Флюоресцентная булка R2-D3"));
    }

    @Test
    public void bunPrice() {

        MatcherAssert.assertThat("Цена сиреневой булки", bun.getPrice(), equalTo(988.0F));
    }
}