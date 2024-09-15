public class Calculations {
    ListaDE instructionList;
    Tools tool =new Tools();;
    public void setInstructionList(ListaDE instructionList) {
        this.instructionList = instructionList;

    }
    public void setWhicConflict(String path){
        if(path.contains("1")||path.contains("2")){
            bubble();

        } else if (path.contains("3")||path.contains("4")) {
            forwarding();
        }else{
           reorderWithBubble();
        }


    }

    private void bubble(){
        Instruction i = instructionList.getFirst();
        while(i!=null){
            if(!i.getFunc().equals("NOP")) {// se for NOP vai ignorar
                if(!tool.isJump(i.getFunc())) {// se for JUMP vai ignorar
                    if (tool.isR1ForDestination(i.getFunc())) { // r1 é de destino (irá gravar algo?)
                        //E SE O REGISTRADOR FOR UM NÚMERO!!!! -> r1 nunca será um número so se a instr for jump
                        //VERIFICAR VALIDA'COES E SE NAO TIVER R3 OU R2? -> validaçao é um OR
                        if (i.getNext() != null && (i.getNext().getR1().equals(i.getR1()) || i.getNext().getR2().equals(i.getR1()) || i.getNext().getR3().equals(i.getR1()))) {// 1 e 2 inst
                            if (i.getFunc().equals("lw") || tool.instIsTypeR(i.getFunc())) {
                                instructionList.addNOP(i);
                                instructionList.addNOP(i);
                            } else {
                                instructionList.addNOP(i);
                            }
                        }else if (i.getNext() != null && i.getNext().getNext() != null && (i.getNext().getNext().getR1().equals(i.getR1()) || i.getNext().getNext().getR2().equals(i.getR1()) || i.getNext().getNext().getR3().equals(i.getR1()))) {//1 e 3 inst
                            if (i.getFunc().equals("lw") || tool.instIsTypeR(i.getFunc())) {
                                instructionList.addNOP(i.getNext());
                            }
                        }
                    }
                }
            }
            i=i.getNext();
        }
    }
    public void forwarding(){
        Instruction i = instructionList.getFirst();
        while(i!=null){
            if(!i.getFunc().equals("NOP")) {
                if(!tool.isJump(i.getFunc())) {
                    if (tool.isR1ForDestination(i.getFunc())) {
                        if (i.getNext() != null && (i.getNext().getR1().equals(i.getR1()) || i.getNext().getR2().equals(i.getR1()) || i.getNext().getR3().equals(i.getR1()))) {// 1 e 2 inst
                            if (tool.isForwardingMem(i.getFunc())) {
                                instructionList.addNOP(i);
                            }
                        }
                    }
                }
            }
            i=i.getNext();
        }
    }

    private void reorderWithBubble(){
        //colocar while em uma funçao e chamar ela
        //o while tem que avaliar a de conflito com a 1 e 2 inst e ir caminhando
        //fazer um contador de nops

        bubble();
        Instruction iConflict = instructionList.getFirst();
        while(!iConflict.getNext().getFunc().equals("NOP")){
            iConflict=iConflict.getNext();
        }
        Instruction i = instructionList.getFirst();
       boolean conflicts=true;
        while (conflicts || i!=null){
            if(!i.getInstruction().equals(iConflict.getInstruction())) {
                if (!i.getFunc().equals("NOP")) {// se for NOP vai ignorar
                    //if (!tool.isJump(i.getFunc())) {// se for JUMP vai ignorar
                        if (tool.isR1ForDestination(i.getFunc())) { // r1 é de destino (irá gravar algo?)
                            //E SE O REGISTRADOR FOR UM NÚMERO!!!! -> r1 nunca será um número so se a instr for jump
                            //VERIFICAR VALIDA'COES E SE NAO TIVER R3 OU R2? -> validaçao é um OR
                            if (i.getNext() != null && ((!i.getNext().getR1().equals(iConflict.getR1()) || !i.getNext().getR2().equals(iConflict.getR1()) || !i.getNext().getR3().equals(iConflict.getR1())))) {// 1 e 2 inst
                                conflicts = false;
                                instructionList.swap(iConflict,i);
                                instructionList.removeOneNOP();
                                System.out.println("REMOVENDO NOP");
                            }
                        }
                    //}
                }
            }
           i=i.getNext();
      }


    }

    private void reorderWithForwarding(){
        forwarding();
//        instructionList.print();
//        Instruction i = instructionList.getFirst();
//
//        while(!i.getFunc().equals("NOP")){
//            i=i.getNext();
//        }


    }

}