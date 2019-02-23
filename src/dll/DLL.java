package dll;
public class DLL {
    
  private DNode head;
    private int size;

    public DLL() {
        head = null;
        size = 0;
    }

    public void addFirst(int e) {
        DNode n = new DNode(e);
        if (head != null) {
            n.next = head;
            head.prev = n;
            head = n;
            size++;
        } else {
            head = n;
            size++;
        }
    }
// This function to add an element e to the last of the linkedlist
    public void addLast(int e) {
        if (head == null) {
            addFirst(e);
        } else {
            DNode n = new DNode(e);
            DNode ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = n;
            ptr.next.prev = ptr;
            size++;
        }
    }
    

    public void addIn(int p, int e) {
        DNode ptr = head;
        DNode n = new DNode(e);
        if (head == null) {
            System.out.println("Empty");
        } else {
            if (size == 1) {
                if (ptr.element == p) {
                    ptr.next = n;
                    n.prev = ptr;
                    size++;
                } else {
                    System.out.println(p + " is not found");
                }
            } else {
                try {
                    while (ptr.element != p) {
                        ptr = ptr.next;
                    }
                    if (ptr.next == null) {
                        addLast(e);
                    } else {
                        n.next = ptr.next;
                        n.prev = ptr;
                        ptr.next.prev = ptr;
                        ptr.next = n;
                        size++;
                    }
                } catch (NullPointerException ex) {
                    System.out.println(p + " is not found");
                }
            }
        }
    }
    
 // this method from the slide with a fairly modification
    public void addInn(int p,int e){
        DNode n=new DNode(e);
        DNode ptr=head;
        while(ptr!=null)
            if(ptr.element==p)break;
            else ptr=ptr.next;
        if(ptr==null)System.out.println(p+" is not found");
        else if(ptr.next==null){
            ptr.next = n;
            n.prev = ptr;
            size++;
        }
        else{
            n.prev=ptr;
            n.next=ptr.next;
            ptr.next.prev=n;
            ptr.next=n;
            size++;
        }
    }
    
    public int delFirst(){
        int x=-1;
        if(head==null)System.out.println("Nothing to delete");
        else if(head.next==null){x=head.element;  head=head.next;   size--;}
        else{
            x=head.element;
            head=head.next;
            head.prev=null;
            size--;
        }
        return x;
    }
     
    public int delLast(){
        int x=-1;
        if(head==null)System.out.println("Nothing to delete");
        else if(head.next==null)x=delFirst();
        else {
            DNode ptr=head;
            while(ptr.next!=null) ptr=ptr.next;
            x=ptr.element;
            ptr.prev.next=null;
            ptr.prev=null;
            size--;
        }
        return x;
    }
   
    public void  delIn(int e){
        if(head==null)System.out.println("Nothing to delete");
        else if(head.element==e){
            delFirst();
        }
        else{ 
            DNode ptr=head;
            while(ptr!=null)
                if(ptr.element==e)break;
                else ptr=ptr.next;
            if(ptr==null)System.out.println(e+" is not found");
            else if(ptr.next==null){
                delLast();
            }
            else if(ptr.prev==null)delFirst();
            else {
                ptr.prev.next=ptr.next;
                ptr.next.prev=ptr.prev;
                size--;
            }
        }
    }
    
//Another method to delete an element from a specific position
    public void  delInn(int e){
        if(head==null)System.out.println("Nothing to delete");
        else{ 
            DNode ptr=head;
            while(ptr!=null)
                if(ptr.element==e)break;
                else ptr=ptr.next;
            if(ptr==null)System.out.println(e+" is not found");
            else if(ptr.prev==null)delFirst();
            else if(ptr.next==null){
                delLast();
            }
            else {
                ptr.prev.next=ptr.next;
                ptr.next.prev=ptr.prev;
                size--;
            }
        }
    } 
    
    
    

    public String toString() {
        String s = "";
        if(head!=null){
            DNode ptr = head;
            while (ptr != null) {
                s = s + ptr.element + " ";
                ptr = ptr.next;
            }
        }
        else System.out.println("Nothing to print");
        return s;
    }

    public int getSize() {
        return size;
    }

}

