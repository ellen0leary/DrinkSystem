package Other;

public class GenericLinkedList<N> implements Iterable<N> {
    private Node<N> head = null;

    /**
     * adds a new element to the head of the list
     * @param e element added
     */
    public void add(N e){
        Node<N>  newN =new Node<>();
        newN.setContents(e);
        newN.next = head;
        head = newN;
    }

    /**
     * clears the list
     */
    public void clear() {
        if(head!=null){
            head = null;
        }
    }

    /**
     * deletes a certain index in the list
     * @param i
     */
    public void deleteByIndex(int i){
        Node<N> temp= head;
        int x =0;
        if(i==0){
            head = temp.next;
        } else {
            while (x < i && temp != null) {
                temp = temp.next;
                x++;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            }
        }
    }

    /**
     * finds ad returns the length of the list
     * @return
     */
    public int length(){
        Node<N> temp= head;
        int i=0;
        for(; temp!=null;i++){
            temp = temp.next;
        }
        return i;
    }

    /**
     * gets and returns the info of a certain element
     * @param x
     * @return
     */
    public N get(int x){
        int i=0;
        Node<N> temp= head;
        while(i<x&& temp!=null){
            temp= temp.next;
            i++;
        }
        if (temp != null) {
            return temp.getContents();
        }
        else{
            return null;
        }
    }
    @Override
    public myIterator<N> iterator() {
        return new myIterator<N>(head);
    }
}

@SuppressWarnings("WeakerAccess")
class Node<E> {
    public Node<E> next = null;
    private E contents;

    public E getContents() { return contents;}
    public void setContents(E items) {contents =items;}
}