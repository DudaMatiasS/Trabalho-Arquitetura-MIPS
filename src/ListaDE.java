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
    public void print(){
        Instruction item = first;
        while (item!=null){
            System.out.println(item.getInstruction());
            item = item.getNext();
        }
    }

}
