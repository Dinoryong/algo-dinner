
class Solution {
    
    String[] graycode;
    
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int len = (int)Math.pow(2,n);
        graycode = new String[len];
        Arrays.fill(graycode, "");       
        
        getGrayCode(n);
        
        for(String s : graycode) res.add(Integer.parseInt(s,2));
        
        return res;
    }
    
    public void getGrayCode(int n){
        if(n == 1){
            graycode[0] = "0";
            graycode[1] = "1";
            return;
        } 
        getGrayCode(n-1);
        
        int len = (int)Math.pow(2,n);
        String[] copy = new String[len];
        
        for(int i = 0 ; i < len>>1 ; ++i){
            copy[i] = graycode[i];
        }
        
        for(int i = len>>1 ; i < len ; ++i){
            copy[i] = graycode[len - i - 1];
        }
        
        System.out.println("copy "+Arrays.toString(copy));
        for(int i = 0 ; i < len >> 1 ; ++i){
            graycode[i] = "0"+copy[i];
        }
        System.out.println("graycode1 "+Arrays.toString(graycode));
        
        for(int i = len >> 1 ; i < len ; ++i){
            graycode[i] = "1" + copy[i];
        }
        System.out.println("graycode2 "+Arrays.toString(graycode));
    }
}