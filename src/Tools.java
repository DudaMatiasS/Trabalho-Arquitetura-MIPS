import java.util.ArrayList;

public class Tools {
    ArrayList<Mnemonic> allMnemonics;
    public Tools(){
        setMnemonicList();
   }
   private void setMnemonicList(){
       allMnemonics = new ArrayList<>();
      Mnemonic mnemonic=new Mnemonic("add", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("addi", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("addiu", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("addu", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("and", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("andi", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("jalr", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lb", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lbu", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lh", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lhu", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lui", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lw", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lwl", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("lwr", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mfhi", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mflo", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("nor", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("or", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("ori", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sll", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sllv", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("slt", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("slti", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sltu", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sra", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("srav", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("srl", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("srlv", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("stliu", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sub", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("subu", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("xor", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("xori", "d");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sw", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sb", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sh", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("swl", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("swr", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mthi", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mtlo", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mult", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("multu", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("div", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("divu", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("jr", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bltz", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bgez", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bltzal", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bgezal", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("j", "s");
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("jal", "s");
      allMnemonics.add(mnemonic);
   }

   public boolean isR1ForDestination(String func){
      for(Mnemonic m:allMnemonics){
         if(m.getName().equals(func.toLowerCase())&&m.getR1Type()=="d"){
            return true;
         }
      }
      return false;
   }
   public boolean isBranch(String func){
      for(Mnemonic m:allMnemonics){
         if(m.getName().startsWith("b")){
            return true;
         }
      }
      return false;
   }
   public boolean isJump(String func){
      for(Mnemonic m:allMnemonics){
         if(m.getName().equals("j")||m.getName().equals("jal")){
            return true;
         }
      }
      return false;
   }
   public boolean instIsTypeR(String func){
       TypeR t= new TypeR();
       return t.isTypeR(func);
   }

}
