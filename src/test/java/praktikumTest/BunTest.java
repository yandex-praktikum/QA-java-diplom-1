package praktikumTest;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void setNameOfBun() {
        Bun bun = new Bun("Pizza", 2.38f);
        Assert.assertEquals("Pizza", bun.getName());
    }

    @Test
    public void setCorrectPrice() {
        Bun bun = new Bun("test_name", 2.31f);
        Assert.assertEquals(2.31f, bun.getPrice(), 0.0);
    }

    /**
     * Из кода видно, что класс Bun  не делает проверок параметров. Однако учитывая, что цена не может быть
     * отрицательной или нулевой величиной, то при тестировании параметра "цена" ожидаем получить положительную
     * величину.
     * Название экземпляра класса не может быть пустым или состоять из пробелов, поэтому длина имени должна
     * быть больше ноля.
     */

//    @Test
//    public void setNegativeBunPrice() {
//        Bun bun= new Bun("test_name", -3.44f);
//        Assert.assertTrue(bun.getPrice() > 0);
//    }
//
//    @Test
//    public void setZeroBunPrice() {
//        Bun bun = new Bun("test-name", 0);
//        Assert.assertTrue(bun.getPrice() > 0);
//    }
//
//    @Test
//    public void setBlancName() {
//        Bun bun = new Bun("     ", 2.21f);
//        Assert.assertTrue(bun.getName().trim().length() > 0);
//    }


}
