package praktikum;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest extends CreateBurger {

    @Test
    public void getFullPriceBurgerTest(){
        createBurgerWithAllAction();
        float expectedPrice = 700.0F;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice,actualPrice,0.0f);
    }

    @Test
    public void getReceiptTest(){
        createBurgerWithAllAction();
        String actualReceipt = burger.getReceipt();
        assertEquals(ExpectedReceiptsConstant.EXPECTED_RECEIPT, actualReceipt);
    }

}