package com.greedy.menu.view;

import com.greedy.menu.comtroller.MenuController;

import java.util.Scanner;

public class MenuView {
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

            switch(no) {
                case 1: menuController.findMenuList(); break;
                case 2: menuController.findMenuByMenuCode(inputMenuCode()); break;
                case 3: menuController.findMenuByCategoryCode(inputCategoryCode()); break;
                case 4: menuController.; break;
                case 5: menuController.; break;
                case 6: menuController.; break;
                case 0: menuController.; break;
                default : System.out.println("다시 입력하세요"); break;
            }

            if(no == 0) {
                break;
            }


        } while(true);
    }

    private int inputMenuCode() {
        System.out.print("메뉴코드를 입력하세요 : ");

        return sc.nextInt();
    }
}


















