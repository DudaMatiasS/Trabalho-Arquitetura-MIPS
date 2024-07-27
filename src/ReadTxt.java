import java.io.BufferedReader;
import java.io.FileReader;
public class ReadTxt {
    public void txtReader(String filePath){
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line =leitor.readLine()) != null) {
                lineBreak(line.trim());
            }
            leitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lineBreak(String line){

        String [] caracter = line.replace("(", " ").replace(")"," ").replace(",", "").split(" ");


        Instructions instructions = new Instructions(caracter);
        System.out.println(line+": "+instructions.getInstruction());

    }


}
