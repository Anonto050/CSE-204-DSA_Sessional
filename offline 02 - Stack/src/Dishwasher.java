import java.util.Scanner;

public class Dishwasher {
    public static void print(Arr aStack){
        Integer[] n1 = new Integer[aStack.length()];
        int n = aStack.length();
        for(int i = 0;i < n;i++){
            n1[n-i-1] = (Integer) aStack.pop();
        }
        for(int i=0;i < n ;i++){
            System.out.print(n1[i]);
            if(i!=n-1)
               System.out.print(",");
        }
        System.out.println();
        for(int i=0; i < n ; i++){
            aStack.push(n1[i]);
        }
    }

    public static void main(String[] args) {
        int n,x;

        // n = number of invitees
        // x = number of courses

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();

        int[] cost = new int[x];
        int[] invitee = new int[n];
        int busy = 0 ;
        int free_time = 0 ;
        int wash_time = 0 ;

        Arr<Integer> dirtyStack = new Arr<Integer>(n*x);
        Arr<Integer> cleanStack = new Arr<Integer>(n*x);
        Arr<Integer> friendStack = new Arr<Integer>(n);

        for(int i=0;i<x;i++){
             cost[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            invitee[i] = 0;
        }

        int cnt = 0;

        while(true){
             int friend = sc.nextInt();
             int time = sc.nextInt();
             int course = sc.nextInt();

             if(friend==0)
                 break;
             else{
                 invitee[friend-1]++;
                 if(invitee[friend-1]==x)
                     friendStack.push(friend);

                 cnt++;
             }

             free_time = time-busy;

            dirtyStack.push(course);

            if(time==0){
                wash_time = time + cost[dirtyStack.pop()-1]-1;
                busy = wash_time;
                cleanStack.push(wash_time);
            }

            else if(time>busy){
                wash_time = time + cost[dirtyStack.pop()-1]-1;
                busy = wash_time;
                cleanStack.push(wash_time);
            }
            else{
                while(free_time>=0 && dirtyStack.length()!=0){
                    wash_time = busy + cost[dirtyStack.pop()-1];
                    busy = wash_time;
                    cleanStack.push(wash_time);
                }

            }

        }
        System.out.println(cleanStack.topValue());
        print(cleanStack);
        if(cnt==n*x)
            System.out.println("Y");
        else
            System.out.println("N");

        int f=0;
        while(friendStack.length()!=0) {
            if(f>0)
                System.out.print(",");
            System.out.print(friendStack.pop());
            f++;
        }

    }
}
