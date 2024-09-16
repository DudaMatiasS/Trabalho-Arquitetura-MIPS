import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Registers {

    ArrayList<String> registers;
    public Registers(){
        registers= new ArrayList<>();
        setRegisters();

    }
    private void setRegisters(){
        registers.add("$zero");
        registers.add("$r0");
        registers.add("$at");
        registers.add("$v0");
        registers.add("$v1");
        registers.add("$a0");
        registers.add("$a1");
        registers.add("$a2");
        registers.add("$a3");
        registers.add("$t0");
        registers.add("$t1");
        registers.add("$t2");
        registers.add("$t3");
        registers.add("$t4");
        registers.add("$t5");
        registers.add("$t6");
        registers.add("$t7");
        registers.add("$s0");
        registers.add("$s1");
        registers.add("$s2");
        registers.add("$s3");
        registers.add("$s4");
        registers.add("$s5");
        registers.add("$s6");
        registers.add("$s7");
        registers.add("$t8");
        registers.add("$t9");
        registers.add("$k0");
        registers.add("$k1");
        registers.add("$gp");
        registers.add("$sp");
        registers.add("$s8");
        registers.add("$fp");
        registers.add("$ra");
    }
    public String getRegister(String r){
        for(String rg:registers){
            if(rg.equals("$"+r)){
                return rg;
            }
        }
        return r;
    }
}
