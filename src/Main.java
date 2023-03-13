import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import View.View_console;
import module.Create_File;
import module.Insert_note;
import module.Read_File;


public class Main {
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(Main.class.getName());
        FileHandler ch = new FileHandler("Log.txt");
        log.addHandler(ch);
        SimpleFormatter sformat = new SimpleFormatter();
        ch.setFormatter(sformat);
        log.info("Работа программы...");
        View_console i_f = new View_console();
        Scanner input = new Scanner(System.in);
        Read_File read_file_Operation = new Read_File();
        Create_File create_file_operetion = new Create_File();
        Insert_note insert_note = new Insert_note();
        Integer index = 0;
        while (index != 7) {
             index = i_f.Interaction(input);
            switch (index) {
                case (1):
                    String name = i_f.Input_file_name(input);
                    create_file_operetion.Create_New_File(name);
                    read_file_Operation.Set_File(name);
                    System.out.println("==============================================");
                    System.out.printf("Файл с записками %s.txt был успешно создан и выбран для работы.\n", create_file_operetion.Get_filename());
                    System.out.println("Для смены рабочего файла выберите 6-ой пункт");
                    break;
                case (2):
                    if (read_file_Operation.Cheack_File_Name() != null) {
                        read_file_Operation.Cheack_File(read_file_Operation.Get_filename(),"on",0,"off");
                    }
                    break;
                case (3):
                    insert_note.Insert_new_note(read_file_Operation.Cheack_File(read_file_Operation.Get_filename(),"",0,"off"), read_file_Operation.Get_filename(),i_f.Input_new_note());
                    break;
                case (4):
                    if (read_file_Operation.Cheack_File_Name() != null) {
                        read_file_Operation.Cheack_File(read_file_Operation.Get_filename(),"on", i_f.Search_note(),"off");
                    }
                    break;
                case (5):
                    if (read_file_Operation.Cheack_File_Name() != null) {
                        read_file_Operation.Cheack_File(read_file_Operation.Get_filename(),"on", i_f.Search_note(),"on");
                    }
                    break;
                case (6):
                    read_file_Operation.Set_File( i_f.Input_file_name(input));
                    break;
                case (7):
                    index = 7;
                    break;
                default:
                    index = 0;
            }
        }
     //   FileOperation fileOperation = new FileOperation(i_f.Input_file_name());


        }

}


