import java.io.*;
import java.util.*;

public class 효율적인해킹 {

    private static ArrayList<Integer>[] A;

    private static boolean[] visited;

    private static int[] count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = new int[N + 1];

        for (int i=1;i<=N;i++) {
            A[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
        }

        for (int i=1;i<=N;i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int start = queue.poll();
                for (int next: A[start]) {
                    if (!visited[next]) {
                        count[next]++;
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        int max = 0;

        for (int i=1;i<=N;i++) {
            if (max<count[i]) {
                max = count[i];
            }
        }

        for (int i=1;i<=N;i++) {
            if (max == count[i]) {
                System.out.print(i+ " ");
            }
        }

    }


}
