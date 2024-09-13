public class Instruction {
    String func;
    String r1;
    String r2;
    String r3;

    public Instruction(String func, String r1, String r2, String r3){
        this.func=func;
        this.r1=r1;
        this.r2=r2;
        this.r3=r3;
    }
    public String getFunc() {
        return func;
    }
    public String getR2() {
        return r2;
    }
    public String getR3() {
        return r3;
    }
    public String getR1() {
        return r1;
    }
    public String getInstruction(){
        return func+' '+r1+' '+r2+' '+r3;
    }

}
