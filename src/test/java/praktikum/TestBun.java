package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TestBun {
    String expectedName = "test_bun";
    Float expectedPrice = 80.80F;

    @Test
    public void checkBunGetName() {
        Bun testBun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals(expectedName, testBun.getName());
    }

    @Test
    public void checkBunGetPrice() {
        Bun testBun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals(expectedPrice, testBun.getPrice(), 0.0f);
    }
}
