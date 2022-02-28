import org.junit.Test;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BunTest {

    @Test
    public void getNameReturnNameTest(){
        Bun bun = new Bun("Биг-мак",169f);
        String actual = bun.getName();
        assertThat("Метод вернул неверное значение названия.",actual,is("Биг-мак"));
    }

    @Test
    public void getPriceReturnPriceTest(){
        Bun bun = new Bun("Биг-мак",169f);
        float actual = bun.getPrice();
        assertThat("Метод вернул неверное значение цены.",actual,is(169f));
    }


}
