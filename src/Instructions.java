public class Instructions {
    String[] instruction;
    String opcode;
    String shamt;
    String funct;
    String allRegisters;
    String immediate;
   Registers registers;

    TypeR typeR;
    public Instructions(String[] instruction){
        typeR = new TypeR();
        registers= new Registers();
        this.instruction = instruction;
        if(typeR.isTypeR(instruction[0])){
            setInstructionTypeR();
        }
//        else if (false/**typeI.isTypeI(instruction[0])**/) {
//            setInstructionTypeI();
//        } else if (false/**typeI.isTypeJ(instruction[0])**/) {
//            setInstructionTypeJ();
//        }

    }
//PRECISA FAZER VALIDAÇAO DO TAMANHO DA INSTRUCTION POIS SE FOR MENOR QUE 4 É NECESSARIO ADICIONAR ZERO AO FINAL DA INSTRUÇAO
    public void setInstructionTypeR(){
        opcode= typeR.getOpCode();
        funct = typeR.getFunction(instruction[0]);
        shamt= typeR.getShamt();

//        for (int i=0; i<=instruction.length;i++) {
//            if (instruction[i].startsWith("$")) {
//                System.out.println(instruction[i]);
//                allRegisters += registers.getRegister(instruction[i])+" ";
//            }else{
//                immediate = instruction[i];
//            }
//        }
        System.out.println(instruction.length);

    }
    public void setInstructionTypeI(){

    }
    public void setInstructionTypeJ(){

    }
}
