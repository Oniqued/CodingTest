package Sorting.NumSort;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if (i == 0) arr[i] = num;
            int j = i-1;
            while(j >= 0 && arr[j] > num){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = num;
        }

        for(int i = 0; i < N; i++){
            bw.write(String.valueOf(arr[i])+'\n');
        }

        bw.flush();
        bw.close();
    }
}
