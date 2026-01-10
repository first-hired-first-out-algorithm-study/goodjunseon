import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void add(char ch, int[] cnt) {
        switch (ch) {
            case 'A': cnt[0]++; break;
            case 'C': cnt[1]++; break;
            case 'G': cnt[2]++; break;
            case 'T': cnt[3]++; break;
        }
    }

    private static void remove(char ch, int[] cnt) {
        switch (ch) {
            case 'A': cnt[0]--; break;
            case 'C': cnt[1]--; break;
            case 'G': cnt[2]--; break;
            case 'T': cnt[3]--; break;

        }
    }

    private static boolean ok(int[] cnt, int[] need) {
        return cnt[0] >= need[0] && cnt[1] >=need[1] && cnt[2] >= need[2] && cnt[3] >= need[3];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String dna = br.readLine(); // CCTGGATTG

        st = new StringTokenizer(br.readLine());
        int[] need = new int[4]; //A,C,G,T 최소 개수
        need[0] = Integer.parseInt(st.nextToken());
        need[1] = Integer.parseInt(st.nextToken());
        need[2] = Integer.parseInt(st.nextToken());
        need[3] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[4];; // 현재 윈도우의 A,C,G,T 개수

        for (int i = 0; i < P; i++) { // 초기 윈도우 세팅 첫번째 글자부터 P번째 글자까지
            add(dna.charAt(i), cnt);
        }
        int result = 0;
        if (ok(cnt, need)) result++;


        for (int i = P; i < S; i++) {
            remove(dna.charAt(i-P),cnt);
            add(dna.charAt(i), cnt);
            
            if (ok(cnt, need)) result++;
        }

        System.out.println(result);
    }
}