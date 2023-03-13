package module;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import View.View_console;

public class Read_File extends Connect_File{

    public Read_File() {

    }
    public Integer Cheack_File(String filename,String mod, Integer index,String change) throws IOException {
        BufferedReader br = new BufferedReader(Read_connection_file(filename));
        Integer id=0;
        View_console buff = new View_console();
        String str;
        StringBuffer inputBuffer = new StringBuffer("");
        while((str = (br.readLine())) != null){
            id = Character.getNumericValue(str.charAt(0));
            if((mod == "on" & index == 0)|(mod == "on" & index == id)) {
                System.out.println(str);
                if (change == "on") {
                    str = Change_note(str,buff.What_change());
                    System.out.printf("Строка после изменения - %s\n",str);
                }
            }
            if(change == "on" & str !=""){
                inputBuffer.append(str+"\n");
                System.out.printf("%d inputBuffer - %s",id,inputBuffer.toString());
            }
        }
        br.close();
        if(change == "on"){
            str = inputBuffer.toString();
            System.out.printf("str = %s\n",str);
            FileOutputStream fileOut = new FileOutputStream(String.join(".",filename,"txt"));
            fileOut.write(str.getBytes());
            fileOut.close();
        }
        if (id == 0) return 1;
        else return id+1;
    }

    public String Change_note(String str,Integer index){
        View_console buff = new View_console();
        switch (index) {
            case (1):
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(0, buff.Search_note("ID").charAt(0));
                str = sb.toString();
            break;
            case (2):
                str = str.replace(str.substring(str.indexOf("Заголовок: ")+11,str.indexOf(".",str.indexOf("Заголовок: ")+11)+1),buff.Search_note("Заголовок")+".");
                break;
            case (3):
            str = str.replace(str.substring(str.indexOf("Записка: ")+9),buff.Search_note("Записка")+";");
            break;
            case (4):
                str ="";
                break;
        }
        System.out.printf("Полученная строка - %s\n",str);
        return str;
    }

}
