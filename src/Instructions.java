public class Instructions {
    String[] instruction;
    TypeR typeR;
    public Instructions(String[] instruction){
        typeR = new TypeR();

        this.instruction = instruction;
        setInstruction();

    }
//PRECISA FAZER VALIDAÇAO DO TAMANHO DA INSTRUCTION POIS SE FOR MENOR QUE 4 É NECESSARIO ADICIONAR ZERO AO FINAL DA INSTRUÇAO

    private void setInstruction(){

        if(typeR.isTypeR(instruction[0])){
            typeR.setInstruction(instruction);
        }
//        else if (false/**typeI.isTypeI(instruction[0])**/) {
//            typeI.setInstruction();
//        } else if (false/**typeI.isTypeJ(instruction[0])**/) {
//            typeJ.setInstruction();
//        }
    }
    public String getInstruction(){
        if(typeR.isTypeR(instruction[0])){
            return typeR.getInstruction();
        }
//        else if (false/**typeI.isTypeI(instruction[0])**/) {
//            return typeI.getInstruction();
//        } else if (false/**typeI.isTypeJ(instruction[0])**/) {
//            return typeJ.getInstruction();
//        }
        return null;
    }



}
