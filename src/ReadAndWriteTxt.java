import java.io.*;
import java.nio.file.Paths;

public class ReadAndWriteTxt {

    public void txtReader(String filePath) {
        txtClear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                lineBreak(line.trim().toLowerCase());
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lineBreak(String line) {
        String[] caracter = line.replace("(", " ").replace(")", " ").replace(",", "").split(" ");
        Instructions instructions = new Instructions(caracter);
        txtWriter(instructions.getBinaryInstruction());
    }

    private void txtWriter(String line) {
        if (line == null) {
            line = "Infelizmente não foi escrito. Verifique se há alguma instrução nessa linha! :(";
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get("src", "assets", "programOut.txt").toString(), true))) { // Modo de anexar (append)
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void txtClear() {
        try {
            FileWriter fileWriter = new FileWriter(Paths.get("src", "assets", "programOut.txt").toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
