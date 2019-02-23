
package dll;
public class Test {
    public static void main(String[]args){
        DLL A=new DLL();      
        A.addFirst(10);
        A.addLast(20);
        A.addLast(30);
        A.addInn(30, 25);
        System.out.println(A.getSize());
        System.out.println(A.toString());
        int x= A.delLast();
        A.delInn(20);
        int y= A.delLast();
        System.out.println(A.getSize());
        System.out.println(A.toString());
        System.out.println("x = "+x+"\ty = "+y);
    }
    
    
}
