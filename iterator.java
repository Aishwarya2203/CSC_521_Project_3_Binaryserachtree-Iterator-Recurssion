import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
//Class to create the BinarysearchTree Using Iterator

public class iterator
{
   private Node root;
   public void add(String word )
   {

        Node temp = new Node(word);

        if (root == null)                                             //initialize root to null
        {
           root = temp;
        }

        else

        {

            Node a = root;

            Node b = root;                                           //previous node=root

            while (a!= null)                                         //if the the left/right node is null

            {

                b = a;

                int cmpP = word.compareTo(a.value);                 //comparing words or strings

                if (cmpP < 0)

                {

                    a = a.left;                                     //current node is left of thr current

                }

                else

                {
                    a = a.right;                                  //previous is right of the current
                }

            }

            int cmpPrev = word.compareTo(b.value);

            if (cmpPrev > 0)

            {

                b.right = temp;

            }

            else

            {
                b.left = temp;
            }
        }
    }

              //postorder traversal
public ArrayList<String> postorder(Node root) {

           ArrayList<String> lst = new ArrayList<String>();

           if(root == null)
               return lst;

           Stack<Node> stack = new Stack<Node>();
           stack.push(root);

           Node prev = null;
           while(!stack.empty()){
               Node curr = stack.peek();


               if(prev == null || prev.left == curr || prev.right == curr)
               {
                   //if previous is null then node is null
                   if(curr.left != null){
                       stack.push(curr.left);
                   }else if(curr.right != null){
                       stack.push(curr.right);
                   }else{
                       stack.pop();
                       lst.add(curr.value);
                   }

               }else if(curr.left == prev){
                   if(curr.right != null){
                       stack.push(curr.right);
                   }else{
                       stack.pop();
                       lst.add(curr.value);
                   }


               }else if(curr.right == prev){
                   stack.pop();
                   lst.add(curr.value);
               }

               prev = curr;
           }

           return lst;
       }

//preorder traversal

   public ArrayList<String> preorder(Node root) {
       ArrayList<String> returnList = new ArrayList<String>();

       if(root == null)
           return returnList;

       Stack<Node> stack = new Stack<Node>();
       stack.push(root);

       while(!stack.empty()){
           Node n = stack.pop();
           returnList.add(n.value);

           if(n.right != null){
               stack.push(n.right);
           }
           if(n.left != null){
               stack.push(n.left);
           }

       }
       return returnList;
   }

//inorder traversal

   public List<String> inorder(Node root) {
      ArrayList<String> result = new ArrayList<>();
      Stack<Node> stack = new Stack<>();

      Node a = root;
      while(a!=null){
          stack.push(a);
          a=a.left;
      }

      while(!stack.isEmpty()){
          Node t = stack.pop();
          result.add(t.value);

          t = t.right;
          while(t!=null){
              stack.push(t);
              t = t.left;
          }
      }

      return result;
   }

   //Class to insert values for the dynamic tree, i.e. inserting key values
    class Node

    {

        String value;
        int count = 0;
        Node left;
        Node right;
        Node(String value)

        {

        	this.value = value;
        	count++;
        	left=right=null;

        }

        Node (String word, Node left, Node right)

        {

            value = word;
            count++;
            left = left;
            right = right;

        }

    }

    //main class calling all classes and for reading file

    public static void main(String[] args) throws FileNotFoundException {

    	File f=new File("data.txt");
    	Scanner sc=new Scanner(f);

    	iterator BinarysearchTree = new iterator();
    	while(sc.hasNext())
    	{	 BinarysearchTree.add(sc.nextLine());
    	}

      List<String> post=BinarysearchTree.postorder(BinarysearchTree.root);
    	List<String> in=BinarysearchTree.inorder(BinarysearchTree.root);
    	List<String> pre=BinarysearchTree.preorder(BinarysearchTree.root);


System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
System.out.println("Inorder Traversal Using Iterator:: \n");
  for(String s:in)
System.out.println(s);
System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
System.out.println("Preorder Traversal Using Iterator: \n");
  for(String s:pre)
System.out.println(s);
System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
System.out.println("Postorder Traversal Using Iterator: \n");
	for(String s:post)
System.out.println(s);
System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");



	}


}

