import java.util.ArrayList;

public class Configuration {
    int memorySize;
    int wordsLine;
    int lines;
    int vias;
    ArrayList<Integer> address;

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getWordsLine() {
        return wordsLine;
    }

    public void setWordsLine(int wordsLine) {
        this.wordsLine = wordsLine;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getVias() {
        return vias;
    }

    public void setVias(int vias) {
        this.vias = vias;
    }

    public ArrayList<Integer> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Integer> address) {
        this.address = address;
    }

}