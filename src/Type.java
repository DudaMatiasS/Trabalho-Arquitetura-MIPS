import java.util.HashMap;
import java.util.Map;
public class Type {
    String opCode;
    String shamt;
    Map<String, String> typeR;
   public Type(){
       opCode="000000";
       shamt=null;
       typeR = new HashMap<>();
       setInstructionTypeR();
   }
    public boolean isTypeR(String mnemonic){
        return typeR.containsKey(mnemonic);
    }
    private void setInstructionTypeR(){
        typeR.put("add","10000");
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
        typeR.put("mfhi", "000000");
        typeR.put("mthi", "000001");
        typeR.put("mflo", "000010");
        typeR.put("mtlo", "000011");
        typeR.put("mult", "011000");
        typeR.put("multu", "011001");
        typeR.put("div", "011010");
        typeR.put("divu", "011011");
        typeR.put("jr", "001000");
        typeR.put("jalr", "001001");

    }

   public String getFunction(String function){
       setShamt(function);
       return typeR.getOrDefault(function, null);
   }
   public String getOpCode(){
       return opCode;
   }
   public void setShamt(String function){
       if(function.equals("sll")||function.equals("srlv")||function.equals("srl")||function.equals("sra")||function.equals("sllv")||function.equals("srav")){
           shamt=null;
       }else{
           shamt="00000";
       }
   }
   public String getShamt(){
       return shamt;
   }

}
