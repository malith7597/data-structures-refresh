import org.w3c.dom.Node;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /*    LinkedList list= new LinkedList();
           list.addLast(10);
           list.addLast(20);
           list.addLast(30);
           list.addLast(40);
           list.addLast(50);
        //  list.removeLast();
       //    list.print();


      //  System.out.println(list.size());

      //    list.reverse();
          int[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));
        int kFromEndValue= list.getKThNodeFromEnd(4);
        System.out.println("Value from kth Node from End:"+kFromEndValue);



    //    System.out.println( list.contains(20)); works fine
      //  System.out.println(list.contains(50));  works fine
       // list.removeFirst();
*/
        String a= "abcd";
        String reverse="";
        Stack<Character> stack1 = new Stack<>();
        /*for(int i=0;i<a.length();i++){
            stack1.push(a.charAt(i));
        }*/
        for(char c: a.toCharArray()){
            stack1.push(c);
        }

        while(!stack1.empty()) {
            reverse+=stack1.pop();
        }
        System.out.println(reverse);


    }

}
