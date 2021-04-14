public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void input(int arr[][], int n) throws IOException {
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        long[] dp = new long[n + 1];

        long beforeMax = 0;
        long answer = 0;

        Arrays.fill(dp, 0);
        input(arr, n);

        for (int i = 0; i < n; i++) {
            //검사하는 시점에서의 최고값을 업데이트 해준다. 이후 더할 때 이값을 이용해야 한다.(최대를 구하는 것이니까..)
            beforeMax = Math.max(beforeMax,dp[i]);
            if (arr[i][0] + i <= n) {
                int next = arr[i][0] + i;
                //dp에 저장된 값과 이전 최대값 
                dp[arr[i][0] + i] = Math.max(dp[next], arr[i][1] + beforeMax);
            }
        }

        for(long item : dp) {
            answer = Math.max(answer, item);
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }
}