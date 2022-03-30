package com.greedy.menu.service;

import com.greedy.menu.dto.Category;
import com.greedy.menu.dto.Menu;
import com.greedy.menu.entity.MenuEntity;

import javax.persistence.EntityManager;
import static com.greedy.menu.common.Template.*;
public class MenuService {

    private final MenuEntity entity;
    private EntityManager entityManager;

    public MenuService() {
        entity = new MenuEntity();
    }

    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = getEntityManager();

        Menu menu =  entity.findMenuByMenuCode(entityManager, menuCode);

        close(entityManager);

        return menu;
    }

    public Category findMenuByCategofyCode(int categoryCode) {
        entityManager = getEntityManager();

        Category category = entity.findMenuByCategoryCode(entityManager, categoryCode);

        close(entityManager);

        return category;
    }




}
