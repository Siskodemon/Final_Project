package module;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import View.View_console;

public class FileOperation implements Operation{

    private String fileName="";

    public FileOperation(){
        System.out.println("Инициализация работы с фалом записок.......Готово!!!");;
    }
    public FileOperation(String fileName){
        this.fileName = fileName;
    }

    public String Get_filename(){
        return this.fileName;
    }

    public void Create_File() {
        try (FileWriter writer = new FileWriter(String.join(".",this.fileName,"txt"), true)) {
            writer.write("Пока записей нет...");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<String> readAllLines() {
        return null;
    }

    @Override
    public void saveAllLines(List<String> lines) {

    }
}
