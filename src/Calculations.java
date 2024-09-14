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
            if(!i.getFunc().equals("NOP")) {
                if (tool.isR1ForDestination(i.getFunc())) {
                    //VERIFICAR VALIDA'COES E SE NAO TIVER R3 OU R2?
                    if (i.getNext().getR1().equals(i.getR1()) ||i.getNext().getR2().equals(i.getR1())||i.getNext().getR3().equals(i.getR1())) {
                        if (i.getFunc().equals("lw") || tool.instIsTypeR(i.getFunc())) {
                            instructionList.addNOP(i);
                            instructionList.addNOP(i);
                        } else {
                            instructionList.addNOP(i);
                        }
                    }
                }else{
                    //O QUE FAZER?
                }
            }
            i=i.getNext();
        }

    }
}