import org.junit.Test;
import praktikum.Bun;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BunTest {
    @Test
    public void testGetBunName() {
        Bun bun = new Bun("wendy's", 10000.0F);
        assertThat(bun.getName(), equalTo("wendy's"));
    }

    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun("wendy's", 10000.0F);
        assertThat(bun.getPrice(), equalTo(10000.0F));
    }
}
