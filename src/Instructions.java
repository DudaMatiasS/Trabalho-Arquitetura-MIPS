public class Instructions {
    String[] instruction;
    TypeR typeR;
    TypeJ typeJ;
    TypeI typeI;
    boolean instructionFinished;
    public Instructions(String[] instruction){
        typeR = new TypeR();
        typeJ = new TypeJ();
        typeI = new TypeI();
        instructionFinished=false;
        this.instruction = instruction;
        setInstruction();

    }

    private void setInstruction(){

        if(typeR.isTypeR(instruction[0])){
            typeR.setInstruction(instruction);
        }
        else if (typeI.isTypeI(instruction[0])) {
            typeI.setInstruction(instruction);
        }

        else if (typeJ.isTypeJ(instruction[0])) {
           typeJ.setInstruction(instruction);
        }
    }

    public String getBinaryInstruction() {
        if (typeR.isTypeR(instruction[0])) {
            return typeR.getBinaryInstruction();
        }
        else if (typeI.isTypeI(instruction[0])) {
            return typeI.getBinaryInstruction();
        }
         else if (typeJ.isTypeJ(instruction[0])) {
           return typeJ.getBinaryInstruction();
        }
        return null;
    }

}
