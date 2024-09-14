import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ReadAndWriteTxt {
    Calculations calc;
   ListaDE instructionList;
    public void txtReader(String filePath){
        instructionList = new ListaDE();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line =reader.readLine()) != null) {
                if(!line.isEmpty()){
                    lineBreak(line.trim().toLowerCase());
                }
            }
            reader.close();
            calc = new Calculations();
            calc.setInstructionList(instructionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lineBreak(String line){
        String cleanLine = line.replace("(", " ").replace(")", " ").replace(",", "");
        Instruction instruction;
        StringTokenizer caracter = new StringTokenizer(cleanLine, " \t\n");
        int tokenCount = caracter.countTokens();
        String[] caracterArr = new String[tokenCount];
        for (int i = 0; i < tokenCount; i++) {
            caracterArr[i] = caracter.nextToken();
        }

       if(tokenCount==3){
            instruction = new Instruction(caracterArr[0],caracterArr[1],caracterArr[2],"");
        }else if(tokenCount==4){
            instruction = new Instruction(caracterArr[0],caracterArr[1],caracterArr[2],caracterArr[3]);
        }else{
           instruction = new Instruction(caracterArr[0], caracterArr[1],"","");
       }
        instructionList.insert(instruction);

    }
    private void txtWriter(String line) {
        if(line == null){
            line = "Infelizmente não foi escrito. Verifique se há alguma instrução nessa linha! :(";
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\assets\\programOut.txt", true))) { // Modo de anexar (append)
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void txtClear(){
        try {
            FileWriter fileWriter = new FileWriter("src\\assets\\programOut.txt");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
