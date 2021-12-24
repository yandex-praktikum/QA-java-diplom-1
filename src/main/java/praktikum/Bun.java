package praktikum;


import static praktikum.Constant.*;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;
    public boolean expected;

    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }
    public Bun(String name, float price, boolean expected) {
        this.name = name;
        this.price = price;
        this.expected = expected;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getPrice(String name) throws Exception {
        if (name == BLACK_BUN) {
            return BLACK_PRICE;
        } else if (name == RED_BUN) {
            return RED_PRICE;
        } else if (name == WHITE_BUN) {
            return WHITE_PRICE;
        } else {
            throw new Exception("Неизвестная булка");
        }
    }
}