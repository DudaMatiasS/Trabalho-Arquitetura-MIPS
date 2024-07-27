import java.util.HashMap;
import java.util.Map;

public class TypeR {
    String opCode;
    String shamt;
    String funct;
    String rs;
    String rt;
    String rd;
    String[] instruction;
    Registers registers;
    Map<String, String> typeR;
    Tools tools;

   public TypeR(){
       opCode="000000";
       shamt="00000";
       instruction=null;
       typeR = new HashMap<>();
       registers= new Registers();
       tools=new Tools();
       setFunctOperatorBinary();
   }

    public boolean isTypeR(String mnemonic){
        return typeR.containsKey(mnemonic);
    }

    private void setFunctOperatorBinary(){
        typeR.put("add","100000");
        typeR.put("addu","100001");
        typeR.put("sub","100010");
        typeR.put("subu","100011");
        typeR.put("and","100100");
        typeR.put("or", "100101");
        typeR.put("xor", "100110");
        typeR.put("nor", "100111");
        typeR.put("slt", "101010");
        typeR.put("sltu", "101011");
        typeR.put("sll", "000000");
        typeR.put("srl", "000010");
        typeR.put("sra", "000011");
        typeR.put("sllv", "000100");
        typeR.put("srlv", "000110");
        typeR.put("srav", "000111");
        typeR.put("mfhi", "010000");
        typeR.put("mthi", "010001");
        typeR.put("mflo", "010010");
        typeR.put("mtlo", "010011");
        typeR.put("mult", "011000");
        typeR.put("multu", "011001");
        typeR.put("div", "011010");
        typeR.put("divu", "011011");
        typeR.put("jr", "001000");
        typeR.put("jalr", "001001");
    }

   public void setShamt(String shamt){this.shamt= tools.DecimalToBinary(shamt,5);}

   public void setInstruction(String[] instruction){
       this.instruction=instruction;
       setRegistersTypeR();
       shamt=getShamt();
       funct = getFunction(instruction[0]);
   }

   public void setRegistersTypeR(){
        if(instruction[0].equals("sll")||instruction[0].equals("srl")||instruction[0].equals("sra")) {
            rs = registers.getRegister("$zero");
            rt = registers.getRegister(instruction[2]);
            rd = registers.getRegister(instruction[1]);
            setShamt(instruction[3]);
        } else if(instruction[0].equals("mult")||instruction[0].equals("multu")||instruction[0].equals("div")||instruction[0].equals("divu")) {
            rs = registers.getRegister(instruction[1]);
            rt = registers.getRegister(instruction[2]);
            rd = registers.getRegister("$zero");
        }else if(instruction[0].equals("jalr")){
            rs = registers.getRegister(instruction[2]);
            rt = registers.getRegister("$zero");
            rd = registers.getRegister(instruction[1]);
        }else if(instruction[0].equals("mfhi")||instruction[0].equals("mflo")) {
            rs = registers.getRegister("$zero");
            rt = registers.getRegister("$zero");
            rd = registers.getRegister(instruction[1]);
        }else  if(instruction[0].equals("mthi")||instruction[0].equals("mtlo")||instruction[0].equals("jr")) {
            rs = registers.getRegister(instruction[1]);
            rt = registers.getRegister("$zero");
            rd = registers.getRegister("$zero");
        }else{
            rs = registers.getRegister(instruction[2]);
            rt = registers.getRegister(instruction[3]);
            rd = registers.getRegister(instruction[1]);
        }
   }
    public String getFunction(String function){return typeR.getOrDefault(function, null);}

    public String getShamt(){return shamt;}

    public String getInstruction(){return (opCode+" "+rs+" "+rt+" "+rd+" "+shamt+" "+funct);}

}
