import java.io.*;

public class ReadAndWriteTxt {
    public void txtReader(String filePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line =reader.readLine()) != null) {
                lineBreak(line.trim().toLowerCase());
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lineBreak(String line){
        String [] caracter = line.replace("(", " ").replace(")"," ").replace(",", "").split(" ");
        Instructions instructions = new Instructions(caracter);
        txtWriter(line+": "+instructions.getBinaryInstruction());

    }
    public void txtWriter(String line) {
        if(line == null){
            line = "Infelizmente não foi escrito :(";
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Duda\\Desktop\\Arquitetura\\src\\assets\\programaSaida.txt", true))) { // Modo de anexar (append)
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
