
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class recursive {

    private Node root;

    public void add(String word) {

        Node temp = new Node(word);

        if (root == null) //initialize root to null
        {
            root = temp;
        } else {

            Node a = root;

            Node b = root;                                           //previous node=root

            while (a != null) //if the the left/right node is null
            {

                b = a;

                int cmpP = word.compareTo(a.value);                 //comparing words or strings

                if (cmpP < 0) {

                    a = a.left;                                     //current node is left of thr current

                } else {
                    a = a.right;                                  //previous is right of the current
                }

            }

            int cmpPrev = word.compareTo(b.value);

            if (cmpPrev > 0) {

                b.right = temp;

            } else {
                b.left = temp;
            }
        }
    }

    class Node {
        
        
        String value;
        int count = 0;
        Node left;
        Node right;

        Node(String value) {

            this.value = value;
            count++;
            left = right = null;

        }

        Node(String word, Node left, Node right) {

            value = word;
            count++;
            left = left;
            right = right;

        }

    }

    //nodes according to the "bottom-up" postorder traversal
    void recPostorder(Node node) {
        if (node == null) {
            return;
        }

        // left subtree recursion
        recPostorder(node.left);

        // right subtree recursion
        recPostorder(node.right);

        // node or the root elemnet
        System.out.println(node.value + " ");
    }

    //recursive InOrder Traversal
    void recInorder(Node node) {
        if (node == null) {
            return;
        }

        //initial recursion on left chil
        recInorder(node.left);

        //print the child
        System.out.println(node.value + " ");

        //recursion on right child
        recInorder(node.right);
    }

    //recursive post order traversal
    void recPreorder(Node node) {
        if (node == null) {
            return;
        }

        //print root of node
        System.out.println(node.value + " ");

        //recursion on left sub-tree
        recPreorder(node.left);

        //recursion on right sub-tree
        recPreorder(node.right);
    }

    //call all classes
    void recPostorder() {
        recPostorder(root);
    }

    void recInorder() {
        recInorder(root);
    }

    void recPreorder() {
        recPreorder(root);
    }

    // static BinaryTree
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("data.txt");
        Scanner sc = new Scanner(f);

        recursive tree = new recursive();
        while (sc.hasNext()) {
            tree.add(sc.nextLine());
        }

        System.out.println("\n");
        System.out.println("EXTRA CREDIT TASK\n");

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Preorder Traversal Using recursion: ");
        tree.recPreorder();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("\nInorder Traversal Using recursion: ");
        tree.recInorder();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("\nPostorder traversal Using Recursion: ");
        tree.recPostorder();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }
}

