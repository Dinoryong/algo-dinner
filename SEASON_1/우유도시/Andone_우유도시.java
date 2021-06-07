package com.company;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static int[][][] dp;

    public static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
    }

    private static void print() {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(dp[k][i][j]);
                }
                System.out.println();
            }
            System.out.println("---------------------------");
        }
        System.out.println("---------------------------");
    }

    public static void bfs(int want) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==0&&j==0){
                    if (arr[0][0] == 0) {
                        dp[0][0][0] = 1;
                    }
                    continue;
                }
                //지금 위치에서 파는 우유가 0이고 2번 우유의 최대값 + 1
                if (arr[i][j] == 0) {
                    if (i - 1 < 0) {
                        dp[0][i][j] = dp[2][i][j - 1] + 1;
                    } else if (j - 1 < 0) {
                        dp[0][i][j] = dp[2][i - 1][j] + 1;
                    } else {
                        dp[0][i][j] = Math.max(dp[2][i - 1][j] + 1, dp[2][i][j - 1] + 1);
                    }
                } else {
                    if (i - 1 < 0) {
                        dp[0][i][j] = dp[0][i][j - 1];
                    } else if (j - 1 < 0) {
                        dp[0][i][j] = dp[0][i - 1][j];
                    } else {
                        dp[0][i][j] = Math.max(dp[0][i - 1][j], dp[0][i][j - 1]);
                    }
                }

                //지금 위치에서 파는 우유가 1이고 0번 우유의 최대값 + 1
                if (arr[i][j] == 1 && dp[2][i][j] < dp[0][i][j]) {
                    if (i - 1 < 0) {
                        dp[1][i][j] = dp[0][i][j - 1] + 1;
                    } else if (j - 1 < 0) {
                        dp[1][i][j] = dp[0][i - 1][j] + 1;
                    } else {
                        dp[1][i][j] = Math.max(dp[0][i - 1][j] + 1, dp[0][i][j - 1] + 1);
                    }
                } else {
                    if (i - 1 < 0) {
                        dp[1][i][j] = dp[1][i][j - 1];
                    } else if (j - 1 < 0) {
                        dp[1][i][j] = dp[1][i - 1][j];
                    } else
                        dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[1][i][j - 1]);
                }

                //지금 위치에서 파는 우유가 2이고 1번 우유의 최대값 + 1 (하지만 여기서 1번 우유는 0번 우유보다 작으면 안됨. 이유는 0번 우유가 더 크다는 이야기는 순서가 안맞는다는 이야기)
                if (arr[i][j] == 2 && dp[0][i][j] < dp[1][i][j]) {
                    if (i - 1 < 0) {
                        dp[2][i][j] = dp[1][i][j - 1] + 1;
                    } else if (j - 1 < 0) {
                        dp[2][i][j] = dp[1][i - 1][j] + 1;
                    } else
                        dp[2][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[1][i][j - 1] + 1);
                } else {
                    if (i - 1 < 0) {
                        dp[2][i][j] = dp[2][i][j - 1];
                    } else if (j - 1 < 0) {
                        dp[2][i][j] = dp[2][i - 1][j];
                    } else
                        dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[2][i][j - 1]);
                }
                print();
            }
            //print();
        }
        //if (dp[0][N - 1][N - 1] == 0) dp[0][N - 1][N - 1] = 1;
    }

    public static void main(String[] args) throws IOException {
        int answer = Integer.MIN_VALUE;
        input();

        dp = new int[3][N][N];

        int beforewant = 0;

        bfs(beforewant);

        for (int i = 0; i < 3; i++) {
            answer = Math.max(answer, dp[i][N - 1][N - 1]);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}