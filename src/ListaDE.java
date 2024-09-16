import java.io.BufferedWriter;
import java.io.IOException;

public class ListaDE {
    Instruction first;
    Tools tool = new Tools();

    public ListaDE() {
        first = null;
    }

    public boolean empty() {
        return first == null;
    }

    public void insert(Instruction i) {
        if (empty()) {
            first = i;
        } else {
            Instruction item = first;
            while (item.getNext() != null) {
                item = item.getNext();
            }
            item.setNext(i);
            i.setPrev(item);
        }
    }

    public Instruction getFirst() {
        return first;
    }

    public void addNOP(Instruction current) {
        Instruction nop = new Instruction("NOP", "", "", "");
        Instruction i = first;
        while (!i.getInstruction().equals(current.getInstruction())) {
            i = i.getNext();
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

                if (prev != null && next != null && !hasConflict(prev, next)) {

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
        if (tool.isR1ForDestination(inst1.getFunc())) {
            return (inst1.getR1().equals(inst2.getR1()) || inst1.getR1().equals(inst2.getR2())
                    || inst1.getR1().equals(inst2.getR3()));
        }
        return false;

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

        if (instConflict == instSwap) {
            return;
        }
        Instruction prevConflict = instConflict.getPrev();
        Instruction nextConflict = instConflict.getNext();
        Instruction prevSwap = instSwap.getPrev();
        Instruction nextSwap = instSwap.getNext();
        if (nextConflict == instSwap) {
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

        } else if (nextSwap == instConflict) {
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

            if (prevConflict != null) {
                prevConflict.setNext(instSwap);
            } else {

                first = instSwap;
            }

            if (nextConflict != null) {
                nextConflict.setPrev(instSwap);
            }

            if (prevSwap != null) {
                prevSwap.setNext(instConflict);
            } else {

                first = instConflict;
            }

            if (nextSwap != null) {
                nextSwap.setPrev(instConflict);
            }

            instConflict.setPrev(prevSwap);
            instConflict.setNext(nextSwap);
            instSwap.setPrev(prevConflict);
            instSwap.setNext(nextConflict);
        }

        if (first == instConflict) {
            first = instSwap;
        } else if (first == instSwap) {
            first = instConflict;
        }
    }

}
