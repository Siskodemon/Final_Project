package module;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Create_File extends Connect_File{


    public void Create_New_File(String filename) {
        Set_File(filename);
        try(FileWriter file = Write_connection_file(filename, false)){
            file.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Create_File(){

    }

}
