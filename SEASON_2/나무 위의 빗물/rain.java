import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    static int leafNode = 0;

    static void dfs(int node) {
        visited[node] = true;
        if(list.get(node).size()==1 && visited[list.get(node).get(0)]) {
            leafNode++;
        }

        for(int i=0;i<list.get(node).size();i++) {
            int nextNode = list.get(node).get(i);
            if(!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
                visited[nextNode] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int W = Integer.parseInt(temp[1]);

        list = new ArrayList<>();

        for(int i=0;i<N+1;i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++) {
            temp = br.readLine().split(" ");
            list.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
            list.get(Integer.parseInt(temp[1])).add(Integer.parseInt(temp[0]));
        }

        visited = new boolean[N+1];

        dfs(1);

        System.out.println((double)W/leafNode);
    }
}