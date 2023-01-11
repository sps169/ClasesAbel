import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FatherProcessProcessBuilder {
    public static void main(String[] args) {
        ProcessBuilder pb;
        Process process;
        BufferedReader br;
        BufferedReader input;

        input = new BufferedReader(new InputStreamReader(System.in));
        pb = new ProcessBuilder("java", "src/ChildProcess.java");
        try {
            while (!input.readLine().equals("end")) {
                process = pb.start();
                br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                br.lines().forEach(System.out::println);
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
