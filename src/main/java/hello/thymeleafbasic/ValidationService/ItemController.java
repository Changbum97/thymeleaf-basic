package hello.thymeleafbasic.ValidationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "item/itemList";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/addItemForm";
    }

    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute("item") SaveItemForm form, BindingResult bindingResult) {

        // 글로벌에러 처리 부분
        if(form.getPrice() != null && form.getQuantity() != null) {
            int resultPrice = form.getPrice() * form.getQuantity();
            if(resultPrice > 500000000) {
                bindingResult.reject("overTotalPriceMax", new Object[]{500000000, resultPrice}, "글로벌 에러");
            }
        }

        // 에러가 있으면 로그 출력 후 다시 입력폼으로
        if(bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "item/addItemForm";
        }

        Item item = new Item(form.getName(), form.getSellerEmail(), form.getPrice(), form.getQuantity());
        itemRepository.save(item);

        return "redirect:/item";
    }
}
