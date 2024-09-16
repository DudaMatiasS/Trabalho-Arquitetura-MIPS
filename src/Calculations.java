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
           reorderWithForwarding();
        }

        //instructionList.print();
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
    //VERIFICAR SE O FOREARDING esta 100 funcional
    public void reorderWithForwarding() {
        forwarding(); // Inserir NOPs para resolver os conflitos
        reorder(); // Reordenar as instruções para minimizar os conflitos
    }
    public void reorder() {
        Instruction current = instructionList.getFirst();
        while (current != null) {
            if (current.getFunc().equals("NOP")) {
                Instruction prevInst = current.getPrev(); // Instrução antes do NOP
                Instruction nextInst = current.getNext(); // Instrução depois do NOP
                // Verificar se prevInst e nextInst são válidos
                if (prevInst != null && nextInst != null) {
                    // Verificar se há conflito entre prevInst e nextInst usando hasConflict
                    if (instructionList.hasConflict(prevInst, nextInst)) {
                        // Procurar uma instrução mais adiante para trocar que não gere novos conflitos
                        Instruction swapCandidate = findInstructionToSwap(prevInst, nextInst);
                        if (swapCandidate != null && canSwap(prevInst, swapCandidate)) {
                            // Verificar se a troca do nextInst com o swapCandidate não cria novos conflitos
                            if (!instructionList.hasConflict(prevInst, swapCandidate) && !instructionList.hasConflict(swapCandidate, nextInst)) {
                                // Trocar nextInst com o swapCandidate
                                instructionList.swap(nextInst, swapCandidate);
                                // Remover NOP se não houver mais conflito
                                instructionList.removeOneNOP();
                            }
                        }
                    } else {
                        // Se não houver mais conflito, remover o NOP
                        instructionList.removeOneNOP();
                    }
                }
            }
            current = current.getNext();
        }
}

/**
 * Método auxiliar para encontrar a próxima instrução válida para troca.
 * Percorre a lista a partir de 'nextInst' para encontrar uma que não cause conflito com prevInst.
 */
    private Instruction findInstructionToSwap(Instruction prevInst, Instruction startInst) {
        Instruction candidate = startInst.getNext(); // Começa a buscar a partir da próxima instrução após o NOP
        while (candidate != null) {
            // Verificar se a instrução candidata não causa conflito com a prevInst
            if (!instructionList.hasConflict(prevInst, candidate)) {
                return candidate; // Retorna a primeira instrução válida para troca
            }
            candidate = candidate.getNext(); // Continua a busca
        }
        return null; // Nenhuma instrução adequada encontrada
    }

   public boolean canSwap(Instruction instConflict, Instruction instSwap) {
        // Checa se trocar as instruções resolverá o conflito sem criar outros
        return !instructionList.hasConflict(instSwap, instConflict);
    }
}