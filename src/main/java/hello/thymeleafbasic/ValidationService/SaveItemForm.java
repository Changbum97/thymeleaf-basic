package hello.thymeleafbasic.ValidationService;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SaveItemForm {

    @NotBlank
    @Length(max = 10)
    private String name;

    @NotBlank
    @Email
    private String sellerEmail;

    @NotNull
    @Range(min = 100, max = 1000000)
    private Integer price;

    @NotNull
    @Max(999)
    private Integer quantity;

}
