import java.util.HashMap;
import java.util.Map;

public class TypeI {
    String opCode;
    String immediate;
    String rs;
    String rt;
    Registers registers;
    String[] instruction;
    Map<String, String> typeI;
    Tools tools;

   public TypeI(){
       opCode=" ";
       immediate=" ";
       instruction=null;
       typeI = new HashMap<>();
       tools=new Tools();
       registers = new Registers();
       setOpCodeOperatorBinary();
   }

    public boolean isTypeI(String mnemonic){
        return typeI.containsKey(mnemonic);
    }

    private void setOpCodeOperatorBinary(){
        typeI.put("addi", "001000");
        typeI.put("addiu", "001001");
        typeI.put("slti", "001010");
        typeI.put("sltiu", "001011");
        typeI.put("andi", "001100");
        typeI.put("ori", "001101");
        typeI.put("xori", "001110");
        typeI.put("lui", "001111");
        typeI.put("beq", "000100");
        typeI.put("bne", "000101");
        typeI.put("blez", "000110");
        typeI.put("bgtz", "000111");
        typeI.put("bltz", "000001");
        typeI.put("bgez", "000001");
        typeI.put("bltzal", "000001");
        typeI.put("bgezal", "000001");
        typeI.put("lb", "100000");
        typeI.put("lh", "100001");
        typeI.put("lwl", "100010");
        typeI.put("lw", "100011");
        typeI.put("lbu", "100100");
        typeI.put("lhu", "100101");
        typeI.put("lwr", "100110");
        typeI.put("sb", "101000");
        typeI.put("sh", "101001");
        typeI.put("swl", "101010");
        typeI.put("sw", "101011");
        typeI.put("swr", "101110");
   }

   public void setInstruction(String[] instruction){
       this.instruction=instruction;
       opCode = getOpCode(instruction[0]);
       setRegisters();
       immediate = getImmediate();
   }
   private void setImmediate(String immediate){this.immediate = tools.DecimalToBinary(immediate,16);}

   private void setRegisters(){
       if(instruction[0].equals("addi")||instruction[0].equals("addiu")||instruction[0].equals("slti")||instruction[0].equals("sltiu")||instruction[0].equals("andi")||instruction[0].equals("ori")||instruction[0].equals("xori")||instruction[0].equals("lui")||instruction[0].equals("beq")||instruction[0].equals("bne")) {
           rs = registers.getRegister(instruction[2]);
           rt = registers.getRegister(instruction[1]);
           setImmediate(instruction[3]);
       } else if (instruction[0].equals("bltz")||instruction[0].equals("bgez")||instruction[0].equals("bltzal")||instruction[0].equals("bgezal")||instruction[0].equals("blez")||instruction[0].equals("bgtz")) {
           rs = registers.getRegister(instruction[1]);
           if(instruction[0].equals("bltz")||instruction[0].equals("blez")||instruction[0].equals("bgtz")){
               rt = registers.getRegister("$zero");
           } else if (instruction[0].equals("bgez")) {
               rt = registers.getRegister("1");
           }else if (instruction[0].equals("bltzal")) {
               rt = registers.getRegister("16");
           }else if (instruction[0].equals("bgezal")) {
               rt = registers.getRegister("17");
           }else{
               rt = "null";
           }
           setImmediate(instruction[2]);
       } else{
           rs= registers.getRegister(instruction[3]);
           rt= registers.getRegister(instruction[1]);
           setImmediate(instruction[2]);
       }

   }
   private String getImmediate() {return immediate;}
    private String getOpCode(String opCode){return typeI.getOrDefault(opCode, null);}

    public String getBinaryInstruction(){return (opCode+rs+rt+immediate);}

}
