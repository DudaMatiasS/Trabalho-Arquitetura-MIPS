import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Calculations {
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
        if (config.getVias() == 1) {
            direct();
        } else if (config.getVias() == config.getLines()) {
            associative();

        } else if (config.getVias() != config.getLines() && config.getVias() != 1) {
            conjAssociative();
        } else {
            answer = "Opa! não direcionou corretamente";
        }

    }

    // mapeamento direto
    private void direct() {
        System.out.println("mapeamento direito");
        findBlockNumber();
        answer = getblockSizeBits() + " " + getNumberSetsBits() + " " + getTAGBits(tool.findExponent(config.getLines()))
                + " " + cacheMiss + " " + cacheHit;
    }

    // mapeamento completamente associativo
    private void associative() {
        System.out.println("mapeamento completamente associativo");
        findBlockNumber();
        answer = getblockSizeBits() + " " + getNumberSetsBits() + " " + getTAGBits(0) + " " + cacheMiss + " "
                + cacheHit;
    }

    // mapeamento associativo por conjunto
    private void conjAssociative() {
        System.out.println("mapeamento associativo por conjunto");
        findBlockNumber();
        answer = getblockSizeBits() + " " + getNumberSetsBits() + " "
                + getTAGBits(getNumberSetsBits())
                + " " + cacheMiss + " " + cacheHit;
    }

    private void findBlockNumber() {
        int result = 0;
        // i é os endereçoss
        for (Integer i : config.getAddress()) {
            // i/tamanho do bloco ai armazena o número do bloco
            result = (int) (i / getblockSize());
            // manda para a funçao blocks o número do bloco
            blocks(result);
        }

    }

    // pega os bits da tag
    private long getTAGBits(long num) {
        return (tool.findExponent(config.getMemorySize()) - (num + getblockSizeBits()));
    }

    // pegar o número de bits referente ao tamanho do bloco
    private long getblockSizeBits() {
        return tool.findExponent(getblockSize());
    }

    // achar o número de bits do conjuntos
    private long getNumberSetsBits() {
        return tool.findExponent(config.getLines() / config.getVias());
    }

    // achar o tamanho da linha/bloco
    private long getblockSize() {
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

    public void write(BufferedWriter writer) throws IOException {
        String[] aux = answer.split(" ");
        for (String i : aux) {
            writer.write(i);
            writer.newLine();
        }
    }
}