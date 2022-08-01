import java.util.NoSuchElementException;

public class LinkedList {

    private class Node{
        private final int value;
        private Node next;


        public Node(int val){ this.value=val;}



    }

    private Node first;
    private Node last;
    private int size;

    //addFirst
    public void addFirst(int v){
        // first wrap the value as a node.
       Node newNode= new Node(v);
       //check if list does not contain any values.
        if(isEmpty()) first=last=newNode;
        else{

            newNode.next=first;
            first=newNode;

        }

        size++;

    }

    //addLast
    public void addLast(int v){
        //wrapping
        Node newNode= new Node(v);
        if(isEmpty()) first=last=newNode;
        else{

            last.next=newNode;
            last=newNode;

        }
        size++;
    }

    private boolean isEmpty(){
        return first==null;
    }





    //addLast
    //deleteFirst
    //deleteLast
    // contains
    //indexOf

    public int indexOf(int item){
        int index=0;
        var current=first;
        while(current!=null){
            if(current.value==item) return index;
            current=current.next;
            index++;
        }
        return -1;
    }

    //contains method
   public boolean contains(int item){
       // boolean IsContain=false;
        //wrap
     /*  var node = new Node(item);
       var current= first;
       while(current!=null) {
           if (current.value == node.value) {
               IsContain = true;
               break;
           }
           current = current.next;

       }
       return IsContain;*/
       // this works as same as below

       return indexOf(item)!=-1;

   }

   public void removeFirst(){
       // 10->20->30
       //check if list is empty

       if(isEmpty()) {
           throw new NoSuchElementException();
       }

       // if the list contains only one element.
        if(first==last){
            first=last=null;

        }else{
            var second= first.next;
            first.next=null;
            first=second;

        }
        size--;
   }

   public void removeLast(){
      /*  // check if list empty.
       var current= first;
       if(isEmpty()){
           throw new NoSuchElementException();
       }
       //contains only one element.
       if(first==last){
           first=last=null;
           return;
       }else{
           while(current!=null){
              if(current.next==last) {
                  current.next=null;
                  last=current;
              }
              current=current.next;
           }
       }*/

       //this works totally fine.

       if(isEmpty()) throw new NoSuchElementException();
       if(first==last) {
           first = last = null;

       }else{
           var previous=getPrevious(last);
           last=previous;
           last.next=null;


       }
       size--;


   }

    private Node getPrevious(Node node){
        var current=first;
        while(current!=null){
            if(current.next==last) return current;
            current=current.next;
        }
        return null;

    }

    public  void print(){

        // if list is empty.
        if(isEmpty()) return;

        var current=first;
        while(current!=null){
            System.out.println(current.value);
            current=current.next;
        }
    }

    public int size(){
        /*int index=0;
        var current=first;
        while(current!=null){
            index++;
            current=current.next;
        }
        return index;*/

        //this will take O(n) time to complete the task.
        // so better in-class variable which reduces the complexity to O(1)
        return size;
    }

    public int[] toArray(){
        int [] array = new int[size];
        int index=0;
        var current= first;
        while(current!=null){
            array[index++]= current.value;
            current= current.next;
        }

        return array;
    }

    public void reverse(){
        var previous= first;
        var current= first.next;

        while(current!=null){
           var n= current.next;
           current.next=previous;
           previous=current;
            current=n;
        }
        last=first;
        last.next=null;
        first=previous;


    }

    public int getKThNodeFromEnd(int k){
        var firstNode= first;
        var second= calculateSecondNode(k);
        while(second!=last){
            firstNode=firstNode.next;
            second=second.next;
        }
        return firstNode.value;
    }

    private Node calculateSecondNode(int k){
        var current= first;
        for(int i=0;i<k-1;i++){
            current=current.next;
        }
        System.out.println("Second Node:" + current.value);
        return current;
    }




}
