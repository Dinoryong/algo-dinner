import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        Arrays.sort(timetable, (o1, o2) -> {
            String[] s1 = o1.split(":");
            String[] s2 = o2.split(":");

            if (s1[0].equals(s2[0])) {
                return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
            } else {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        String leaveTime = "09:00"; 

        int answerHour = 0;
        int answerMinute = 0;

        String[] time = leaveTime.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int thisBusMember = 0; //지금 버스에 탄 사람
        int lastIndex = 0;
        int bus = 0;

        for (int i = 0; i < timetable.length; i++) {
            String[] nowTime = timetable[i].split(":");
            int memberHour = Integer.parseInt(nowTime[0]);
            int memberMinute = Integer.parseInt(nowTime[1]);
                        
            if (hour > memberHour || (hour == memberHour && minute >= memberMinute)) {
                thisBusMember++;
            } else {
                bus++;
                                
                if (bus >= n) {
                    break;
                }
                
                i--;
                
                lastIndex = i;
                
                thisBusMember = 0;
                minute += t;
                if (minute >= 60) {
                    hour += 1;
                    minute -= 60;
                }
            }
            
                        
            if(i==timetable.length-1) {
                lastIndex = i;
            }
        }

        
        if (thisBusMember < m) {
            answer = toString(hour, minute);
        } else {
            String[] lastMemberTime = timetable[lastIndex].split(":");
            int lastHour = Integer.parseInt(lastMemberTime[0]);
            int lastMinute = Integer.parseInt(lastMemberTime[1]);
            
            if (lastMinute-1 < 0) {
                lastHour -= 1;
                lastMinute = 60;
            }
            
            answer = toString(lastHour, lastMinute-1);
        }

        return answer;
    }

    String toString(int hour, int minute) {
        String returnHour = hour >= 10 ? String.valueOf(hour) : "0" + hour;
        String returnMinute = minute >= 10 ? String.valueOf(minute) : ("0" + minute);
        return returnHour + ":" + returnMinute;
    }
}