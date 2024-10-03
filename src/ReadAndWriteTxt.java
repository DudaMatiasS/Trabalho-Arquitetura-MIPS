import java.io.*;
import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ReadAndWriteTxt {
    Calculations calc;
    Configuration config;
    ArrayList<Integer> adress;

    public void txtReader(String filePath) {
        adress = new ArrayList<>();
        config = new Configuration();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {

                if (!line.isEmpty()) {
                    lineNum++;
                    lineBreak(line.trim(), lineNum);
                }
            }
            reader.close();
            System.out.println("Número de linha do txt: " + lineNum);

            calc = new Calculations();
            calc.setConfig(config);
            sendFileToCalculations(calc, filePath);
            // writeOutput(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lineBreak(String line, int lineNum) {

        StringTokenizer caracter = new StringTokenizer(line, " ");
        int tokenCount = caracter.countTokens();
        int[] caracterArr = new int[tokenCount];
        for (int i = 0; i < tokenCount; i++) {
            caracterArr[i] = Integer.parseInt(caracter.nextToken());
            if (lineNum == 5) {

                adress.add(caracterArr[i]);
            }
        }
        if (lineNum == 1) {
            config.setMemorySize(caracterArr[0]);
        } else if (lineNum == 2) {
            config.setWordsLine(caracterArr[0]);
        } else if (lineNum == 3) {
            config.setLines(caracterArr[0]);
        } else if (lineNum == 4) {
            config.setVias(caracterArr[0]);
        } else if (lineNum == 5) {
            config.setAddress(adress);
        }

    }

    public void writeOutput(String inputFilePath) {
        try {
            File inputFile = new File(inputFilePath);
            String outputFileName = inputFile.getName().replace(".txt",
                    "-RESULTADO.txt");
            String outputFilePath = inputFile.getParent() + File.separator +
                    outputFileName;

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            calc.write(writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendFileToCalculations(Calculations calc, String path) {
        StringTokenizer t = new StringTokenizer(path, "/\\");
        int tCount = t.countTokens();
        String[] fileArr = new String[tCount];
        for (int i = 0; i < tCount; i++) {
            fileArr[i] = t.nextToken();
        }
        calc.setCacheMapping(fileArr[fileArr.length - 1]);
    }

}
