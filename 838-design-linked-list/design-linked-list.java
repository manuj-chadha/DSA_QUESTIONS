class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList(){
        head=null;
        size=0;
    }
    public class Node {
        int val;
        Node next;
        public Node(int value){
            this.val=value;
            this.next=null;
        }
    }

    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node node=new Node(val);
        node.next=head;
        head=node;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node=new Node(val);
        if(head==null){
            head=node;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index< 0 || index>size){
            return;
        }
        if(index==size){
            addAtTail(val); 
            return; 
        } 
        if(index==0){
            addAtHead(val);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(val);
        node.next=temp.next;
        temp.next=node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index< 0 || index>=size){
            return;
        }
        if(index==0){
            head=head.next;
            size--;
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
}

/**
 * Your Node object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */