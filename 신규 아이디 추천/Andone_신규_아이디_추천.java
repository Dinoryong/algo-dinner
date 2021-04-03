class Solution {
    public String toLowerCase(String id) {
        return id.toLowerCase();
    }

    public String deleteSpacial(String id) {
        return id.replaceAll("[^\\-_.a-z0-9]","");
    }

    public String makeShorter(String id) {
        while (id.contains("..")) {
            id = id.replace("..",".");
        }
        return id;
    }

    public StringBuilder deleteFirst(StringBuilder sb) {
        if(sb.length()==0)
            return sb;

        if(sb.length()==1) {
            if(sb.charAt(0)=='.')
                sb.deleteCharAt(0);
            return sb;
        }

        while (sb.charAt(0)=='.'||sb.charAt(sb.length()-1)=='.') {
            if(sb.charAt(0)=='.')
                sb.deleteCharAt(0);
            if(sb.charAt(sb.length()-1)=='.')
                sb.deleteCharAt(sb.length()-1);
        }
        return sb;
    }

    public String solution(String new_id) {
        String answer = "";
        new_id=toLowerCase(new_id);
        new_id=deleteSpacial(new_id);
        new_id=makeShorter(new_id);

        StringBuilder sb = new StringBuilder(new_id);

        sb=deleteFirst(sb);

        if(sb.length()==0) {
            sb.append('a');
        }

        if(sb.length()>=16) {
            sb.delete(15,sb.length());
        }

        sb=deleteFirst(sb);

        if(sb.length()<=2) {
            char endChar = sb.charAt(sb.length()-1);
            while (sb.length()!=3) {
                sb.append(endChar);
            }
        }
        answer=sb.toString();
        return answer;
    }
}