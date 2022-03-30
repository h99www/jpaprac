package com.greedy.menu.entity;


import com.greedy.menu.dto.Category;
import com.greedy.menu.dto.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MenuEntity {

    /* 보류 */
    /* 전체 메뉴 조회 */
    public List<Menu> findMenuList(EntityManager entityManager) {

        String query = "SELECT m.MENU_CODE, m.MENU_NAME, m.MENU_PRICE, m.CATEGORY_CODE, m.ORDERABLE_STATUS " +
                        "FROM TBL_MENU m " +
                        "WHERE m.MENU_STATUS = 'Y' ";

        List<Menu> menuList = entityManager.createQuery(query).getResultList();

        return menuList;
    }


    /* 메뉴 코드로 메뉴 조회 */
    public Menu findMenuByMenuCode(EntityManager entityManager, int menuCode) {
        Menu menu = entityManager.find(Menu.class, menuCode);

        return menu;
    }


    /* 카테고리 코드로 해당 카테고리의 메뉴 목록 조회 */
    public Category findMenuByCategoryCode(EntityManager entityManager, int categoryCode) {

        return entityManager.find(Category.class, categoryCode);
    }


    /* 에러 */
    /* 신규 메뉴 추가 */
    public void registMenu(EntityManager entityManager, Menu menu) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(menu);
        entityTransaction.commit();

        try {
            entityManager.persist(menu);
            entityTransaction.commit();


        } catch (Exception e) {
            entityTransaction.rollback();
        }

    }

    /* 메뉴 정보 수정 */
    /* 1. 메뉴 이름 수정 */
    public void modifyMenuName(EntityManager entityManager, Menu menu) {
        Menu changeMenu = entityManager.find(Menu.class, menu.getMenuCode());

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            menu.setMenuName(menu.getMenuName());
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    /* 2. 메뉴 가격 수정 */
    public void modifyMenuPrice(EntityManager entityManager, Menu menu) {
        Menu changeMenu = entityManager.find(Menu.class, menu.getMenuCode());

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            menu.setMenuPrice(menu.getMenuPrice());
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    /* 메뉴 삭제 */
    public void removeMenu(EntityManager entityManager, int menuCode) {
        Menu removeMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{
            entityManager.remove(removeMenu);
            entityTransaction.commit();
        } catch(Exception e) {
            entityTransaction.rollback();
        }
    }

}
