import java.io.BufferedWriter;
import java.io.IOException;

public class ListaDE {
    Instruction first;
    public ListaDE(){
        first=null;
    }
    public boolean empty(){
        return first==null;
    }
    public void insert(Instruction i){
        if(empty()){
            first=i;
        }else{
            Instruction item= first;
            while (item.getNext()!=null){
                item = item.getNext();
            }
            item.setNext(i);
            i.setPrev(item);
        }
    }
    public Instruction getFirst(){
        return first;
    }
    public void addNOP(Instruction current){
        Instruction nop = new Instruction("NOP","","","");
        Instruction i =first;
        while(!i.getInstruction().equals(current.getInstruction())){
           i= i.getNext();
        }
        i.getNext().setPrev(nop);
        nop.setNext(i.getNext());
        i.setNext(nop);
        nop.setPrev(i);
    }
    public void removeOneNOP() {
        
    Instruction i = first;
    while (i != null) {
        if (i.getFunc().equals("NOP")) {
            Instruction prev = i.getPrev();
            Instruction next = i.getNext();

            // Verificar se prev e next são válidos e não há mais conflito
            if (prev != null && next != null && !hasConflict(prev, next)) {
                // Remover o NOP, pois não há mais conflito
                prev.setNext(next);
                next.setPrev(prev);
                i.setPrev(null);
                i.setNext(null);
            }
        }
        i = i.getNext();
    }
}
    public boolean hasConflict(Instruction inst1, Instruction inst2) {
    // Comparar registradores das duas instruções
    return (inst1.getR1().equals(inst2.getR1()) || inst1.getR1().equals(inst2.getR2()) || inst1.getR1().equals(inst2.getR3()));
}

    public void write(BufferedWriter writer) throws IOException {
        Instruction item = first;
        while (item != null) {
            writer.write(item.getInstruction());
            writer.newLine();
            item = item.getNext();
        }
    }
    public void swap(Instruction instConflict, Instruction instSwap) {
    // Caso os dois nós sejam iguais, não há necessidade de troca
    if (instConflict == instSwap) {
        return;
    }

    // Salvamos os vizinhos de instConflict e instSwap
    Instruction prevConflict = instConflict.getPrev();
    Instruction nextConflict = instConflict.getNext();
    Instruction prevSwap = instSwap.getPrev();
    Instruction nextSwap = instSwap.getNext();

    // Caso instConflict e instSwap sejam adjacentes, precisamos de um tratamento especial
    if (nextConflict == instSwap) {  // instConflict está logo antes de instSwap
        instConflict.setNext(nextSwap);
        if (nextSwap != null) {
            nextSwap.setPrev(instConflict);
        }
        instConflict.setPrev(instSwap);
        
        instSwap.setPrev(prevConflict);
        if (prevConflict != null) {
            prevConflict.setNext(instSwap);
        }
        instSwap.setNext(instConflict);

    } else if (nextSwap == instConflict) {  // instSwap está logo antes de instConflict
        instSwap.setNext(nextConflict);
        if (nextConflict != null) {
            nextConflict.setPrev(instSwap);
        }
        instSwap.setPrev(instConflict);

        instConflict.setPrev(prevSwap);
        if (prevSwap != null) {
            prevSwap.setNext(instConflict);
        }
        instConflict.setNext(instSwap);

    } else {
        // Conectamos os vizinhos de instConflict e instSwap corretamente
        if (prevConflict != null) {
            prevConflict.setNext(instSwap);
        }
        if (nextConflict != null) {
            nextConflict.setPrev(instSwap);
        }

        if (prevSwap != null) {
            prevSwap.setNext(instConflict);
        }
        if (nextSwap != null) {
            nextSwap.setPrev(instConflict);
        }

        // Agora trocamos os ponteiros entre instConflict e instSwap
        instConflict.setPrev(prevSwap);
        instConflict.setNext(nextSwap);
        instSwap.setPrev(prevConflict);
        instSwap.setNext(nextConflict);
    }

    // Caso um dos nós seja o primeiro da lista, ajustamos o ponteiro 'first'
    if (first == instConflict) {
        first = instSwap;
    } else if (first == instSwap) {
        first = instConflict;
    }
}

}
