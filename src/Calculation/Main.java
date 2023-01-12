package Calculation;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int sum(int x, int y){
        return x + y;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = sum(x, y);
        }
        for(int i = 0; i < N; i++){
            bw.write(String.valueOf(arr[i]) + '\n');
        }

        bw.flush();
        bw.close();
    }
}