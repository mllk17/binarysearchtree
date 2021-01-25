import java.util.Scanner;
public class BST {
    Node jk;
    private int jhope = 0;

    public BST(){
        jk=null;
    }

    public static void main(String[] args) {
        BST bangtan = new BST();
        bangtan.menu();
    }

    public void menu(){
        Scanner answer = new Scanner(System.in);
        int input; int step; int the;
        System.out.println("Continue typing in values to add to the tree. Type 'no' to stop adding values.");
        int suga = 0;
        while (true) {
            String reply = answer.nextLine();
            if(reply.toLowerCase().equals("no")){
                while(suga == 0) {
                    System.out.println("Type 1 to find a node.\n" +
                            "Type 2 to add a node.\n" +
                            "Type 3 to delete a node.\n" +
                            "Type 4 to print the tree.\n" +
                            "Type 5 to exit the program.");
                    step = answer.nextInt();
                    switch (step) {
                        case 1:
                            System.out.println("Which value do you want to find?");
                            the = answer.nextInt();
                            search(the);
                            break;

                        case 2:
                            System.out.println("Which value do you want to add?");
                            the = answer.nextInt();
                            add(the);
                            break;

                        case 3:
                            System.out.println("Which value do you want to delete?");
                            the = answer.nextInt();
                            delete(the);
                            break;

                        case 4:
                            printTree(jk);
                            break;

                        case 5:
                            suga = 1;
                            break;

                    }
                }
                break;
            }
            input = Integer.parseInt(reply);
            add(input);
        }
    }

    public void add(int value){
        jk = addRecur(jk, value);
    }

    public Node addRecur(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(value < root.data){
            root.left = addRecur(root.left, value);
        }
        else if(value > root.data){
            root.right = addRecur(root.right, value);
        }
        return root;
    }

    public void search(int value){
        boolean jimin = searchRecur(jk, value, jhope);
        if(!jimin){
            System.out.println("The value you are looking for is not in the tree.");
        }
    }

    public boolean searchRecur(Node root, int value, int counter){
        boolean found = false;
        if(root == null){
            return found;
        }
        if(root.data == value){
            System.out.println("The value '" + value + "' is found at level " + counter + ".");
            return true;
        }
        if(value < root.data){
            System.out.println("hey");
            counter++;
            found = searchRecur(root.left, value, counter);
        }
        else if(value > root.data){
            System.out.println("hi");
            counter++;
            found = searchRecur(root.right, value, counter);
        }
        return found;
    }

    public void printTree(Node root){
        if(root != null) { //if root = null, goes back to previous call
            printTree(root.left);
            System.out.println(root.data);
            printTree(root.right);
        }
    }

    public void delete(int value){
        jk = deleteRecur(jk, value);
    }

    public Node deleteRecur(Node root, int value){
        int rm = 0;
        int jin;
        if(rm == 0 && root.data == value){ //if 0 children
            //System.out.println("it's null");
            return null;
        }
        else if((rm == 1) && (root.left.data == value)){ // if 1 child
            root.left = null;
        }
        else if((rm == 1) && (root.right.data == value)){ //if 1 child
            root.right = null;
        }
        else if(root.data == value){ //if 2 children
            jin = min(root);
            //System.out.println("The min is " + jin);
            root.data = jin;
            root.right = deleteRecur(root.right, jin); //my original line was deleteRecur(root, jin) & somehow it worked
        }
        else {
            rm++;
            //return root;
        }
        //System.out.println("rm is " + rm);
        if(value < root.data){
            root.left = deleteRecur(root.left, value);
        }
        else if(value > root.data){
            root.right = deleteRecur(root.right, value);
        }

        return root; //?????
    }

    public int min(Node root){ //smallest value to the right of root
        int minValue = 0;
        while(root.left != null){
            minValue = root.data;
        }
        return minValue;
    }
}