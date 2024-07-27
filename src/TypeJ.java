import java.util.HashMap;
import java.util.Map;

public class TypeJ {
    String opCode;
    String immediate;
    String[] instruction;
    Map<String, String> typeJ;
    Tools tools;

   public TypeJ(){
       opCode=" ";
       immediate=" ";
       instruction=null;
       typeJ = new HashMap<>();
       tools=new Tools();
       setOpCodeOperatorBinary();
   }

    public boolean isTypeJ(String mnemonic){
        return typeJ.containsKey(mnemonic);
    }

    private void setOpCodeOperatorBinary(){
        typeJ.put("j","000010");
        typeJ.put("jal","000011");
   }

   public void setInstruction(String[] instruction){
       this.instruction=instruction;
       opCode = getOpCode(instruction[0]);
       immediate = getImmediate();
   }
   public String getImmediate(){
       return tools.DecimalToBinary(instruction[1],26);
   }
    public String getOpCode(String opCode){return typeJ.getOrDefault(opCode, null);}

    public String getBinaryInstruction(){return (opCode+" "+immediate);}

}
