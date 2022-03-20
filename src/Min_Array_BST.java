import java.util.ArrayList;
public class Min_Array_BST {
    Node rootNode;
    int[] arr = new int[100];
    //Runs the insert Command

    public class Node {
        Node leftNode;
        Node rightNode;
        Node parentNode;
        int value;
        //Constructor
        Node(int n, Node parent) {
            this.value = n;
            this.parentNode = parent;
        }
    }

    private void insert (int n) {
        if (this.rootNode == null) {
            this.rootNode = new Node(n, null);
        }
        else {
            AddNode(this.rootNode, n);
        }

    }

    //Adds a node to the tree
    private void AddNode(Node nodeInQuestion, int n) {
        if (n < nodeInQuestion.value) {
            if (nodeInQuestion.leftNode == null) {
                nodeInQuestion.leftNode = new Node(n, nodeInQuestion);
            }
            else {
                AddNode(nodeInQuestion.leftNode, n);
            }
        }
        else if (n > nodeInQuestion.value) {
            if (nodeInQuestion.rightNode == null) {
                nodeInQuestion.rightNode = new Node(n, nodeInQuestion);
            }
            else {
                AddNode(nodeInQuestion.rightNode, n);
            }
        }
        else {
            System.out.println("You are a fool. You cannot have duplicate items in the Binary Tree.");
        }
    }

    //Minimum Function
    private int min() {
        Node n = this.rootNode;
        while(n.leftNode != null) {
            n = n.leftNode;
        }
        return (n.value);
    }

    //nodemin
    private static Node nodeMin(Node n) {
        while(n.leftNode != null) {
            n = n.leftNode;
        }
        return (n);
    }

    //Minimum Function
    private int extract_min() {
        Node n = this.rootNode;
        while(n.leftNode != null) {
            n = n.leftNode;
        }
        delete(this, n);
        return (n.value);
    }

    //Transplant Function
    private static void Transplant(Min_Array_BST T, Node u, Node v) {
        if (u.parentNode == null) {
            T.rootNode = v;
        }
        else if (u == u.parentNode.leftNode) {
            u.parentNode.leftNode = v;
        }
        else {
            u.parentNode.rightNode = v;
        }
        if (v != null) {
            v.parentNode = u.parentNode;
        }
    }

    private static void delete(Min_Array_BST T, Node z) {
        if (z.leftNode == null) {
            Transplant(T, z, z.rightNode);
        }
        else if (z.rightNode == null) {
            Transplant(T, z, z.leftNode);
        }
        else {
            Node y = nodeMin(z.rightNode);
            if (y.parentNode != z) {
                Transplant(T, y, y.rightNode);
                y.rightNode = z.rightNode;
                y.rightNode.parentNode = y;
            }
            Transplant(T, z, y);
            y.leftNode = z.leftNode;
            y.leftNode.parentNode = y;
        }
    }

    private static void printTree(Node node) {
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove(0);
            System.out.println(currentNode.value);
            if (currentNode.leftNode != null) {
                queue.add(currentNode.leftNode);
            }
            if (currentNode.rightNode != null) {
                queue.add(currentNode.rightNode);
            }
        }
    }

    private static int findIndex(Min_Array_BST T, int n) {
        int count = 0;
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(T.rootNode);
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove(0);
            count++;
            System.out.println(count);
            if (n == currentNode.value) {
                return count;
            }
            if (currentNode.leftNode != null) {
                queue.add(currentNode.leftNode);
            }
            if (currentNode.rightNode != null) {
                queue.add(currentNode.rightNode);
            }
        }
        return(0);
    }

    public static void main(String[] args) {
        Min_Array_BST tree = new Min_Array_BST();
        tree.insert(4);
        tree.insert(10);
        tree.insert(15);
        tree.insert(7);
        tree.insert(9);
        tree.insert(13);
        System.out.println("------");
        printTree(tree.rootNode);
        System.out.println("------");

        System.out.println(tree.extract_min());
        System.out.println(tree.extract_min());
        System.out.println(tree.extract_min());
        System.out.println(tree.extract_min());
        System.out.println(tree.extract_min());
        printTree(tree.rootNode);
    }
}