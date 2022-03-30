package com.greedy.menu.service;

import com.greedy.menu.dto.MenuDTO;
import com.greedy.menu.entity.Category;
import com.greedy.menu.entity.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

import static com.greedy.menu.common.Template.*;
public class MenuService {

    private EntityManager entityManager;

    public List<MenuDTO> findMenuList() {
        entityManager = getEntityManager();

        String query = "SELECT m FROM Menu m";

        List<Menu> menuList = entityManager.createQuery(query, Menu.class).getResultList();

        return parsingList(menuList);
    }


    public MenuDTO findMenuByMenuCode(int menuCode) {
        entityManager = getEntityManager();

        Menu menu = entityManager.find(Menu.class, menuCode);

        close(entityManager);

        return parsing(menu);
    }

    public List<MenuDTO> findMenuByCategoryCode(int categoryCode) {
        entityManager = getEntityManager();
        String query = "SELECT m FROM Menu m JOIN m.category c WHERE c.categoryCode = :categoryCode";

        List<Menu> menuList = entityManager.createQuery(query, Menu.class).setParameter("categoryCode", categoryCode).getResultList();

        close(entityManager);

        return parsingList(menuList);
    }

    public boolean registMenu(MenuDTO menu) {
        boolean result = false;

        entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {

            Category category = entityManager.find(Category.class, menu.getCategoryCode());

            Menu registMenu = new Menu();
            registMenu.setMenuName(menu.getMenuName());
            registMenu.setMenuPrice(menu.getMenuPrice());
            registMenu.setOrderableStatus(menu.getOrderableStatus());
            registMenu.setCategory(category);

            entityManager.persist(registMenu);
            entityTransaction.commit();
            result = true;

        } catch (Exception e) {
            entityTransaction.rollback();
        }

        close(entityManager);

        return result;
    }

    public boolean modifyMenuName(MenuDTO menu) {
        entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Menu changeMenu = entityManager.find(Menu.class, menu.getMenuCode());

        boolean result = false;
        try {
            changeMenu.setMenuName(menu.getMenuName());
            entityTransaction.commit();
            result = true;
        } catch (Exception e) {
            entityTransaction.rollback();
        }


        close(entityManager);

        return result;
    }

    public boolean modifyMenuPrice(MenuDTO menu) {
        entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Menu changeMenu = entityManager.find(Menu.class, menu.getMenuCode());
        boolean result = false;

        try {
            changeMenu.setMenuPrice(menu.getMenuPrice());
            entityTransaction.commit();
            result = true;
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        close(entityManager);

        return result;
    }

    public boolean removeMenu(int menuCode) {
        boolean result = false;

        entityManager = getEntityManager();

        Menu removeMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{
            entityManager.remove(removeMenu);
            entityTransaction.commit();
            result = true;
        } catch(Exception e) {
            entityTransaction.rollback();
        }

        close(entityManager);

        return result;
    }

    private List<MenuDTO> parsingList(List<Menu> menuList) {
        List<MenuDTO> dtoList = new ArrayList<>();

        for(Menu menu: menuList) {
            dtoList.add(parsing(menu));
        }

        return dtoList;
    }

    private MenuDTO parsing(Menu menu) {
        MenuDTO dto = new MenuDTO();

        dto.setMenuCode(menu.getMenuCode());
        dto.setCategoryCode(menu.getCategory().getCategoryCode());
        dto.setMenuPrice(menu.getMenuPrice());
        dto.setMenuName(menu.getMenuName());
        dto.setOrderableStatus(menu.getOrderableStatus());

        return dto;
    }
}
