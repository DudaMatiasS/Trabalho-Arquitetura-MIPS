import java.util.ArrayList;

public class Calculations {
    ListaDE instructionList;
    Tools tool = new Tools();
    Configuration config;
    int cacheMiss;
    int cacheHit;
    ArrayList<Integer> acessedBlocks;

    public Calculations() {
        acessedBlocks = new ArrayList<>();
        cacheMiss = 0;
        cacheMiss = 0;
    }

    public void setConfig(Configuration config) {
        this.config = config;

    }

    public void setCacheMapping(String path) {
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
        System.out.println();
        direct();
        // if (path.equals("TESTE-01.txt") || path.equals("TESTE-02.txt")) {

        // } else if (path.equals("TESTE-03.txt") || path.equals("TESTE-04.txt")) {

        // } else if (path.equals("TESTE-05.txt") || path.equals("TESTE-06.txt") ||
        // path.equals("TESTE-07.txt")) {

        // } else if (path.equals("TESTE-08.txt") || path.equals("TESTE-09.txt") ||
        // path.equals("TESTE-10.txt")) {

        // }

    }

    private void direct() {

        System.out.println("Linha 1 resposta: " + getblockSizeBits());
        System.out.println("Linha 2 resposta: " + getNumberSetsBits());
        System.out.println("Linha 3 resposta: " + getTAGBits());
        firstStep();
        System.out.println("Blocos Acessados!!:");
        for (Integer i : acessedBlocks) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Linha 4 resposta: " + cacheMiss);
        System.out.println("Linha 5 resposta: " + cacheHit);

    }

    private void associative() {

    }

    private void conjAssociative() {

    }

    private void firstStep() {
        int result = 0;
        System.out.print("Endereços: ");
        for (Integer i : config.getAddress()) {
            result = i / getblockSize();

            blocks(result);

        }
        System.out.println();
    }

    private int getTAGBits() {
        return (tool.findExponent(config.getMemorySize()) - (getblockSizeBits() + getNumberSetsBits()));
    }

    private int getblockSizeBits() {

        return tool.findExponent(getblockSize());
    }

    private int getNumberSetsBits() {

        return tool.findExponent(config.getLines() / config.getVias());

    }

    private int getblockSize() {
        return config.getWordsLine() * 4;
    }

    private void blocks(int block) {
        if (acessedBlocks.contains(block)) {
            cacheHit++;
        } else {
            cacheMiss++;
            acessedBlocks.add(block);
        }
    }
}