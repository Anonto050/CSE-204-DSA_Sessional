import java.util.Scanner;

class Customer{
    private int ID;
    private int enter_time;
    private int service_time;

    Customer(){
        ID=0;
        enter_time = 0;
        service_time = 0;
    }

    Customer(int ID,int enter_time,int service_time){
              this.ID = ID;
              this.enter_time = enter_time;
              this.service_time = service_time;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEnter_time(int enter_time) {
        this.enter_time = enter_time;
    }

    public void setService_time(int service_time) {
        this.service_time = service_time;
    }

    public int getID() {
        return ID;
    }

    public int getEnter_time() {
        return enter_time;
    }

    public int getService_time() {
        return service_time;
    }
}
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] time = new int[n];
        Customer[] customer = new Customer[n];

        for(int i=0;i<n;i++){
            int enter_time = sc.nextInt();
            int service_time = sc.nextInt();
            customer[i] = new Customer(i+1,enter_time,service_time);
            time[i] = enter_time;
        }
        AQueue<Customer> queue1 = new AQueue<>(n);
        AQueue<Customer> queue2 = new AQueue<>(n);

        //LQueue<Customer> queue1 = new LQueue<>();
        //LQueue<Customer> queue2 = new LQueue<>();

        int busyTime1 = customer[0].getEnter_time()+customer[0].getService_time();
        int busyTime2 = 0;
        if(n>1) {
            busyTime2 = customer[1].getEnter_time() + customer[1].getService_time();
        }
        int currTime=time[0];
        int i=0;

        while(true){
            if(currTime==busyTime1){
                //System.out.println("Customer "+queue1.frontValue().getID()+" leaves queue 1 at "+currTime);
                queue1.dequeue();
                if(queue1.length()>0)
                    busyTime1 = currTime+queue1.frontValue().getService_time();
            }
            if(currTime==busyTime2){
                //System.out.println("Customer "+queue2.frontValue().getID()+" leaves queue 2 at "+currTime);
                queue2.dequeue();
                if(queue2.length()>0)
                    busyTime2 = currTime+queue2.frontValue().getService_time();
            }
            if(queue1.length()-queue2.length()>1){
                //System.out.println("Customer "+queue1.rearValue().getID()+" switches from queue 1 to queue 2 at "+currTime);
                if(currTime>=busyTime2)
                    busyTime2 = currTime + queue1.rearValue().getService_time();
                queue2.enqueue(queue1.leaveQueue());
            }
            else if(queue2.length()-queue1.length()>1){
                //System.out.println("Customer "+queue2.rearValue().getID()+" switches from queue 2 to queue 1 at "+currTime);
                if(currTime>=busyTime1)
                    busyTime1 = currTime + queue2.rearValue().getService_time();
                queue1.enqueue(queue2.leaveQueue());
            }

            if(i<n && currTime==time[i]) {
                if (queue1.length() > queue2.length()) {
                    queue2.enqueue(customer[i]);
                    if(queue2.length()==1)
                        busyTime2 = currTime + customer[i].getService_time();
                    i++;
                    //System.out.println("Customer "+queue2.rearValue().getID()+" enters queue 2 at "+currTime);
                } else if (queue1.length() <= queue2.length()) {
                    queue1.enqueue(customer[i]);
                    if(queue1.length()==1)
                        busyTime1 = currTime + customer[i].getService_time();
                    i++;
                    //System.out.println("Customer "+queue1.rearValue().getID()+" enters queue 1 at "+currTime);
                }
                if(i<n && currTime==time[i])
                    continue;
            }
            currTime++;
            if(queue1.length()==0 && queue2.length()==0 && currTime>time[n-1])
                break;
        }

        System.out.println("Booth 1 finishes service at t = "+busyTime1);
        System.out.println("Booth 2 finishes service at t = "+busyTime2);
    }
}
