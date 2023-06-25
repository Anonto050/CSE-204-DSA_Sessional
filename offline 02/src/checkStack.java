import java.util.Scanner;

public class checkStack{
    public static void print(Arr aStack){
        Integer[] n1 = new Integer[aStack.length()];
        int n = aStack.length();
        for(int i = 0;i < n;i++){
            n1[n-i-1] = (Integer) aStack.pop();
        }
        System.out.print("< ");
        for(int i=0;i < n ;i++){
            System.out.print(n1[i]);
            System.out.print(" ");
        }
        System.out.println(">");
        for(int i=0; i < n ; i++){
            aStack.push(n1[i]);
        }
    }

    public static void printLL(LL lStack){
        Integer[] n1 = new Integer[lStack.length()];
        int n = lStack.length();
        for(int i = 0;i < n;i++){
            n1[n-i-1] = (Integer) lStack.pop();
        }
        System.out.print("< ");
        for(int i=0;i < n ;i++){
            System.out.print(n1[i]);
            System.out.print(" ");
        }
        System.out.println(">");
        for(int i=0; i < n ; i++){
            lStack.push(n1[i]);
        }
    }

    public static void main(String[] args) {
        //ArrayList Implementation

        Scanner sc = new Scanner(System.in);

        ///*
        int len = sc.nextInt();
        Arr<Integer> aStack = new Arr<Integer>(len);
        for(int i=0;i<len;i++){
            aStack.push(sc.nextInt());
        }

        print(aStack);

        while(true){
            int task = sc.nextInt();
            Integer param = sc.nextInt();
            if(task==0){
                break;
            }
            else if(task==1){
                aStack.clear();
                print(aStack);
                System.out.println("-1");
            }

            else if(task==2){
                aStack.push(param);
                print(aStack);
                System.out.println("-1");
            }

            else if(task==3){
                Integer ret = aStack.pop();
                print(aStack);
                System.out.println(ret);
            }

            else if(task==4){
                int ret = aStack.length();
                print(aStack);
                System.out.println(ret);
            }

            else if(task==5){
                Integer ret = aStack.topValue();
                print(aStack);
                System.out.println(ret);
            }

            else if(task==6){
                if(aStack.length()!=0){
                    System.out.println("Stack is not empty");
                    print(aStack);
                    System.out.println("-1");
                    continue;
                }

                aStack.setDirection(param);
                print(aStack);
                System.out.println("-1");
            }

            else{
                System.out.println("No valid task.");
            }
        }
        //*/
        //LList Implementation
        /*
        int len = sc.nextInt();
        LL<Integer> lStack = new LL<Integer>(len);
        for (int i = 0; i < len; i++) {
            lStack.push(sc.nextInt());
        }

        printLL(lStack);

        while (true) {
            int task = sc.nextInt();
            Integer param = sc.nextInt();
            if (task == 0) {
                break;
            } else if (task == 1) {
                lStack.clear();
                printLL(lStack);
                System.out.println("-1");
            } else if (task == 2) {
                lStack.push(param);
                printLL(lStack);
                System.out.println("-1");
            } else if (task == 3) {
                Integer ret = lStack.pop();
                printLL(lStack);
                System.out.println(ret);
            } else if (task == 4) {
                int ret = lStack.length();
                printLL(lStack);
                System.out.println(ret);
            } else if (task == 5) {
                Integer ret = lStack.topValue();
                printLL(lStack);
                System.out.println(ret);
            } else {
                System.out.println("No valid task.");
            }
            }
            */
        }
    }
