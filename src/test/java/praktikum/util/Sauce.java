package praktikum.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sauce {
    HOT("hot sauce", 100),
    SOUR_CREAM("sour cream", 200),
    CHILI("chili sauce", 300);
    private final String name;
    private final float price;
}
