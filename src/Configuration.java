import java.util.ArrayList;

public class Configuration {
    long memorySize;
    long wordsLine;
    long lines;
    long vias;
    ArrayList<Integer> address;

    public long getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(long memorySize) {
        this.memorySize = memorySize;
    }

    public long getWordsLine() {
        return wordsLine;
    }

    public void setWordsLine(long wordsLine) {
        this.wordsLine = wordsLine;
    }

    public long getLines() {
        return lines;
    }

    public void setLines(long lines) {
        this.lines = lines;
    }

    public long getVias() {
        return vias;
    }

    public void setVias(long vias) {
        this.vias = vias;
    }

    public ArrayList<Integer> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Integer> address) {
        this.address = address;
    }

}