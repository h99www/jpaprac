package com.greedy.menu.view;

import com.greedy.menu.comtroller.MenuController;
import com.greedy.menu.dto.MenuDTO;
import com.greedy.menu.entity.Category;
import com.greedy.menu.entity.Menu;

import java.util.Scanner;

public class MenuView implements ViewName {
    private final MenuController menuController;
    private final Scanner sc;

    public MenuView() {
        menuController = new MenuController();
        sc = new Scanner(System.in);
    }

    public void run() {

        do {
            System.out.println("=====================================");
            System.out.println("1. 전체 목록 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 카테고리 코드로 카테고리의 메뉴 목록 조회");
            System.out.println("4. 신규 메뉴 추가");
            System.out.println("5. 메뉴 수정");
            System.out.println("6.메뉴 삭제");
            System.out.println("0.종료");
            System.out.print("입력 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1: menuController.findMenuList(); break;
                case 2: menuController.findMenuByMenuCode(inputCode(DETAIL_MENU_CODE)); break;
                case 3: menuController.findMenuByCategoryCode(inputCode(DETAIL_CATEGORY_CODE)); break;
                case 4: menuController.registMenu(registMenu()); break;
                case 5: modify(); break;
                case 6: menuController.removeMenu(inputCode(REMOVE_MENU_CODE)); break;
                case 0: break;
                default: System.out.println(TRY_AGAIN); break;
            }

            if (no == 0) {
                break;
            }

        } while (true);
    }

    private void modify() {

        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("==================");
            System.out.println("메뉴 정보 수정");
            System.out.println("1. 메뉴 이름 수정");
            System.out.println("2. 메뉴 가격 수정");
            System.out.println("0. 뒤로가기");
            System.out.print("입력 : ");

            int no = sc.nextInt();

            switch(no) {
                case 1: menuController.modifyMenuName(modifyName()); break;
                case 2: menuController.modifyMenuPrice(modifyPrice()); break;
                default : System.out.println("다시 입력하세요"); break;
            }
            if (no == 0) {
                break;
            }

        } while (true);
    }

    private MenuDTO modifyPrice() {
        MenuDTO menu = new MenuDTO();
        System.out.print("수정할 메뉴 코드를 입력히세요 : ");
        menu.setMenuCode(sc.nextInt());
        System.out.print("수정할 메뉴 가격을 입력히세요 : ");
        menu.setMenuPrice(sc.nextInt());
        sc.nextLine();
        return menu;
    }

    private MenuDTO modifyName() {
        MenuDTO menu = new MenuDTO();
        System.out.print("수정할 메뉴 코드를 입력히세요 : ");
        menu.setMenuCode(sc.nextInt());
        System.out.print("수정할 메뉴 이름을 입력히세요 : ");
        sc.nextLine();
        menu.setMenuName(sc.nextLine());

        return menu;
    }

    private MenuDTO registMenu() {
        MenuDTO menu = new MenuDTO();

        System.out.print("메뉴 코드를 입력하세요 : ");
        menu.setMenuPrice(sc.nextInt());

        System.out.print("메뉴 이름을 입력하세요 : ");
        sc.nextLine();
        menu.setMenuName(sc.nextLine());

        System.out.print("메뉴 가격을 입력하세요 : ");
        menu.setMenuPrice(sc.nextInt());

        System.out.print("카테고리 번호를 입력하세요 : ");
        menu.setCategoryCode(sc.nextInt());

        sc.nextLine();
        System.out.print("주문 상태를 입력하세요 (Y/N) : ");
        menu.setOrderableStatus(sc.nextLine());


        return menu;
    }

    private int inputCode(String message) {
        System.out.print(message);

        return sc.nextInt();
    }
}
