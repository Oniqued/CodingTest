//백준 : 트리 순회
package Recursion.BinaryTree;

import java.io.*;
import java.util.StringTokenizer;

class Node{
    String data;
    Node left;
    Node right;

    Node(String data){
        this.data = data;
    }
}

public class Main {
    public Node root;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Main m = new Main();

        int N = Integer.parseInt(m.br.readLine());
        String data, left, right;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(m.br.readLine());
            data = st.nextToken();
            left = st.nextToken();
            right = st.nextToken();
            m.createNode(data, left, right);
        }

        m.preOrder(m.root);
        m.bw.write("\n");
        m.inOrder(m.root);
        m.bw.write("\n");
        m.postOrder(m.root);

        m.bw.flush();
        m.bw.close();
    }

    public void createNode(String data, String leftData, String rightData){
        if(root == null) { //초기 상태라면
            root = new Node(data); //해당 루트 노드에 데이터 삽입
            if (!leftData.equals(".")) root.left = new Node(leftData); //왼쪽의 노드에 넣을 데이터가 있으면 노드 생성
            if (!rightData.equals(".")) root.right = new Node(rightData); //오른쪽의 노드에 넣을 데이터가 있으면 노드 생성
        }else{ //초기 상태가 아니면 해당 노드가 위치해야할 자리를 찾아야함
            searchNode(root, data, leftData, rightData);
        }

    }

    public void searchNode(Node node, String data, String leftData, String rightData){
        if(node == null) return; //내려왔는데 현 노드가 비어있다면 return
        else if(node.data.equals(data)) { //들어갈 위치를 찾는데 성공
            if(!leftData.equals(".")) node.left = new Node(leftData); //왼쪽 노드에 넣을 데이터가 있으면 노드 생성
            if(!rightData.equals(".")) node.right = new Node(rightData); //오른쪽 노드에 넣을 데이터가 있으면 노드 생성
        }else{ //들어갈 위치를 찾는다
            searchNode(node.left, data, leftData, rightData); //노드를 왼쪽으로 내려가면서 탐색
            searchNode(node.right, data, leftData, rightData); //왼쪽에 없으면 오른쪽으로 내려면서 탐색
        }
    }

    //전위 순회
    public void preOrder(Node node) throws IOException {
        if(node != null) {
            bw.write(node.data);
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }

    public void inOrder(Node node) throws IOException{
        if(node != null) {
            if(node.left != null) inOrder(node.left);
            bw.write(node.data);
            if(node.right != null) inOrder(node.right);
        }
    }

    public void postOrder(Node node) throws IOException{
        if(node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            bw.write(node.data);
        }
    }

}
