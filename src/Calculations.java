public class Calculations {
    ListaDE instructionList;
    Tools tool = new Tools();
    Configuration config;

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public void setCacheMapping(String path) {
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
        System.out.println("Tamanho da mémoria RAM: " + config.getmemorySize);
        System.out.println(config.getLines());
        System.out.println(config.getLines());
        System.out.println(config.getLines());
    }

    private void associative() {

    }

    private void conjAssociative() {

    }
}