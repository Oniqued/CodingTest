package Recursion.Lotto;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static boolean[] visited;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Main m = new Main();
        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            arr = new int[k];
            visited = new boolean[k];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            m.dfs(0,0);
            m.bw.write('\n');
        }
        m.bw.flush();
        m.bw.close();
    }

    public void dfs(int begin, int cnt) throws IOException{
        if(cnt == 6){
            for(int i = 0; i < k; i++){
                if(visited[i]) bw.write(arr[i] + " ");
            }
            bw.write('\n');
            return;
        }

        for(int i = begin; i < k; i++){
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}