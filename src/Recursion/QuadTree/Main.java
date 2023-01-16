package Recursion.QuadTree;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] img;
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for(int i = 0; i < N; i++){
            String pixel = br.readLine();
            for(int j = 0; j < N; j++){
                img[i][j] = pixel.charAt(j);
            }
        }

        compress(0, 0, N);

        bw.flush();
        bw.close();
    }

    public static void compress(int row, int col, int size) throws IOException {
        if(isSame(row, col, size)) bw.write(img[row][col]);
        else {
            bw.write("(");
            compress(row, col, size/2);
            compress(row, col+size/2, size/2);
            compress(row+size/2, col, size/2);
            compress(row+size/2, col+size/2, size/2);
            bw.write(")");
        }
    }

    public static boolean isSame(int row, int col, int size) {
        int pixel = img[row][col];
        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if (pixel != img[i][j]) return false;
            }
        }
        return true;
    }
}
