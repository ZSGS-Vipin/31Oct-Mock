import java.util.Stack;

public class GreaterElementInList {
    private Node head;
    private Node tail;
    private int size;
    public GreaterElementInList(){
        this.size = 0;
    }
    public static void main(String[] args) {
        GreaterElementInList greaterElementInList = new GreaterElementInList();
        greaterElementInList.insertFirst(5);
        greaterElementInList.insertFirst(3);
        greaterElementInList.insertFirst(4);
        greaterElementInList.insertFirst(7);
        greaterElementInList.insertFirst(2);
       greaterElementInList.printNode(greaterElementInList.nextGreater(greaterElementInList.head));
    }
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
        public void insertFirst(int value) {
           Node node = new Node(value);
           node.next = head;
           head=node;
           size++;
        }
        public void printNode(Node head)
        {
            Node temp = head;
            while(temp!=null)
            {
                System.out.print(temp.value + " ");
                temp=temp.next;
            }
        }
    public Node reverse(Node head)
    {
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
        public Node nextGreater(Node head)
        {
            if(head==null)
            {
                return head;
            }
            Node result = new Node(-1);
            Node temp = result;
            head = reverse(head);
            Node curr = head;
            Stack<Integer> integerStack = new Stack<>();
            while(curr!=null)
            {
                if(integerStack.isEmpty())
                {
                    temp.next = new Node(0);
                    integerStack.push(curr.value);
                }
                else
                {
                    while(!integerStack.isEmpty()&&integerStack.peek()< curr.value)
                    {
                        integerStack.pop();
                    }
                    if(integerStack.isEmpty())
                    {
                        temp.next = new Node(0);
                        integerStack.push(curr.value);
                    }
                    else
                    {
                            temp.next = new Node(integerStack.peek());
                            integerStack.push(curr.value);
                    }
                }
                curr = curr.next;
                temp=temp.next;
            }
            temp=result;
            result=result.next;
            result = reverse(result);
        return result;
        }
        public Node updateNodes(Node head, int value)
        {
            Node temp = new Node(-1);
            temp=head;
            while(temp!=null)
            {
                if(temp.next.value==value)
                {
                    temp.next.value=value;
                }
            }
            return temp;
        }
}
