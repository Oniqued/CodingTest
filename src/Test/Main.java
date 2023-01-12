//테스트 코드
package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        /*String str = br.readLine();
        st = new StringTokenizer(str);
        String a = st.nextToken();
        String b = st.nextToken();*/

        String tmp = br.readLine();
        st = new StringTokenizer(tmp);
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        String tmp1[] = tmp.split(" ");

        bw.write(tmp);

        /*String arr[] = str.split(" ");

        bw.write(str);*/
        bw.flush();
        bw.close();
    }
}
