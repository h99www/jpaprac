package com.greedy.menu.entity;

import com.greedy.menu.dto.Category;
import com.greedy.menu.dto.Menu;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MenuEntityTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private MenuEntity me;
    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
        
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
        this.me = new MenuEntity();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }
    
    @AfterEach
    public void closeManager() {
        entityManager.close();
    }


    @Test
    public void 전체_메뉴_조회() {
        List<Menu> menuList = me.findMenuList(entityManager);

        assertNotNull(menuList);

    }


    @Test
    public void 메뉴코드로_메뉴_조회() {
        int menuCode = 1;
        Menu menu = me.findMenuByMenuCode(entityManager, menuCode);

        assertNotNull(menu);
        System.out.println("menu = " + menu);

    }

    @Test
    public void 카테고리_코드로_해당_카테고리의_메뉴_목록_조회() {

        int categoryCode = 5;
        Category category = me.findMenuByCategoryCode(entityManager, categoryCode);

        assertNotNull(category.getMenuList());
        category.getMenuList().forEach(System.out::println);
    }

    @Test
    public void 신규_메뉴_추가() {
        Menu menu = new Menu();

        Category category = new Category();
        category.setRefCategoryCode(3);

        menu.setMenuName("새로운 메뉴");
        menu.setMenuPrice(10000);
        menu.setOrderableStatus("Y");
        menu.setCategory(category);

        me.registMenu(entityManager, menu);


        String jpql = "SELECT m.memberNo FROM Menu m";
        List<Integer> memberList = entityManager.createQuery(jpql).getResultList();

        memberList.forEach(System.out::println);




    }

    @Test
    public void 메뉴_가격_수정() {
        Menu menu = entityManager.find(Menu.class, 5);

        int menuPrice = menu.getMenuPrice();
        menu.setMenuPrice(1000000);
        me.modifyMenuPrice(entityManager, menu);

        menu = entityManager.find(Menu.class, 5);

        assertNotEquals(menuPrice, menu.getMenuPrice());

        System.out.println("menuPrice = " + menuPrice);
        System.out.println("menu.getMenuPrice() = " + menu.getMenuPrice());
    }

    @Test
    public void 메뉴_이름_수정() {
        Menu menu = entityManager.find(Menu.class, 5);

        int menuPrice = menu.getMenuPrice();
        menu.setMenuName("안녕");
        me.modifyMenuName(entityManager, menu);

        menu = entityManager.find(Menu.class, 5);

        assertNotEquals(menuPrice, menu.getMenuPrice());

        System.out.println("menuPrice = " + menuPrice);
        System.out.println("menu.getMenuPrice() = " + menu.getMenuPrice());
    }

    @Test
    public void 메뉴_삭제() {
        int menuCode = 5;
        me.removeMenu(entityManager, 5);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Menu menu = entityManager.find(Menu.class, 5);

        assertNull(menu);

        entityTransaction.rollback();

    }

}








































