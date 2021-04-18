package com.company;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;

    public static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        long answer = 0;
        input();

        long min = 1;
        long max = K;
        long cnt;

        while (min <= max) {
            long mid = (min + max) / 2;
            cnt = 0;

            for (int i = 1; i <= N; i++)
                cnt += Math.min(mid / i, N);

            if (cnt < K) {
                min = mid + 1;
            } else {
                answer = mid;
                max = mid - 1;
            }
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }
}