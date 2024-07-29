import java.io.*;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        ReadAndWriteTxt reader = new ReadAndWriteTxt();
        reader.txtReader(Paths.get("src", "assets", "program.txt").toString());
    }
}
