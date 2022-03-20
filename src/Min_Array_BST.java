import java.util.ArrayList;
public class Min_Array_BST {
    Node rootNode;

    public class Node {
        Node leftNode;
        Node rightNode;
        Node parentNode;
        int value;
        Node(int value, Node parentNode) {
            this.value = value;
            this.parentNode = parentNode;
        }
    }

    //TBI stands for To Be Inserted
    protected void insertNode(Node TBI, int value) {
        if (value < TBI.value) {
            if (TBI.leftNode == null) {
                TBI.leftNode = new Node(value, TBI);
            }
            else {
                insertNode(TBI.leftNode, value);
            }
        }
        else if (value > TBI.value) {
            if (TBI.rightNode == null) {
                TBI.rightNode = new Node(value, TBI);
            }
            else {
                insertNode(TBI.rightNode, value);
            }
        }
    }

    protected static Node nodeMin(Node node) {
        while(node.leftNode != null) {
            node = node.leftNode;
        }
        return (node);
    }

    //Transplant Function
    protected static void Transplant(Min_Array_BST tree, Node node1, Node node2) {
        if (node1.parentNode == null) {
            tree.rootNode = node2;
        }
        else if (node1 == node1.parentNode.leftNode) {
            node1.parentNode.leftNode = node2;
        }
        else {
            node1.parentNode.rightNode = node2;
        }
        if (node2 != null) {
            node2.parentNode = node1.parentNode;
        }
    }

//    TBD stands for To Be Deleted
    protected static void delete(Min_Array_BST tree, Node TBD) {
        if (TBD.leftNode == null) {
            Transplant(tree, TBD, TBD.rightNode);
        }
        else if (TBD.rightNode == null) {
            Transplant(tree, TBD, TBD.leftNode);
        }
        else {
            Node y = nodeMin(TBD.rightNode);
            if (y.parentNode != TBD) {
                Transplant(tree, y, y.rightNode);
                y.rightNode = TBD.rightNode;
                y.rightNode.parentNode = y;
            }
            Transplant(tree, TBD, y);
            y.leftNode = TBD.leftNode;
            y.leftNode.parentNode = y;
        }
    }

    protected static void printNodes(Node node) {
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

    protected void insert(int value) {
        if (this.rootNode == null) {
            this.rootNode = new Node(value, null);
        }
        else {
            insertNode(this.rootNode, value);
        }
    }

    protected int MIN() {
        Node node = this.rootNode;
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return (node.value);
    }

    protected int EXTRACT_MIN() {
        Node node = this.rootNode;
        while(node.leftNode != null) {
            node = node.leftNode;
        }
        delete(this, node);
        return (node.value);
    }

    public static void main(String[] args) {
        Min_Array_BST tree = new Min_Array_BST();
        tree.insert(43);
        tree.insert(15);
        tree.insert(22);
        tree.insert(3);
        tree.insert(4);
        tree.insert(1);
        tree.insert(12);
        tree.insert(23);
        tree.insert(18);
        tree.insert(16);
        System.out.println("__________");
        printNodes(tree.rootNode);
        System.out.println("__________");
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        System.out.println(tree.EXTRACT_MIN());
        printNodes(tree.rootNode);
    }
}


