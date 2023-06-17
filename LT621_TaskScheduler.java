import java.util.*;
public class LT621_TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = new char[] {'A','A','A','B','B','B'};
        int n = 2;
        int output = leastInterval(tasks,n);
        System.out.println(output);
    }
    public static int leastInterval(char[] tasks, int n) {
        //idea is to put all the task in max heap and pickup one by one and then add the remaining
        //tasks to another queue with added cooling period. once cooling period over move that
        //tasks to max heap and it will be repeat till both queue became empty.
        int[] fre = new int[26];
        for(int i=0; i<tasks.length; i++){
            fre[tasks[i]-'A']++;
        }
        //use max heap to pick up max number of task first
        Queue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<26; i++){
            if(fre[i]>0){
                pq.add(fre[i]);
            }
        }

        Queue<int[]> q = new ArrayDeque(); //[tasks, nexttime]

        int time=0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(pq.size()>0){
                int task = pq.remove();
                //it task is 1 then we can skip to add into queue because it is covered in this cycle
                //and no more task remain for next cycle for this
                if(task>1) {
                    q.add( new int[]{task-1,time+n});
                }
            }
            if(q.size()>0 && time>=q.peek()[1]){
                int[] ele = q.remove();
                if(ele[0]>0){
                    pq.add(ele[0]);
                }
            }

        }
        return time;
    }

}
