import edu.princeton.cs.algs4.Stopwatch;

public class Main {

    public static void main(String[] args) {

        Stopwatch time = new Stopwatch();

        for(int i = 0; i < 10000; i++) {
            System.out.println("woops");
        }

        System.out.println(time.elapsedTime());

    }

}
