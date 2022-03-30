package com.greedy.menu.view;

import com.greedy.menu.dto.MenuDTO;
import com.greedy.menu.entity.Menu;

import java.util.List;

public class ResultView {


    public void resultView(MenuDTO menu) {

        System.out.println(menu);
    }
    public void resultView(List<MenuDTO> menuList) {

        menuList.forEach(System.out::println);
    }

    public void resultView(String message) {

        System.out.println(message);
    }


}
