package View;

import java.awt.image.BufferStrategy;
import java.util.Scanner;

public class View_console implements User_interaction {
    public View_console(){
        }
        public String Input_file_name(Scanner input){
            System.out.println("==============================================");
            System.out.print("Введите название создаваемого/редактируемого файла с записками: ");
            return input.next();
        }


    @Override
    public Integer Interaction(Scanner input) {
        System.out.println("==============================================");
        System.out.println("Выберите одно из следующих действий:");
        System.out.println("1. Создать файл.");
        System.out.println("2. Просмотреть записки.");
        System.out.println("3. Добавить записку.");
        System.out.println("4. Найти записку.");
        System.out.println("5. Редактировать/Удалить записку.");
        System.out.println("6. Указать файл с записками.");
        System.out.println("7. Завершить работу с записками.");
        return input.nextInt();
    }
    public String Input_new_note(){
        System.out.println("==============================================");
        System.out.println("Введите заголовок записки:");
        Scanner input = new Scanner(System.in);
        String note = "Заголовок: " + input.nextLine() + ".";
        System.out.println("----------------------------------------------");
        System.out.println("Введите содержание записки:");
        note = note + " Записка: " + input.nextLine();
        return note;
    }

    public Integer Search_note(){
        System.out.println("==============================================");
        System.out.println("Введите id записки: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String Search_note(String change){
        System.out.println("----------------------------------------------");
        System.out.printf("Введите новый(ую) %s: ",change);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public Integer What_change(){
        System.out.println("----------------------------------------------");
        System.out.println("Что редактируем? ");
        System.out.println("1. ID;");
        System.out.println("2. Заголовок записки;");
        System.out.println("3. Содержание записки;");
        System.out.println("4. Удалить записку;");
        Scanner input = new Scanner(System.in);
        return input.nextInt();

    }
}

