import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    Bun bun = new Bun("bunName", 1.1f);

    @Test
    public void validateName() {
        assertThat(bun.getName(), is("bunName"));
    }

    @Test
    public void validatePrice() {
        assertThat(bun.getPrice(), is(1.1f));
    }
}
