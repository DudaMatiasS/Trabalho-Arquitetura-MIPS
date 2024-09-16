import java.util.ArrayList;

public class Tools {
   ArrayList<Mnemonic> allMnemonics;

   public Tools() {
      setMnemonicList();
   }

   private void setMnemonicList() {
      allMnemonics = new ArrayList<>();
      Mnemonic mnemonic = new Mnemonic("add", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("addi", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("addiu", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("addu", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("and", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("andi", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("jalr", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lb", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lbu", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lh", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lhu", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lui", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lw", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lwl", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("lwr", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("mfhi", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("mflo", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("nor", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("or", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("ori", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sll", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sllv", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("slt", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("slti", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sltu", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sra", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("srav", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("srl", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("srlv", "d", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("stliu", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sub", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("subu", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("xor", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("xori", "d", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sw", "s", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sb", "s", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("sh", "s", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("swl", "s", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("swr", "s", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("mthi", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("mtlo", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("mult", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("multu", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("div", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("divu", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("jr", "s", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("bltz", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("bgez", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("bltzal", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("bgezal", "s", false);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("j", "s", true);
      allMnemonics.add(mnemonic);
      mnemonic = new Mnemonic("jal", "s", true);
      allMnemonics.add(mnemonic);
   }

   public boolean isR1ForDestination(String func) {
      for (Mnemonic m : allMnemonics) {
         if (m.getName().equals(func.toLowerCase()) && m.getR1Type() == "d") {
            return true;
         }
      }
      return false;
   }

   public boolean isJump(String func) {
      return func.equals("j") || func.equals("jal");
   }

   public boolean instIsTypeR(String func) {
      TypeR t = new TypeR();
      return t.isTypeR(func);
   }

   public boolean isForwardingMem(String func) {
      for (Mnemonic m : allMnemonics) {
         if (m.getName().equals(func.toLowerCase()) && m.isForwardingMem()) {
            return true;
         }
      }
      return false;
   }

}
