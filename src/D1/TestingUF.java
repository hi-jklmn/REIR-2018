package D1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.UF;

public class TestingUF {


    public static void main(String[] args) {

        TestingUF tuf = new TestingUF();

        int init = 1000, iter = 15, rep = 100;

        double last = 0.0;

        for (int i = 0; i < iter; i++) {
            int n = init * (int) Math.pow(2, i);

            tuf.repeatExperiment(n, rep);

            System.out.format("n=%-10d", n);
            System.out.format("(%d*2^%d)\t", init, i);
            System.out.format("rep=%d\t\t", rep);
            System.out.format("mean=%fs\t\t", tuf.getMean());
            System.out.format("stddev=%fs\t\t", tuf.getStddev());
            System.out.format("lg(ratio)=");
            if(last != 0.0) {
                System.out.format("%f", Math.log(tuf.getMean()/last)/Math.log(2));
            } else {
                System.out.format("N/A");
            }
            System.out.println();

            last = tuf.getMean();
        }
    }

    private double mean;
    private double stddev;

    public TestingUF() {
        mean = 0.0;
        stddev = 0.0;
    }

    public double tester(int n) {
        Stopwatch sw = new Stopwatch();

        UF uf = new UF(n);

        for (int i = 0; i < n; i++) {
            uf.union(StdRandom.uniform(n), StdRandom.uniform(n));
        }

        return sw.elapsedTime();
    }

    public void repeatExperiment(int n, int k) {
        double test[] = new double[k];

        for (int i = 0; i < k; i++) {
            test[i] = tester(n);
        }

        mean = StdStats.mean(test);
        stddev = StdStats.stddev(test);
    }

    public double getMean() {
        return mean;
    }

    public double getStddev() {
        return stddev;
    }
}
