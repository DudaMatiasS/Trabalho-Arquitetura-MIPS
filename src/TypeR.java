import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TypeR {
    ArrayList<String> typeR;
   public TypeR(){
       typeR = new ArrayList<>();
       setFunctOperatorBinary();
   }

    public boolean isTypeR(String mnemonic){
         for(String aux:typeR){
             if(aux.equals(mnemonic)){
                 return true;
             }
         }
         return false;
    }

    private void setFunctOperatorBinary(){
        typeR.add("add");
        typeR.add("addu");
        typeR.add("sub");
        typeR.add("subu");
        typeR.add("and");
        typeR.add("or");
        typeR.add("xor");
        typeR.add("nor");
        typeR.add("slt");
        typeR.add("sltu");
        typeR.add("sll");
        typeR.add("srl");
        typeR.add("sra");
        typeR.add("sllv");
        typeR.add("srlv");
        typeR.add("srav");
        typeR.add("mfhi");
        typeR.add("mthi");
        typeR.add("mflo");
        typeR.add("mtlo");
        typeR.add("mult");
        typeR.add("multu");
        typeR.add("div");
        typeR.add("divu");
        typeR.add("jr");
        typeR.add("jalr");
    }


}
