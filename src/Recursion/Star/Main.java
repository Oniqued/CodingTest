package Recursion.Star;

import java.io.*;

public class Main {
    static char[][] arr;
    static void star(int x, int y, int N, boolean  blank){
        if(blank){ //공백에 해당될 부분이면
            for(int i = x; i < x+N; i++){
                for(int j = y; j < y+N; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        //제일 하위 블록일 때
        if(N == 1){
            arr[x][y] = '*';
            return;
        }

        int size = N/3;
        int count = 0;
        for(int i = x; i < x+N; i += size){
            for(int j = y; j < y+N; j += size){
                count++;
                if (count == 5) { //5번째 공간은 공백으로 채워져야함
                    star(i, j, size, true);
                }else {
                    star(i, j, size, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        star(0, 0, N, false);

        for(int i = 0; i < N; i++){
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
