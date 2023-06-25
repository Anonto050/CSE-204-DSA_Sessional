import java.io.*;
import java.util.*;

public class Snake_Ladder {

    int [] move_holder;
    int [] visited_holder;
    int dice;
    Node temp;
    int result = 0;

    Snake_Ladder(int [] moves, int dice)
    {
        move_holder = Arrays.copyOf(moves,moves.length+1);
        visited_holder = new int[moves.length+1];
        this.dice=dice;
        temp = new Node(moves.length+1);
    }

    int min_throws(int[] moves,int size)
    {
        Node tmp = new Node(size);
        Queue<Node> holder = new LinkedList<>();
        int node;
        tmp.setVertice(1);
        tmp.setParent(-1,1);
        tmp.setDistance(0);
        holder.add(tmp);
        visited_holder[1]=1;
        while(!holder.isEmpty())
        {
            tmp = holder.remove();
            node = tmp.getVertice();
            if(node == size-1)
            {
                result = tmp.getDistance();
            }
            for(int i=node+1;(i<= node+dice)&&(i<size);++i)
            {
                if(visited_holder[i]==0)
                {
                    Node visit = new Node(size);
                    visited_holder[i] = 1;
                    visit.setDistance(tmp.getDistance()+1);
                    if(moves[i]!=-1)
                    {
                        temp.setParent(node,i);
                        visit.setVertice(moves[i]);
                        visited_holder[moves[i]]=1;
                        temp.setParent(i,moves[i]);
                    }
                    else if(temp.getParent(i)==0)
                    {
                        temp.setParent(node,i);
                        visit.setVertice(i);
                    }
                    holder.add(visit);
                }
            }

        }
        if(visited_holder[size-1]==0)
        {
            result=-1;
        }
        return result;
    }

    Stack shortest_path(int size)
    {
        Stack<Integer> path = new Stack<>();
        if(visited_holder[size-1]!=0) {
            path.push(size - 1);
            int i = size - 1;
            while ( i != 1 ) {
                path.push(temp.getParent(i));
                i = temp.getParent(i);
            }
        }
        return path;
    }

    Queue Reachable_Vertices(int size)
    {
        Queue<Integer> Unreachables = new LinkedList<>();
        for(int i=1;i<size;i++)
        {
            if(visited_holder[i]==0)
            {
                Unreachables.add(i);
            }
        }
        return Unreachables;
    }

    public static void main(String[] args) throws IOException {
        File obj = new File("C:\\Users\\hridi\\Desktop\\L2T1\\Offline 06\\input.txt");
        FileWriter writer = new FileWriter("C:\\Users\\hridi\\Desktop\\L2T1\\Offline 06\\output.txt");
        Scanner reader = new Scanner(obj);
        int testcase = Integer.parseInt(reader.nextLine());

        while(testcase>0){
            String x = reader.nextLine();
            String[] s = x.split(" ");
            int N = Integer.parseInt(s[1]) +1;

            int[] grid = new int[N];
            for (int i = 1; i < N; i++)
                grid[i] = -1;

            int dice = Integer.parseInt(s[0]);

            int ladders = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < ladders; i++) {
                String data = reader.nextLine();

                String[] str = data.split(" ");
                grid[Integer.parseInt(str[0])] = Integer.parseInt(str[1]);
            }

            int snakes = Integer.parseInt(reader.nextLine());
            for (int i = 0; i < snakes; i++) {
                String data = reader.nextLine();

                String[] str = data.split(" ");
                grid[Integer.parseInt(str[0])] = Integer.parseInt(str[1]);
            }

            Snake_Ladder game = new Snake_Ladder(grid,dice);
            Stack<Integer> Sequence_result;
            Queue<Integer> Unreachables;

            int Minimum_Throws=game.min_throws(grid, N);

            Sequence_result = game.shortest_path(N);
            Unreachables = game.Reachable_Vertices(N);

            writer.write("Minimum Dice Throws Required To Reach The Goal Is:  ");
            writer.write(""+Minimum_Throws);
            writer.write("\n");

            if(Sequence_result.size()!=0)
            {
                writer.write(""+Sequence_result.pop());

                while(Sequence_result.size()!=0)
                {
                    writer.write(" -> "+Sequence_result.pop());
                }
                writer.write("\n");
            }
            else
            {
                writer.write("No Solution");
                writer.write("\n");
            }

            if(Unreachables.size()!=0)
            {
                writer.write("Unreachable Vertices: ");
                while(Unreachables.size()!=0)
                {
                    writer.write(Unreachables.remove() + " ");

                }
            }
            else
            {
                writer.write("All Reachable");
            }

            writer.write("\n");
            writer.write("\n");
            testcase--;
        }
        reader.close();
        writer.close();

    }
}