import java.util.*;

public class Main {
	
	static int N; // 단어의 개수
	static int K; // 배울 수 있는 글자의 개수
	static int answer; // 읽을 수 있는 단어 최대 수
	
	static char[] alpha = { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static boolean[] select = new boolean[26]; // 선택된 알파벳 체크
	static String[] word; // 단어 목록
	
	public static void dfs(int idx, int cnt) {
		// 알파벳의 조합이 완성되었을 경우
		if(cnt == K) {
			int read = 0;
			for(int i=0; i<word.length; i++) {
				// 단어의 글자가 각각 선택된 알파벳인지 체크
				// 하나라도 선택되지 않았을 경우, 읽을 수 없는 단어이므로 중단
				boolean exist = true;
				for(int j=0; j<word[i].length(); j++) {
					int index = word[i].charAt(j) - 97;
					if(select[index] == false) {
						exist = false;
						break;
					}
				}
				// 현재 단어에 포함되는 알파벳이 모두 선택된 알파벳일 경우, 읽을 수 있는 단어
				if(exist == true) read++;
			}
			
			// 읽을 수 있는 최대 단어 수를 저장함
			answer = Integer.max(answer, read);
			if(answer == N) return;
		}
		
		// 조합 생성
		for(int i=idx; i<select.length; i++) {
			if(select[i] == true) continue;
			select[i] = true;
			dfs(i, cnt + 1);
			select[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 단어의 개수
		K = sc.nextInt(); // 배울 수 있는 글자의 개수
		word = new String[N];
		
		// 입력받은 단어 중 필수 알파벳 제외
		for(int i=0; i<N; i++) {
			word[i] = sc.next();
			word[i] = word[i].replaceAll("a", "").replaceAll("n", "").replaceAll("t", "").replaceAll("i", "").replaceAll("c", "");
		}
		
		// 남극 언어의 필수 알파벳인 'a','n','t','i','c'를 배울 수 없을 경우
		if(N > 0 && K < 5) {
			System.out.println(0);
			return;
		}
		
		// 'a','n','t','i','c'는 무조건 배워야 함
		select[0] = true;
		select[2] = true;
		select[8] = true;
		select[13] = true;
		select[19] = true;
		
		dfs(0, 5);
		System.out.println(answer);
	}
}
