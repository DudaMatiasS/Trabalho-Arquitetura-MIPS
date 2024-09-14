public class Calculations {
    ListaDE instructionList;
    Tools tool;
    public void setInstructionList(ListaDE instructionList) {
        this.instructionList = instructionList;
        tool=new Tools();
        bubble();
        instructionList.print();
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
                        } else if (i.getNext() != null && i.getNext().getNext() != null && (i.getNext().getNext().getR1().equals(i.getR1()) || i.getNext().getNext().getR2().equals(i.getR1()) || i.getNext().getNext().getR3().equals(i.getR1()))) {//1 e 3 inst
                            if (i.getFunc().equals("lw") || tool.instIsTypeR(i.getFunc())) {
                                instructionList.addNOP(i.getNext());
                            }
                        }
                    } else {
                        //acredito que s com s nunca irá dar conflito e s com d tb nao dará
                        //O QUE FAZER?
                        //devo analisar seu a prox inst é tipo d ou s, se for s nao adciona nada, mas se for d pode dar algum b.o!!!
                    }
                }
            }
            i=i.getNext();
        }

    }
}