package praktikum.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BunsInfo {
    BLACK("black bun", 100),
    WHITE("white bun", 200),
    RED("red bun", 300);
    private final String name;
    private final float price;

}
