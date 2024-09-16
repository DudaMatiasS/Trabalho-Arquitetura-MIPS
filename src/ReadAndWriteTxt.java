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
            calc.setWhicConflict(filePath);
            //TENHO QUE TER CERTEZA QUE ACABOU DE FAZER OS CONFLITOS ANTES DE ESCREVER
            writeOutput(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lineBreak(String line){
        //String cleanLine = line.replace("(", " ").replace(")", " ").replace(",", "");
        Instruction instruction;
        StringTokenizer caracter = new StringTokenizer(line, " \t\n,$()");
        int tokenCount = caracter.countTokens();
        String[] caracterArr = new String[tokenCount];
        for (int i = 0; i < tokenCount; i++) {
            caracterArr[i] = caracter.nextToken();
           // System.out.println(caracterArr[i]);
        }

        if(tokenCount==3){
            instruction = new Instruction(caracterArr[0],caracterArr[1],caracterArr[2],"");
        }else if(tokenCount==4){
            instruction = new Instruction(caracterArr[0],caracterArr[1],caracterArr[2],caracterArr[3]);
        } else if (caracterArr[0].equals("NOP")) {
            instruction = new Instruction("NOP","","","");
        } else{
           instruction = new Instruction(caracterArr[0], caracterArr[1],"","");
        }

        instructionList.insert(instruction);

    }
    public void writeOutput(String inputFilePath) {
        try {
            File inputFile = new File(inputFilePath);
            String outputFileName = inputFile.getName().replace(".txt", "-RESULTADO.txt");
            String outputFilePath = inputFile.getParent() + File.separator + outputFileName;

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            instructionList.write(writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
