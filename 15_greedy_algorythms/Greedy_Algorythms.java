import java.util.*;

public class Greedy_Algorythms {
    public static void activitySelection(int start[],int end[]){
        int activities[][] = new int[start.length][3];
        for(int i = 0;i < start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> al = new ArrayList<>();
        al.add(activities[0][0]);
        int last = activities[0][2];
        int maxActivities = 1;

        for(int i = 1;i < start.length;i++){
            if(activities[i][1] >= last){
                al.add(activities[i][0]);
                last = activities[i][2];
                maxActivities++;
            }
        }

        for(int i = 0;i < al.size();i++){
            System.out.print("A"+al.get(i)+" ");
        }
        System.out.println();
        System.out.println("total activities are = "+ maxActivities);
    }
    public static void main(String[] args) {
        System.out.println("----------------- Question 1 ---------------");
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        activitySelection(start,end);
    }
}
