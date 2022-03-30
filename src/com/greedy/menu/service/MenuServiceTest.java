package com.greedy.menu.service;

import com.greedy.menu.dto.Category;
import com.greedy.menu.dto.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void findMenuByCategofyCode_test() {

        Category category = service.findMenuByCategofyCode(1);

        assertNotNull(category);
        category.getMenuList().forEach(System.out::println);

    }



}