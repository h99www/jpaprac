package com.greedy.menu.service;

import com.greedy.menu.dto.MenuDTO;
import com.greedy.menu.entity.Category;
import com.greedy.menu.entity.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.greedy.menu.common.Template.getEntityManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuServiceTest {
    private MenuService service;
    @BeforeEach
    public void setUp() {
        service = new MenuService();
    }

    @Test
    public void initTest() {
        assertNotNull(getEntityManager());
    }

    @Test
    @DisplayName("전체_메뉴_조회_테스트")
    public void findMenuList_test() {
        List<MenuDTO> menuList = service.findMenuList();

        assertNotNull(menuList);

        menuList.forEach(System.out::println);
    }

    @Test
    @DisplayName("메뉴_번호로_메뉴_조회_테스트")
    public void findMenuByMenuCode_test() {

        MenuDTO menu = service.findMenuByMenuCode(6);

        assertNotNull(menu);
    }

    @Test
    @DisplayName("카테고리_코드로_해당_카테고리의_메뉴_목록_조회")
    public void findMenuByCategoryCode_test() {
        int categoryCode = 10;
        List<MenuDTO> menuList =  service.findMenuByCategoryCode(categoryCode);


        assertNotNull(menuList);

    }

    @Test
    @DisplayName("메뉴_생성_테스트")
    public void registMenu_test() {
        MenuDTO menuDTO =
                new MenuDTO(1023, "안dd녕?", 20000, 2, "Y");

        assertTrue(service.registMenu(menuDTO));


    }
    @Test
    @DisplayName("메뉴_이름_수정_테스트")
    public void modifyMenuName_test() {

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(1);
        menu.setMenuName("안녕");

        assertTrue(service.modifyMenuName(menu));

    }

    @Test
    @DisplayName("메뉴_가격_수정_테스트")
    public void modifyMenuPrice_test() {

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(1);
        menu.setMenuPrice(10000);

        assertTrue(service.modifyMenuPrice(menu));

    }

    @Test
    public void removeMenu_test() {

    }
}