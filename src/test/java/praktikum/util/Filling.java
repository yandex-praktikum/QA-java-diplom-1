package praktikum.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Filling {
    CUTLET("cutlet", 100),
    DINOSAUR("dinosaur", 200),
    SAUSAGE("sausage", 300);

    private final String name;
    private final float price;
}
