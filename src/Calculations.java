import java.io.BufferedWriter;
import java.lang.classfile.BufWriter;
import java.util.ArrayList;

public class Calculations {
    ListaDE instructionList;
    Tools tool = new Tools();
    Configuration config;
    int cacheMiss;
    int cacheHit;
    ArrayList<Integer> acessedBlocks;
    String answer;

    public Calculations() {
        acessedBlocks = new ArrayList<>();
        cacheMiss = 0;
        cacheMiss = 0;
        answer = "";
    }

    public void setConfig(Configuration config) {
        this.config = config;
        setCacheMapping();
    }

    public void setCacheMapping() {
        System.out.println("Tamanho da mémoria RAM: " + config.getMemorySize());
        System.out.println("Quantidade de palavras na linha: " +
                config.getWordsLine());
        System.out.println("Quantidade de linhas: " + config.getLines());
        System.out.println("Número de vias(quantidade de linhas em um conjunto): " +
                config.getVias());
        System.out.print("Endereços: ");
        for (Integer i : config.getAddress()) {

            System.out.print(i + " ");
        }
        if (config.getVias() == 1) {
            direct();
        } else if (config.getVias() == config.getLines()) {
            associative();

        } else if (config.getVias() != config.getLines() && config.getVias() != 1) {
            conjAssociative();
        }else{
            answer="ALGO DE ERRADO NAO ESTA CERTO!"
        }
        System.out.println("Blocos Acessados!!:");
        for (Integer i : acessedBlocks) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    // mapeamento direto
    private void direct() {
        System.out.println("Linha 1 resposta: " + getblockSizeBits());
        System.out.println("Linha 2 resposta: " + getNumberSetsBits());
        System.out.println("Linha 3 resposta: " + getTAGBits(tool.findExponent(config.getLines())));
        findBlockNumber();
        System.out.println("Linha 4 resposta: " + cacheMiss);
        System.out.println("Linha 5 resposta: " + cacheHit);
        answer=getblockSize()+" "+getNumberSetsBits()+" "+getTAGBits(tool.findExponent(config.getLines()))+" "+cacheMiss+" "+cacheHit
    }

    // mapeamento completamente associativo
    private void associative() {
        System.out.println("Linha 1 resposta: " + getblockSizeBits());
        System.out.println("Linha 2 resposta: " + getNumberSetsBits());
        System.out.println("Linha 3 resposta: " + getTAGBits(0));
        findBlockNumber();
        System.out.println("Linha 4 resposta: " + cacheMiss);
        System.out.println("Linha 5 resposta: " + cacheHit);
        answer=getblockSize()+" "+getNumberSetsBits()+" "+getTAGBits(0)+" "+cacheMiss+" "+cacheHit
    }

    // mapeamento associativo por conjunto
    private void conjAssociative() {
        System.out.println("Linha 1 resposta: " + getblockSizeBits());
        System.out.println("Linha 2 resposta: " + getNumberSetsBits());
        System.out.println("Linha 3 resposta: " + getTAGBits(tool.findExponent(getNumberSetsBits())));
        findBlockNumber();
        System.out.println("Linha 4 resposta: " + cacheMiss);
        System.out.println("Linha 5 resposta: " + cacheHit);

        answer=getblockSize()+" "+getNumberSetsBits()+" "+getTAGBits(tool.findExponent(getNumberSetsBits()))+" "+cacheMiss+" "+cacheHit
    }

    private void findBlockNumber() {
        int result = 0;
        System.out.print("Endereços: ");
        // i é os endereços
        for (Integer i : config.getAddress()) {
            // i/tamanho do bloco ai armazena o número do bloco
            result = i / getblockSize();
            // manda para a funçao blocks o número do bloco
            blocks(result);
        }
        System.out.println();
    }

    // pega os bits da tag
    private int getTAGBits(int num) {
        return (tool.findExponent(config.getMemorySize()) - (num + getblockSize()));
    }

    // pegar o número de bits referente ao tamanho do bloco
    private int getblockSizeBits() {
        return tool.findExponent(getblockSize());
    }

    // achar o número de bits do conjuntos
    private int getNumberSetsBits() {
        return tool.findExponent(config.getLines() / config.getVias());
    }

    // achar o tamanho da linha/bloco
    private int getblockSize() {
        return config.getWordsLine() * 4;
    }

    private void blocks(int block) {
        // verifica se o número do bloco ja contem na lista de blocos acessados, se
        // contem é um cache hit se nao é um cache miss e adiciona no arraylist o número
        // do bloco acessado!!!
        if (acessedBlocks.contains(block)) {
            cacheHit++;
        } else {
            acessedBlocks.add(block);
            cacheMiss++;
        }
    }

    public void write(BufferedWriter writer) {
        String[] aux = answer.split(" ");
        for (String i : aux) {
            writer.write(i);
            writer.newLine();
            writer.write();
        }
    }
}