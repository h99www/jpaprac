package com.greedy.menu.comtroller;

import com.greedy.menu.dto.MenuDTO;
import com.greedy.menu.entity.Menu;
import com.greedy.menu.service.MenuService;
import com.greedy.menu.view.ResultView;

public class MenuController {

    private final MenuService service;
    private final ResultView view;

    public MenuController() {
        service = new MenuService();
        view = new ResultView();
    }


    public void findMenuList() {

        view.resultView(service.findMenuList());
    }

    public void findMenuByMenuCode(int menuCode) {

        view.resultView(service.findMenuByMenuCode(menuCode));
    }

    public void findMenuByCategoryCode(int categoryCode) {

        view.resultView(service.findMenuByCategoryCode(categoryCode));
    }

    public void registMenu(MenuDTO menu) {

        sendResult("생성", service.registMenu(menu));
    }

    public void removeMenu(int menuCode) {
        
        sendResult("삭제", service.removeMenu(menuCode));
    }

    public void modifyMenuName(MenuDTO menu) {

        sendResult("이름 수정", service.modifyMenuName(menu));
    }

    public void modifyMenuPrice(MenuDTO menu) {

        sendResult("가격 수정", service.modifyMenuPrice(menu));
    }

    private void sendResult(String message, boolean result) {
        if(result) {
            message += " 성공!";
        } else {
            message += " 실패!";
        }
        view.resultView(message);
    }

}
