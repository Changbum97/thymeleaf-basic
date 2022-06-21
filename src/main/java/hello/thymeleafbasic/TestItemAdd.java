package hello.thymeleafbasic;

import hello.thymeleafbasic.ValidationService.Item;
import hello.thymeleafbasic.ValidationService.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestItemAdd {

    private final ItemRepository itemRepository;
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("상품A", "aaa@naver.com", 10000, 10));
        itemRepository.save(new Item("상품B", "bbb@naver.com", 20000, 20));
    }
}
