import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class TestsBun {
  private Bun bun;
  @Before
   public void setUp(){
    bun = new Bun("Булочка с кунжутом", 51.99f);
  }
  @Test
  public void testBunGetName(){
    assertEquals("Булочка с кунжутом",bun.getName());
  }
  @Test
  public void testBunGetPrice(){
    assertEquals(51.99f,bun.getPrice(),0.0);
  }
}
