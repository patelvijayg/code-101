import java.util.*;


public class Template_Dijkstra {
    private static class Destination implements Comparable<Destination>{
        int vertex;
        int weight;
        String pathSoFar;

        public Destination(int vertex, int weight, String pathSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.weight = weight;
        }

        @Override
        public int compareTo(Destination o) {
            return this.weight-o.weight;
        }
    }

    public static void main(String[] args) {
        int[][] data1 = {{1,2,1},{2,3,7},{1,3,4},{2,1,2}};
        Map<Integer,Integer> result = sortestPathCost(data1,2,1);
        System.out.println(result);
    }
    //[[2,1,1],[2,3,1],[3,4,1]] where order is src,dest,weight
    public static Map<Integer,Integer> sortestPathCost(int[][] graph, int src, int dest){
        Map<Integer, List<Destination>> map = getAdj(graph);
        System.out.println(map);
        PriorityQueue<Destination> queue=new PriorityQueue<>();
        queue.add(new Destination(src,0,""+src));
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> result = new HashMap<>();
        while (queue.size()>0){
            Destination curr = queue.remove();
            if(visited.contains(curr.vertex)) {
                continue; //skiping element
            }
            System.out.println(curr.vertex + "--"+ curr.pathSoFar);
            result.put(curr.vertex,curr.weight);
            visited.add(curr.vertex);
            //this the case when some nodes are not inserted because that is the last node
            //who does not have adjecny with any node. Inshort it will contains only source node
            if(map.containsKey(curr.vertex)) {
                for (Destination nbr : map.get(curr.vertex)) {
                    if (visited.contains(nbr.vertex) == false) {
                        queue.add(new Destination(nbr.vertex, nbr.weight + curr.weight, curr.pathSoFar + " " + nbr.vertex));
                    }
                }
            }
        }
        return result;
    }
    public static Map<Integer, List<Destination>> getAdj(int[][] graph){
        int SOURCE=0,DEST=1,WEIGHT=2;
        Map<Integer, List<Destination>> map = new HashMap<>();
        for(int[] element: graph){
            List<Destination> curr = map.getOrDefault(element[SOURCE],new ArrayList<Destination>());
            curr.add(new Destination(element[DEST],element[WEIGHT],""));  //dest and weight
            map.put(element[SOURCE],curr);
            //incase destination never be source then we need to consider that too.
            //List<Destination> dest = map.getOrDefault(element[DEST],new ArrayList<Destination>());
            //map.put(element[DEST],dest);

        }
        return map;
    }

}
