import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            int nodeNum = Integer.parseInt(br.readLine());
            int edgeNum = nodeNum - 1;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int j = 0; j < nodeNum+1; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < edgeNum; j++) {
                String item = br.readLine();
                st = new StringTokenizer(item);
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                list.get(child).add(parent);
            }

            String item = br.readLine();
            st = new StringTokenizer(item);
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();
            Deque<Integer> dq = new ArrayDeque<>();

            dq.add(node1);

            while (!dq.isEmpty()) {
                int now = dq.poll();
                set.add(now);
                dq.addAll(list.get(now));
            }

            dq.add(node2);

            while (!dq.isEmpty()) {
                int now = dq.poll();
                if(set.contains(now)) {
                    System.out.println(now);
                    break;
                }
                dq.addAll(list.get(now));
            }
        }

    }
}