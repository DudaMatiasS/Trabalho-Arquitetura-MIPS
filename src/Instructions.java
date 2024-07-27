public class Instructions {
    String[] instruction;
    TypeR typeR;
    TypeJ typeJ;
    public Instructions(String[] instruction){
        typeR = new TypeR();
        typeJ = new TypeJ();
        this.instruction = instruction;
        setInstruction();

    }

    private void setInstruction(){

        if(typeR.isTypeR(instruction[0])){
            typeR.setInstruction(instruction);
        }
        //else if (false/**typeI.isTypeI(instruction[0])**/) {
           // typeI.setInstruction();}

        else if (typeJ.isTypeJ(instruction[0])) {
           typeJ.setInstruction(instruction);
        }
    }
    public String getBinaryInstruction(){
        if(typeR.isTypeR(instruction[0])){
            return typeR.getBinaryInstruction();
        }
//        else if (false/**typeI.isTypeI(instruction[0])**/) {
//            return typeI.getInstruction();
         else if (typeJ.isTypeJ(instruction[0])) {
           return typeJ.getBinaryInstruction();
        }
        return null;
    }



}
