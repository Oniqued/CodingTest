package Recursion.Z;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        recursion(row, col, (int)Math.pow(2, N));
        System.out.println(count);
    }

    //생각 할 것 : r,c가 몇사분면에 있는가? ex)3 7 7 은 몇사분면인가 규칙
    public static void recursion(int row, int col, int size) {
        if (size == 1) {
            return;
        }
        int n = size/2;
        if (row < n && col < n) { //1사분면
            count = count + n * n * 0;
            recursion(row, col, n);
        } else if (row < n && col < n + n) { //2사분면
            count = count + n * n * 1;
            recursion(row, col-n, n);
        } else if (row < n + n && col < n) { //3사분면
            count = count + n * n * 2;
            recursion(row-n, col, n);
        } else if (row < n + n && col < n + n) { //4사분면
            count = count + n * n * 3;
            recursion(row-n, col-n, n);
        }
    }
}
