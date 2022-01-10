package january.second.전투;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Youji {

    static boolean[][] check;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N,M,count;
    static int[] solution(int n, int m, char[][] arr){
        int answer[] = new int[2];
        N = n;
        M = m;
        check = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for(int j=0;j<n;j++){
                count = 0;
                if(!check[i][j]) {
                    DFS(arr, i, j, arr[i][j]);
                }
                if(arr[i][j] == 'W') {
                    answer[0] += Math.pow(count, 2);
                }
                else {
                    answer[1] += Math.pow(count, 2);
                }
            }
        }
        return answer;
    }

    //같은 팀일 경우에 순회
    public static void DFS(char[][] arr, int row, int col, char team) {

        if(arr[row][col] != team) return;
        if(check[row][col]) return;

        check[row][col] = true; //방문처리
        count++;
        for(int i=0;i<4;i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if(nextRow < 0 || nextRow >= M) continue;
            if(nextCol < 0 || nextCol >= N) continue;
            DFS(arr, nextRow, nextCol, team);
        }
    }


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int[] result = solution(n, m, arr);
        System.out.println(result[0]+" "+result[1]);
    }
}
