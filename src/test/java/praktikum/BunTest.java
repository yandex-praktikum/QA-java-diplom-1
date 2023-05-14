package praktikum;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BunTest {
    Bun bun = new Bun("Круглая",60);

    @Test
    public void testGetName() {
        String expected = "Круглая";
        assertThat(bun.getName()).isEqualTo(expected);
    }

    @Test
    public void testGetPrice() {
        float expected = 60;
        assertThat(bun.getPrice()).isEqualTo(expected);
    }



}
