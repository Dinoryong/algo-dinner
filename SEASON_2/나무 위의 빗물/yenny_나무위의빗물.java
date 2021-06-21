import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 노드 수
		int w = sc.nextInt(); // 빗물의 양
		int[] check = new int[n+1];
		
		for(int i=1; i<=n-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			check[u]++;
			check[v]++;
		}
		
		int cnt = 0;
		for(int i=2; i<=n; i++) {
			if(check[i] == 1) cnt++;
		}
		
		System.out.println((double)w / cnt);
	}
}
