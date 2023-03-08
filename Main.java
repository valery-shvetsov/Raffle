//Необходимо написать проект, для розыгрыша в магазине игрушек. 
//Функционал должен содержать добавление новых игрушек и задания веса для выпадения игрушек.

package raffle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static final String TEXT_RED = "\u001B[31m";
        public static final String TEXT_BLACK = "\u001B[30m";
        public static final String TEXT_GREEN = "\u001B[32m";
        public static final String TEXT_BLUE = "\u001B[34m";
        public static final String TEXT_RESET = "\u001B[0m";
        public static final String TEXT_PURPLE = "\u001B[35m";
        public static final String TEXT_CYAN = "\u001B[36m";
        public static final String TEXT_YELLOW = "\u001B[33m";
        public static final String TEXT_WHITE = "\u001B[37m";

        public static void main(String[] args) {
                String[] toyName = new String[] { "bear", "yula", "ball", "car", "doll", "boardGame", "gun", "bike",
                                "monopoly", "bunny"};
                int arraysize = 10;
                String action;
                ArrayList<Toy> toys = new ArrayList<Toy>();
                int[] toyWeight = new int[] { 2, 2, 1, 3, 1, 1, 2, 8, 1, 1};
                int basketWeight = 0;
                for (int i = 0; i <= arraysize - 1; i++) {
                        toys.add(new Toy(toyName[i], toyWeight[i]));
                        basketWeight = basketWeight + toyWeight[i];

                }
                Basket basket = new Basket(basketWeight);
                boolean emptyBasket = true;
                Scanner iScanner = new Scanner(System.in);

                while (emptyBasket) {
                        basketWeight = 0;
                        for (int i = 0; i < toys.size(); i++) {
                                basketWeight = basketWeight + toyWeight[i];
                        }
                        System.out.println();
                        System.out.printf("В корзине игрушек %d шт", toys.size());
                        System.out.println();
                        System.out.printf("Они весят %d кг", basketWeight);
                        System.out.println();
                        System.out.println();

                        System.out.println(TEXT_YELLOW + "Выберите действие");
                        System.out.println("1-Просмотр корзины с призами");
                        System.out.println("2-Добавление приза в корзину");
                        System.out.println("3-Проведение розыгрыша приза");
                        System.out.println("4-Выход" + TEXT_RESET);
                        System.out.printf("Введите номер действия: ");
                        // boolean flag = iScanner.hasNext();
                        action = iScanner.next();
                        int actionInt = Integer.parseInt(action);

                        if (actionInt == 1) {
                                System.out.println("Просмотр корзины с призами");
                                for (int i = 0; i < toys.size(); i++) {
                                        System.out.printf("%d ", i + 1);
                                        System.out.println(toys.get(i));
                                }

                        } else if (actionInt == 2) {
                                System.out.println("Добавление приза в корзину");
                                if (toys.size() < 10) {
                                        System.out.printf("Внимание. В корзине не должно быть более %d игрушек",
                                                        arraysize);
                                        System.out.println();
                                        System.out.printf("Сейчас в корзине прзов %d шт", toys.size());
                                        System.out.println();
                                        iScanner.nextLine();
                                        System.out.println("Введите название игрушки: ");
                                        String toyAdd = iScanner.nextLine();
                                        System.out.printf("Введите вес игрушки: ");
                                        int weightAdd = iScanner.nextInt();
                                        toys.add(new Toy(toyAdd, weightAdd));
                                } else {
                                        System.out.printf(TEXT_RED
                                                        + "Внимание. В корзине не должно быть более %d игрушек",
                                                        arraysize);
                                        System.out.println();
                                        System.out.printf("Сейчас в корзине игрушек %d шт", arraysize);
                                        System.out.println();
                                        System.out.println("Пока вы не можете добавить призы" + TEXT_RESET);
                                }

                        } else if (actionInt == 3) {
                                System.out.println("Проведение розыгрыша приза");
                                int prizeNumber = 0;
                                System.out.printf("Введите цифру от 1 до %d: ", toys.size());
                                if (iScanner.hasNextInt()) {
                                        prizeNumber = iScanner.nextInt();
                                }
                                System.out.println();
                                // System.out.println(TEXT_BLUE + "This text is red!" + TEXT_RESET);
                                System.out.printf(TEXT_GREEN + "Поздравляем! Ваш приз - ");
                                System.out.println(toys.get(prizeNumber - 1) + TEXT_RESET);
                                toys.remove(prizeNumber - 1);

                        } else if (actionInt == 4) {
                                System.out.println("Выход");
                                System.exit(0);

                        } else {
                                System.out.printf("Вы ввели неправильный номер действия: ");
                                System.exit(0);
                        }
                        emptyBasket = basket.isEmpty();
                }
                iScanner.close();
        }
}