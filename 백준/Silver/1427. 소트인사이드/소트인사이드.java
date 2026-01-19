
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        sort(A);

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }

    public static void sort(int[] A) {

        for (int i = 0; i < A.length; i++) {
            int max = 0;
            int index = i;
            int temp;
            for (int j = i; j < A.length; j++) {
                if (A[j] > max) {
                    max = A[j];
                    index = j;
                }
            }

            temp = A[i];
            A[i] = A[index];
            A[index] = temp;

        }
    }
}