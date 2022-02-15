package table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Drink {
    private String name;
    private double price;
    private String group;

    @Builder
    public Drink(String name, double price, String group) {
        this.name = name;
        this.price = price;
        this.group = group;
    }
}
