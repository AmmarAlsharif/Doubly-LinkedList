package dll;

public class DNode {

    public int element;
    public DNode next;
    public DNode prev;

    public DNode(int e) {
        element = e;
        next = null;
        prev = null;
    }
}