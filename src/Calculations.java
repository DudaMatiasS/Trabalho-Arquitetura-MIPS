public class Calculations {
    ListaDE instructionList;
    Tools tool = new Tools();

    public void setInstructionList(ListaDE instructionList) {
        this.instructionList = instructionList;
    }

    public void setWhicConflict(String path) {
        if (path.equals("TESTE-01.txt") || path.equals("TESTE-02.txt")) {
            bubble();
        } else if (path.equals("TESTE-03.txt") || path.equals("TESTE-04.txt")) {
            forwarding();
        } else if (path.equals("TESTE-05.txt") || path.equals("TESTE-06.txt") || path.equals("TESTE-07.txt")) {
            reorderWithBubble();
        } else if (path.equals("TESTE-08.txt") || path.equals("TESTE-09.txt") || path.equals("TESTE-10.txt")) {
            reorderWithForwarding();
        }

    }

    private void bubble() {
        Instruction i = instructionList.getFirst();
        while (i != null) {
            if (!i.getFunc().equals("NOP")) {
                if (!tool.isJump(i.getFunc())) {
                    if (tool.isR1ForDestination(i.getFunc())) {
                        if (i.getNext() != null && (i.getNext().getR1().equals(i.getR1())
                                || i.getNext().getR2().equals(i.getR1()) || i.getNext().getR3().equals(i.getR1()))) {
                            if (i.getFunc().equals("lw") || tool.instIsTypeR(i.getFunc())) {
                                instructionList.addNOP(i);
                                instructionList.addNOP(i);
                            } else {
                                instructionList.addNOP(i);
                            }
                        } else if (i.getNext() != null && i.getNext().getNext() != null
                                && (i.getNext().getNext().getR1().equals(i.getR1())
                                        || i.getNext().getNext().getR2().equals(i.getR1())
                                        || i.getNext().getNext().getR3().equals(i.getR1()))) {
                            if (i.getFunc().equals("lw") || tool.instIsTypeR(i.getFunc())) {
                                instructionList.addNOP(i.getNext());
                            }
                        }
                    }
                }
            }
            i = i.getNext();
        }
    }

    public void forwarding() {
        Instruction i = instructionList.getFirst();
        while (i != null) {
            if (!i.getFunc().equals("NOP")) {
                if (!tool.isJump(i.getFunc())) {
                    if (tool.isR1ForDestination(i.getFunc())) {
                        if (i.getNext() != null && (i.getNext().getR1().equals(i.getR1())
                                || i.getNext().getR2().equals(i.getR1()) || i.getNext().getR3().equals(i.getR1()))) {
                            if (tool.isForwardingMem(i.getFunc())) {
                                instructionList.addNOP(i);
                            }
                        }
                    }
                }
            }
            i = i.getNext();
        }
    }

    private void reorderWithBubble() {
        bubble();
        reorder();
    }

    public void reorderWithForwarding() {
        forwarding();
        reorder();
    }

    public void reorder() {
        Instruction current = instructionList.getFirst();
        boolean madeSwap = false;
        while (current != null) {
            if (current.getFunc().equals("NOP")) {
                if (current.getPrev() != null && current.getNext() != null) {
                    Instruction prevInst = current.getPrev();
                    Instruction nextInst = current.getNext();
                    madeSwap = bodyOfReorder(prevInst, nextInst);
                    if (madeSwap) {
                        current = instructionList.getFirst();
                        continue;
                    }
                }
            }
            current = current.getNext();
        }
    }

    private Instruction findInstructionToSwap(Instruction prevInst, Instruction startInst) {
        Instruction candidate = startInst.getNext();
        while (candidate != null) {
            if (!instructionList.hasConflict(prevInst, candidate)) {
                return candidate;
            }
            candidate = candidate.getNext();
        }
        return null;
    }

    public boolean bodyOfReorder(Instruction prevInst, Instruction nextInst) {
        if (instructionList.hasConflict(prevInst, nextInst)) {
            Instruction swapCandidate = findInstructionToSwap(prevInst, nextInst);
            if (swapCandidate != null) {
                if (!instructionList.hasConflict(prevInst, swapCandidate)
                        && !instructionList.hasConflict(swapCandidate, nextInst)) {
                    instructionList.swap(nextInst, swapCandidate);
                    instructionList.removeOneNOP();
                    return true;
                }
            }
        } else {
            instructionList.removeOneNOP();
        }
        return false;
    }

}