public class Mnemonic {
    private String name;
    private String r1Type;
    private boolean isForwardingMem;

    public Mnemonic(String name, String r1Type, boolean isForwardingMem) {
        this.name = name;
        this.r1Type = r1Type;
        this.isForwardingMem =isForwardingMem;
    }

    public String getName() {
        return name;
    }

    public String getR1Type() {
        return r1Type;
    }
    public boolean isForwardingMem() {
        return isForwardingMem;
    }
}
