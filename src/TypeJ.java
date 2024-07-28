import java.util.HashMap;
import java.util.Map;

public class TypeJ {
    String opCode;
    String address;
    String[] instruction;
    Map<String, String> typeJ;
    Tools tools;

   public TypeJ(){
       opCode=" ";
       address =" ";
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
       address = getAddress();
   }
   private String getAddress(){
       return tools.DecimalToBinary(instruction[1],26);
   }
    private String getOpCode(String opCode){return typeJ.getOrDefault(opCode, null);}

    public String getBinaryInstruction(){return (opCode+ address);}

}
