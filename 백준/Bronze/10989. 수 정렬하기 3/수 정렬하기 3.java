import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10_001];

        for (int i = 0; i < N; i++) {
            int num =  Integer.parseInt(br.readLine());
            arr[num]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
        bw.close();

    }
}