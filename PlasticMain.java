package PlasticConservation;

import java.io.*;
import java.util.*;
import java.math.*;

public class PlasticMain {
        public static void main(String[] args) throws IOException {
                int N = 3;
                Position[] positions = new Position[N];
                String[] coords0 = {"0", "0"};
                int x0 = Integer.parseInt(coords0[0]);
                int y0 = Integer.parseInt(coords0[1]);
                positions[0] = new Position(x0,y0);

                String[] coords1 = {"0", "3"};
                int x1 = Integer.parseInt(coords1[0]);
                int y1 = Integer.parseInt(coords1[1]);
                positions[1] = new Position(x1,y1);

                String[] coords2 = {"4", "0"};
                int x2 = Integer.parseInt(coords2[0]);
                int y2 = Integer.parseInt(coords2[1]);
                positions[2] = new Position(x2,y2);


                try {
                        // round result to three places to avoid cumulative rounding errors causing 'wrong result'
                        long res = (long)(1000.0*Plastic.min_cost(positions)+0.5);
                        System.out.println(String.valueOf(res/1000.0));
                } catch (Exception e) {
                        printException(e);
                }
        }

        private static void printException(Exception e) {
                StackTraceElement[] trace = e.getStackTrace();
                for (int i = 0; i < trace.length; ++i) {
                        if (trace[i].getClassName().equals("Solution")) {
                                System.err.println(e.getClass().getName()+" at file "+trace[i].getFileName()+" line "+trace[i].getLineNumber());
                                System.exit(1);
                        }
                }
                System.err.println(e.getClass().getName());
                System.exit(1);
        }
}
