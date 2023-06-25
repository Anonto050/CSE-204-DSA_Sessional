import java.util.Scanner;

public class checkList {
    public static void print(Arr aStack){
              System.out.print("< ");
              for(int i=0;i<aStack.length();i++){
                  System.out.print(aList.getValue());
                   aList.next();
                  System.out.print(" ");
              }
        System.out.println(">");
              aList.moveToPos(pos);
    }

    public static void printLList(LList lList){
        int pos = lList.currPos();
        System.out.print("< ");
        lList.moveToStart();
        for(int i=0;i<lList.length();i++){
            if(pos==i){
                System.out.print("| ");
            }
            System.out.print(lList.getValue());
            lList.next();
            System.out.print(" ");
        }
        System.out.println(">");
        lList.moveToPos(pos);
    }
    public static void main(String[] args) {
        //ArrayList Implementation

        Scanner sc=new Scanner(System.in);

        ///*
        int len = sc.nextInt();
        int chunk_size = sc.nextInt();
        Integer[] n1 = new Integer[chunk_size];
        for(int i=0;i<len;i++){
            n1[i] = sc.nextInt();
        }
        ArrList<Integer> arrList = new ArrList<>(len,chunk_size,n1);
        print(arrList);

        while(true){
            int task = sc.nextInt();
            Integer param = sc.nextInt();
            if(task==0){
                break;
            }
            else if(task==1){
                 arrList.clear();
                 print(arrList);
                System.out.println("-1");
            }

            else if(task==2){
                arrList.insert(param);
                print(arrList);
                System.out.println("-1");
            }

            else if(task==3){
                arrList.append(param);
                print(arrList);
                System.out.println("-1");
            }

            else if(task==4){
                Integer ret = arrList.remove();
                print(arrList);
                System.out.println(ret);
            }

            else if(task==5){
                arrList.moveToStart();
                print(arrList);
                System.out.println("-1");
            }

            else if(task==6){
                arrList.moveToEnd();
                print(arrList);
                System.out.println("-1");
            }

            else if(task==7){
                arrList.prev();
                print(arrList);
                System.out.println("-1");
            }

            else if(task==8){
                arrList.next();
                print(arrList);
                System.out.println("-1");
            }

            else if(task==9){
                int ret = arrList.length();
                print(arrList);
                System.out.println(ret);
            }

            else if(task==10){
                int ret = arrList.currPos();
                print(arrList);
                System.out.println(ret);
            }

            else if(task==11){
                int p = param;
                arrList.moveToPos(p);
                print(arrList);
                System.out.println("-1");
            }

            else if(task==12){
                Integer ret = arrList.getValue();
                print(arrList);
                System.out.println(ret);
            }
            else if(task==13){
                int ret = arrList.Search(param);
                print(arrList);
                System.out.println(ret);
            }
            else{
                System.out.println("No valid task.");
            }
        }
        //*/
        //LList Implementation
        /*
        int size = sc.nextInt();
        Integer[] n2 = new Integer[size];
        for(int i=0;i<size;i++){
            n2[i] = sc.nextInt();
        }
        LList<Integer> lList = new LList<>(size,n2);
        printLList(lList);

        while(true){
            int task = sc.nextInt();
            Integer param = sc.nextInt();
            if(task==0){
                break;
            }
            else if(task==1){
                lList.clear();
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==2){
                lList.insert(param);
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==3){
                lList.append(param);
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==4){
                Integer ret = lList.remove();
                printLList(lList);
                System.out.println(ret);
            }

            else if(task==5){
                lList.moveToStart();
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==6){
                lList.moveToEnd();
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==7){
                lList.prev();
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==8){
                lList.next();
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==9){
                int ret = lList.length();
                printLList(lList);
                System.out.println(ret);
            }

            else if(task==10){
                int ret = lList.currPos();
                printLList(lList);
                System.out.println(ret);
            }

            else if(task==11){
                int p = param;
                lList.moveToPos(p);
                printLList(lList);
                System.out.println("-1");
            }

            else if(task==12){
                Integer ret = lList.getValue();
                printLList(lList);
                System.out.println(ret);
            }
            else if(task==13){
                int ret = lList.Search(param);
                printLList(lList);
                System.out.println(ret);
            }
            else{
                System.out.println("No valid task.");
            }
        }
         */
    }
}
