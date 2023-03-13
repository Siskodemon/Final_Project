package module;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Insert_note extends Connect_File {

    public Insert_note() {

    }

    public void Insert_new_note(Integer id, String filename, String note) {
        try (FileWriter file = Write_connection_file(filename, true)) {
            Date date = new Date();
            String insert_note = String.format("%d %tc %s;\n",id,date,note);
            file.append(insert_note);
            file.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}