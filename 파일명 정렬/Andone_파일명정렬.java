import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files,(String s1, String s2) -> {
            String split1 = s1.split("[0-9]")[0].toLowerCase();
            String split2 = s2.split("[0-9]")[0].toLowerCase();
            
            if(split1.compareTo(split2)==0) {
                String s3 = s1.toLowerCase().replaceAll(split1,"");
                String s4 = s2.toLowerCase().replaceAll(split2,"");
                
                int number1 = Integer.parseInt(s3.split("[^0-9]")[0]);
                int number2 = Integer.parseInt(s4.split("[^0-9]")[0]);
                
                if(number1==number2) {
                    return 0;
                } else {
                    return number1 - number2;
                }
            } else {
                return split1.compareTo(split2);
            }
        });
        
        return files;
    }
}