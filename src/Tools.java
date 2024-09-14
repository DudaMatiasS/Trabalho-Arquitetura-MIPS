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
      mnemonic=new Mnemonic("sw", "s");//le o r1 e salva seu valor no immediate+r
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sb", "s");//le o r1 e salva seu valor no immediate+r
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("sh", "s");//le o r1 e salva seu valor no immediate+r
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("swl", "s");//le o r1 e salva seu valor no immediate+r
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("swr", "s");//le o r1 e salva seu valor no immediate+r
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mthi", "s");// ele salva o r1 em hi
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mtlo", "s");// salva o r1 em Lo
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("mult", "s");// ele le os valores de r1 e r2 faz a operaçao e salva no HI LO
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("multu", "s");// ele le os valores de r1 e r2 faz a operaçao e salva no HI LO
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("div", "s");// ele le os valores de r1 e r2 faz a operaçao e salva no HI LO
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("divu", "s");// ele le os valores de r1 e r2 faz a operaçao e salva no HI LO
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("jr", "s");// ele le o valor de r1
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bltz", "s");// ele le o valor de r1
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bgez", "s");// ele le o valor de r1
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bltzal", "s");// ele le o valor de r1
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("bgezal", "s");// ele le o valor de r1
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("j", "s");// ele le o valor de r1 que no caso é um número
      allMnemonics.add(mnemonic);
      mnemonic=new Mnemonic("jal", "s");// ele le o valor de r1 que no caso é um número
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
