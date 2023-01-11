import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FatherProcessRuntime {
    public static void main(String[] args) {
        Process process;
        BufferedReader br;
        BufferedReader input;

        input = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (!input.readLine().equals("end")) {
                process = Runtime.getRuntime().exec("java src/ChildProcess.java");
                br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                br.lines().forEach(System.out::println);
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
