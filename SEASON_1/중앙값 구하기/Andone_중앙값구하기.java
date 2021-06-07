package com.company;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int caseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseNum; i++) {
            int nowNum = Integer.parseInt(br.readLine());
            List<Integer> numList = new ArrayList<>();
            int line = nowNum / 10;
            if (nowNum % 10 != 0) line+=1;
            for (int j = 0; j < line; j++) {
                String temp = br.readLine();
                String[] list = temp.split(" ");
                for (String s : list) {
                    numList.add(Integer.parseInt(s));
                }
            }

            List<Integer> answerList = new ArrayList<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int j = 0; j < numList.size(); j++) {
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(numList.get(j));
                } else {
                    minHeap.offer(numList.get(j));
                }


                if (!minHeap.isEmpty()) {
                    //둘이 바꿈
                    if (maxHeap.peek() > minHeap.peek()) {
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.offer(t2);
                        minHeap.offer(t1);
                    }
                }

                if (j % 2 == 0) {
                    answerList.add(maxHeap.peek());
                }
            }
            System.out.println(answerList.size());

            for(int k=0;k<answerList.size();k++) {
                if(k!=0&&k%10==0) {
                    System.out.println();
                }
                System.out.print(answerList.get(k) +" ");
            }
            System.out.println();
        }
    }
}