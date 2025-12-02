package binarySearchTrees;

class Node
{
    int data;
    Node next, prev;

    Node(int d)
    {
        data = d;
        next = prev = null;
    }
}

class LinkedList
{
    Node head;

    Node sortedListToBST()
    {
        int n = countNodes(head);
        return sortedListToBSTRecur(n);
    }

    Node sortedListToBSTRecur(int n)
    {
        if (n <= 0) return null;
        Node left = sortedListToBSTRecur(n / 2);
        Node root = head;
        root.prev = left;
        head = head.next;
        root.next = sortedListToBSTRecur(n - n / 2 - 1);
        return root;
    }

    int countNodes(Node head)
    {
        int count = 0;
        Node temp = head;
        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.prev = null;
        new_node.next = head;
        if (head != null)
            head.prev = new_node;
        head = new_node;
    }

    void printList()
    {
        Node node = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.prev);
        preOrder(node.next);
    }

    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();

        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List ");
        llist.printList();

        Node root = llist.sortedListToBST();
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
    }
}
