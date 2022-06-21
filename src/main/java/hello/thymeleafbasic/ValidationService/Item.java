package hello.thymeleafbasic.ValidationService;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String name;
    private String sellerEmail;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String name, String sellerEmail, Integer price, Integer quantity) {
        this.name = name;
        this.sellerEmail = sellerEmail;
        this.price = price;
        this.quantity = quantity;
    }
}
