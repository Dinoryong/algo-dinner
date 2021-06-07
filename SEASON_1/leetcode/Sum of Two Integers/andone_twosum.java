class Solution {
    public int getSum(int a, int b) {
        while(a!=0) { //a가 0인 경우는 2진수로 변경 했을때 겹치는 값이 없음 == 즉, 자리올림을 할 필요가 없음 == 덧샘이 끝남
            int temp;
            temp = a & b;//올림수 임시 저장
            b = a ^ b;//올림수 아닌 값 저장
            a = temp<<1;//올림수를 한칸 올림
        }
        return b; 
    }
}
