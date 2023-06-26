import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class BSTMain {
    public static void main(String[] args) throws Exception{

       BST bst = new BST();
       Integer param = 0;

        String INPUT_FILE_NAME = "input.txt";
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                String[] tokens = line.split(" ");
                if(tokens[0].equalsIgnoreCase("I")||tokens[0].equalsIgnoreCase("D")||tokens[0].equalsIgnoreCase("F")){
                    param = Integer.parseInt(tokens[1]);
                }
                if(tokens[0].equalsIgnoreCase("F")){
                    if(bst.find(param)) {
                        System.out.println("True");
                    }
                    else{
                        System.out.println("False");
                    }
                }
                else if(tokens[0].equalsIgnoreCase("I")){
                    bst.insert(param);
                    System.out.println();
                }
                else if(tokens[0].equalsIgnoreCase("D")){
                    bst.delete(param);
                    System.out.println();
                }
                else if(tokens[0].equalsIgnoreCase("T")){
                    if(tokens[1].equalsIgnoreCase("In")){
                            bst.inorder();
                        System.out.println();
                    }
                    else if(tokens[1].equalsIgnoreCase("Pre")){
                            bst.preorder();
                        System.out.println();
                    }
                    else if(tokens[1].equalsIgnoreCase("Post")){
                            bst.postorder();
                        System.out.println();
                    }
                }
            }
            br.close();
    }
}
