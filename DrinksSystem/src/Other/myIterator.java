package Other;

import java.util.Iterator;

public class myIterator<N> implements Iterator<N> {
    private Node<N> position;

    public myIterator(Node<N> firstNode) {
        position = firstNode;
    }
    @Override
    public boolean hasNext() {
        return position != null;
    }

    @Override
    public N next() {
        Node<N> temp = position;
        position = position.next;
        return temp.getContents();
    }

}