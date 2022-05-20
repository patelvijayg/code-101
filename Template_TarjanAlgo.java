import java.util.*;

public class Template_TarjanAlgo {
    //https://leetcode.com/problems/critical-connections-in-a-network/discuss/1708223/Java-or-Tarjan-or-No-global-variable
    //n = servers, connections are edges between servers.
    public static void main(String[] args) {
        //int[][] conns={{0,1},{1,2},{2,0},{1,3}};
        List<List<Integer>> conns = new ArrayList<>();
        conns.add(Arrays.asList(0,1));
        conns.add(Arrays.asList(1,2));
        conns.add(Arrays.asList(2,0));
        conns.add(Arrays.asList(1,3));

        int server=4;
        Template_TarjanAlgo driver = new Template_TarjanAlgo();
        List<List<Integer>> b =driver.criticalConnections(server,conns);
        System.out.println(b);
    }
    static int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //Create adjecency list from connection
        Map<Integer, List<Integer>> map = getAdj(connections);
        List<List<Integer>> bridge = new ArrayList<>();
        int[] disc = new int[n], low = new int[n], parent=new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);

        for (int i = 0; i < n; i++) {
            if(disc[i]==-1){
                dfs(i,disc,low,parent,bridge,map);
            }
        }
        return bridge;
    }

    private void dfs(int current, int[] disc, int[] low, int[] parent, List<List<Integer>> bridge,Map<Integer, List<Integer>> adj){
        disc[current]=low[current]=time++;
        for(Integer dest : adj.get(current)){

            if(disc[dest]==-1){ //it mean this node is not visited
                parent[dest]=current;
                dfs(dest,disc,low,parent,bridge,adj);
                low[current]=Math.min(low[current],low[dest]);
                //if discovery time of current node is less than low of destination mean it is weak link
                //because destination is part of another strongly connected component.
                if( disc[current] < low[dest] ){

                    bridge.add(Arrays.asList(current,dest));
                }

            }else if(dest != parent[current]){
                //it is back edge of graph
                low[current]=Math.min(low[current],disc[dest]);
            }

        }


    }
    public Map<Integer, List<Integer>> getAdj(List<List<Integer>> connections){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> conn: connections) {
            Integer source=conn.get(0);
            Integer destination=conn.get(1);
            if(map.containsKey(source)){
                map.get(source).add(destination);
            }else {
                List<Integer> arrDest = new ArrayList<>();
                arrDest.add(destination);
                map.put(source,arrDest);
            }
            if(map.containsKey(destination)){
                map.get(destination).add(source);
            }else {
                List<Integer> arrSrc = new ArrayList<>();
                arrSrc.add(source);
                map.put(destination,arrSrc);
            }

        }
        return map;
    }
}
