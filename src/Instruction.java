public class Instruction {
    private String func;
    private String r1;
    private String r2;
    private String r3;
    Instruction prev;
    Instruction next;
    Registers register;
    public Instruction(String func, String r1, String r2, String r3){
        register = new Registers();
        this.func=func;
        this.r1=register.getRegister(r1);
        this.r2=register.getRegister(r2);
        this.r3=register.getRegister(r3);
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
        if(!r2.startsWith("$")&&r3.startsWith("$")){
            return func+" "+r1+", "+r2+"("+r3+")";

        }else if(func.equals("NOP")){
            return func;
        }else{
            if(r2.equals("")){
                return func+" "+r1;
            }else if(r3.equals("")){
                return func+" "+r1+", "+r2;
            }else{
                return func+" "+r1+", "+r2+", "+r3;
            }
        }
        
    }

    public Instruction getPrev() {
        return prev;
    }

    public Instruction getNext() {
        return next;
    }

    public void setPrev(Instruction prev) {
        this.prev = prev;
    }

    public void setNext(Instruction next) {
        this.next = next;
    }
}
