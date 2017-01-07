import java.io.*;
import java.util.*;

/**
 * BoomerangConstellations
 */
public class BoomerangConstellations {
    
    public static String fileName = "BoomerangConstellations";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName+".in"));
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(
            new FileWriter(fileName + ".txt")));
        int T = Integer.parseInt(in.readLine());
        for(int cn = 1; cn <= T; cn++){
            int N = Integer.parseInt(in.readLine());
            long [] x = new long[N];
            long [] y = new long[N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                x[i]= Long.parseLong(st.nextToken());
                y[i]= Long.parseLong(st.nextToken());
            }
            long ans = 0;
            for(int i=0; i<N; i++){
                HashMap<Long, Long> map = new HashMap<>();
                for(int j=0; j < N; j++){
                    long dist = (x[i]- x[j]) * (x[i]- x[j]) + (y[i]- y[j]) * (y[i]- y[j]);
                    if(dist != 0){
                        if(map.containsKey(dist)){
                            map.put(dist, map.get(dist) + 1);
                        } else {
                            map.put(dist, 1L);
                        }
                    }
                }
                for(long count : map.values()){
                    if(count > 1){
                        ans += count * (count - 1) / 2;
                    }
                }
            }
            out.printf("Case #%d: %d\n", cn, ans);
        }

        in.close();
        out.close();
    }
}