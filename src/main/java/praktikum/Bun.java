package praktikum;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;

    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        if((name.length() <= 2)
               || (name.length() > 10)
                || name.startsWith(" ")
                || name.endsWith(" ")
                ){
        return null;
    }return name;
    }
    public float getPrice() {
        if (price<0 || price>1000){
            return 0;
        }
        return price;
    }
}