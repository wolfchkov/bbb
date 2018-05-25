import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.LongStream;

public class Solution {

    static final long PROCCES_TIME = 10;

    static class Server  {
        long time = Long.MIN_VALUE;
        long queue;


    }

    public static void main(String[] args) {
        String s = "1 5 5 9 20 21";
        long[] times = Arrays.stream(s.split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        Server[] servers = {new Server(), new Server(), new Server()};
        int[] sn = new int[times.length];
        for(int  i = 0; i < times.length; ++i) {
            sn[i] = nextServer(servers, times[i]);
            System.out.println(sn[i]);
        }
    }

    private static int nextServer(Server[] servers, long time) {
        long delta = time - servers[0].time;
        long queue = servers[0].queue;
        int index = 0;
        for(int s = 1; s < servers.length; ++s) {
            Server server = servers[s];
            long d = time - server.time;
            if (delta > d && ) {
                delta = d;
                server.time = time;
                index = s + 1;
            }
        }
        return index;
    }
}