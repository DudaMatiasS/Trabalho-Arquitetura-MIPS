public class Main {
    public static void main(String[] args) {
        System.out.println("Diretório de trabalho atual: " + System.getProperty("user.dir"));
        ReadTxt reader = new ReadTxt();
        reader.txtReader("C:\\Users\\Duda\\Desktop\\Arquitetura\\src\\programa.txt");
    }
}