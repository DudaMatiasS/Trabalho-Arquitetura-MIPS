public class Main {
    public static void main(String[] args) {
        System.out.println("Diretório de trabalho atual: " + System.getProperty("user.dir"));
        ReadAndWriteTxt reader = new ReadAndWriteTxt();
        reader.txtReader("C:\\Users\\Duda\\Desktop\\Arquitetura\\src\\assets\\programa.txt");
    }
}