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
            sendFileToCalculations(calc, filePath);
            writeOutput(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lineBreak(String line){
        if(!line.equals("nop")){
            Instruction instruction;
            StringTokenizer caracter = new StringTokenizer(line, " \t\n,$()");
            int tokenCount = caracter.countTokens();
            String[] caracterArr = new String[tokenCount];
            for (int i = 0; i < tokenCount; i++) {
                caracterArr[i] = caracter.nextToken();
            }
            
            if(tokenCount==3){
                instruction = new Instruction(caracterArr[0],caracterArr[1],caracterArr[2],"");
            }else if(tokenCount==4){
                instruction = new Instruction(caracterArr[0],caracterArr[1],caracterArr[2],caracterArr[3]);
            } else{
            instruction = new Instruction(caracterArr[0], caracterArr[1],"","");
            }

            instructionList.insert(instruction);
        }
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
    private void sendFileToCalculations(Calculations calc, String path){
        StringTokenizer t = new StringTokenizer(path,"/");
        int tCount = t.countTokens();
        String[] fileArr = new String[tCount];
        for (int i = 0; i < tCount; i++) {
            fileArr[i] = t.nextToken();
        }
        calc.setWhicConflict(fileArr[fileArr.length-1]);
    }

}
