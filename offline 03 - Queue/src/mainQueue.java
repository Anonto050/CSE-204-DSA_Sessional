import java.util.Scanner;

public class mainQueue {
    public static void print(LQueue queue){
         Integer[] temp = new Integer[queue.length()];
         for(int i=0;queue.length()>0;i++){
             temp[i]= (Integer) queue.dequeue();
         }
        System.out.print("< ");
        for (int i=0;i< temp.length;i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println(">");
        for (int i=0;i< temp.length;i++){
            queue.enqueue(temp[i]);
        }
    }

    public static void print(AQueue queue){
        Integer[] temp = new Integer[queue.length()];
        for(int i=0;queue.length()>0;i++){
            temp[i]= (Integer) queue.dequeue();
        }
        System.out.print("< ");
        for (int i=0;i< temp.length;i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println(">");
        for (int i=0;i< temp.length;i++){
            queue.enqueue(temp[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        //LQueue<Integer> queue = new LQueue<>();
        AQueue<Integer> queue = new AQueue<>(len);
        for(int i=0;i<len;i++){
            queue.enqueue(sc.nextInt());
        }
        print(queue);
        while(true){
            int task = sc.nextInt();
            Integer param = sc.nextInt();
            if(task==0){
                break;
            }
            else if(task==1){
                queue.clear();
                print(queue);
                System.out.println("-1");
            }

            else if(task==2){
                queue.enqueue(param);
                print(queue);
                System.out.println("-1");
            }

            else if(task==3){
                Integer ret = queue.dequeue();
                print(queue);
                System.out.println(ret);
            }

            else if(task==4){
                Integer ret = queue.length();
                print(queue);
                System.out.println(ret);
            }

            else if(task==5){
                Integer ret = queue.frontValue();
                print(queue);
                System.out.println(ret);
            }

            else if(task==6){
                Integer ret = queue.rearValue();
                print(queue);
                System.out.println(ret);
            }

            else if(task==7){
                Integer ret = queue.leaveQueue();
                print(queue);
                System.out.println(ret);
            }
            else if(task == 8){
                print(queue);
                queue.reverse(queue);
            }
            else
                System.out.println("No valid task");
        }
    }
}
