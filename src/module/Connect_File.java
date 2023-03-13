package module;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Connect_File {

    private String fileName="";

    public void Set_File(String fileName){
        this.fileName = fileName;
    }

    public Connect_File(){

    }

    public String Get_filename(){
        return this.fileName;
    }

    public FileWriter Write_connection_file(String name, boolean append) {
        try {
            System.out.println("------------------------------------------------");
            System.out.printf("Соединение с файлом %s.txt успешно установлено.\n",name);
            return new FileWriter(String.join(".",name,"txt"), append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public FileReader Read_connection_file(String name) {
        try {
            System.out.println("------------------------------------------------");
            System.out.printf("Соединение с файлом %s.txt успешно установлено.\n",name);
            return new FileReader(String.join(".",name,"txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        public String Cheack_File_Name(){
            if(this.fileName == "") {
                System.out.println("==============================================");
                System.out.println("Файл для работы не выбран.");
                System.out.println("Выберите файл для работы с помощью 6-го пункта, либо солздайте новый с помощью ервого пункта");
                return null;
            }
            else {
                System.out.println("==============================================");
                System.out.printf("Работаем с файлом %s.txt :\n", Get_filename());
            }
            return Get_filename();
        }

}
