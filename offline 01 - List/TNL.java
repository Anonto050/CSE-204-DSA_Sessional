import java.util.Scanner;

public class TNL {
    public static void printArray(ArrList list){
        list.moveToStart();
        int i;
        for(i=0;i<list.length();i++){
            if(list.getValue().equals(1)){
                System.out.print(i);
            }
            if(i<list.length()-1){
                System.out.print(",");
            }
            list.next();
        }
        System.out.println();
    }

    public static void printLList(LList list){
        list.moveToStart();
        int i;
        for(i=0;i<list.length();i++){
            if(list.getValue().equals(1)){
                System.out.print(i);
            }
            if(i<list.length()-1){
                System.out.print(",");
            }
            list.next();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rickshaw_spot_number = sc.nextInt();
        int bus_spot_number = sc.nextInt();
        Integer bus_spot_location;
        int train_spot_number;
        Integer train_spot_location;

        //Array based implementation
        /*
        ArrList<Integer> rickshawList = new ArrList<>(rickshaw_spot_number);
        for(int i =0; i<rickshaw_spot_number;i++){
            rickshawList.append(1);
        }
        ArrList<Integer> busList = new ArrList<>(rickshaw_spot_number);
        ArrList<Integer> trainList = new ArrList<>(rickshaw_spot_number);
        */

        //Linked list based implementation

        //*
        LList<Integer> rickshawList = new LList<>();
        for(int i =0; i<rickshaw_spot_number;i++){
            rickshawList.append(1);
        }
        LList<Integer> busList = new LList<>();
        LList<Integer> trainList = new LList<>();
        //*/

        for(int i=0;i<rickshaw_spot_number;i++){
            busList.append(0);
            trainList.append(0);
        }

        for(int i=0;i<bus_spot_number;i++){
            busList.moveToStart();
            bus_spot_location = sc.nextInt();
            busList.moveToPos(bus_spot_location);
            busList.remove();
            busList.insert(1);
        }

        train_spot_number = sc.nextInt();
        for(int i=0;i<train_spot_number;i++){
            trainList.moveToStart();
            train_spot_location = sc.nextInt();
            trainList.moveToPos(train_spot_location);
            trainList.remove();
            trainList.insert(1);
        }
        int task = sc.nextInt();
        //Array
        /*
        printArray(rickshawList);
        printArray(busList);
        printArray(trainList);
        */
        //Linked list
        printLList(rickshawList);
        printLList(busList);
        printLList(trainList);

    }
}
