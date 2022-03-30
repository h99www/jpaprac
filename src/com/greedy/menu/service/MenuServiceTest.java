package com.greedy.menu.service;

import com.greedy.menu.dto.Category;
import com.greedy.menu.dto.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuServiceTest {
    private MenuService service;
    @BeforeEach
    public void setUp() {
        service = new MenuService();
    }

    @Test
    public void findMenuByMenuCode_test() {

        Menu menu = service.findMenuByMenuCode(6);

        assertNotNull(menu);
    }

    @Test
    public void findMenuByCategoryCode_test() {

        Category category = service.findMenuByCategoryCode(5);

        assertNotNull(category);
        System.out.println("category = " + category);

    }

    @Test
    public void modifyMenuName_test() {

        Menu menu = new Menu();
        menu.setMenuCode(5);
        menu.setMenuName("안녕");

        assertTrue(service.modifyMenuName(menu));

    }

    @Test
    public void modifyMenuPrice_test() {

        Menu menu = new Menu();
        menu.setMenuCode(5);
        menu.setMenuPrice(10000);

        assertTrue(service.modifyMenuName(menu));

    }

    @Test
    public void removeMenu_test() {


    }


}