package january.second.미로탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Youji2 {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static int Solution(int[][] ar, int n, int m){

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0); //row
        queue.add(0); //col

        while(!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();

            for(int i=0;i<4;i++){
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                if(nextRow < 0 || nextRow >= n) continue;
                if(nextCol < 0 || nextCol >= m) continue;
                if(ar[nextRow][nextCol] == 1 || ar[nextRow][nextCol] > ar[row][col] + 1){
                    queue.add(nextRow);
                    queue.add(nextCol);
                    ar[nextRow][nextCol] = ar[row][col] + 1;
                }
            }
        }
        return ar[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = in.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int ar[][] = new int[n][m];

        for(int i=0;i<n;i++) {
            String str = in.readLine();
            for(int j=0;j<m;j++) {
                ar[i][j] = str.charAt(j) - '0';
            }
        }

        int result = Solution(ar, n, m);
        System.out.println(result);

    }

}
