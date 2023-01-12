package AsciiCode;

//백준 : 11654번 - [기본]아스키 코드
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int ascii = input.charAt(0);
        System.out.println(ascii);
        sc.close();
    }
}
