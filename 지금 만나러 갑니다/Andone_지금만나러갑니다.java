
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int ground = Integer.parseInt(st.nextToken());
        int ori = Integer.parseInt(st.nextToken());
        int sixri = Integer.parseInt(st.nextToken());
        int day = 1;
        boolean isStop = false;

        Set<Integer> fiveSet = new HashSet<>();
        Set<Integer> sixSet = new HashSet<>();
        fiveSet.add(ori);
        sixSet.add(sixri);

        int jump = 1;
        while (jump<=ground) {
            Integer[] fiveArr = fiveSet.toArray(Integer[]::new);
            Integer[] sixArr = sixSet.toArray(Integer[]::new);

            for(Integer item : fiveArr) {
                if (sixSet.contains(item)) {
                    System.out.print(day-1);
                    return;
                }
            }

            fiveSet.clear();
            sixSet.clear();

            for (Integer integer : fiveArr) {
                if (integer - jump > 0)
                    fiveSet.add(integer - jump);
                if (integer + jump <= ground)
                    fiveSet.add(integer + jump);
            }

            for (Integer integer : sixArr) {
                if (integer - jump > 0)
                    sixSet.add(integer - jump);
                if (integer + jump <= ground)
                    sixSet.add(integer + jump);
            }

            day++;
            jump=jump*2;
        }

        System.out.println("-1");
    }
}