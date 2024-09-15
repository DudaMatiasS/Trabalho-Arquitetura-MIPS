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
    public void removeOneNOP(){
        Instruction i =first;
        while (i.getNext()!=null){
            if(i.getFunc().equals("NOP")){
                if(i.getNext().getFunc().equals("NOP")){
                    if(i.getNext().getNext()!=null){
                        i.getNext().getPrev().setNext(i.getNext().getNext());
                        i.getNext().getNext().setPrev(i.getNext().getPrev());
                        i.getNext().setPrev(null);
                        i.getNext().setNext(null);
                    }
                }else{
                    i.getPrev().setNext(i.getNext());
                    i.getNext().setPrev(i.getPrev());
                    i.setPrev(null);
                    i.setNext(null);
                }
            }
            i=i.getNext();
        }

    }
    public void write(BufferedWriter writer) throws IOException {
        Instruction item = first;
        while (item != null) {
            writer.write(item.getInstruction());
            writer.newLine();
            item = item.getNext();
        }
    }
    public void swap(Instruction top, Instruction under){
        Instruction i=first;
        if(i.equals(under)){
            top.getPrev().setNext(top.getNext());
            top.getNext().setPrev(top.getPrev());
            top.setPrev(null);
            under.setPrev(top);
            top.setNext(under);
        }else {
            Instruction topPrev;
            Instruction topNext;
            under.getPrev().setNext(top);
            under.getNext().setPrev(top);
            top.setNext(under.getNext());
            top.setPrev(under.getPrev());
            topPrev=top.getPrev();
            topNext=top.getNext();
            under.setNext(topNext);
            under.setPrev(topPrev);

        }

    }

}
