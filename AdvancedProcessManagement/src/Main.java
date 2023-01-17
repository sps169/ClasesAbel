import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int numComands = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        File inputFile = new File("input.txt");
        ProcessBuilder pb1 = new ProcessBuilder();
        ProcessBuilder pb2 = new ProcessBuilder();
        Process process1 = null;
        Process process2 = null;
        while (numComands < 2) {
            String[] command = {};
            try {
                command = input.readLine().trim().split(" ");
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }
            if (numComands % 2 == 0){
                pb1.command(command);
            } else {
                pb2.command(command);
            }
            numComands++;
        }
        try {
            input.close();
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
        pb1.redirectInput(inputFile);
        pb2.redirectInput(pb1.redirectOutput());
        try {
            process1 = pb1.start();
            while (process1.isAlive())
                Thread.sleep(10);
            process2 = pb2.start();
        }catch (Exception e){
            System.err.println("Wrong command input: " + e.getMessage());
        }
        if (process2 != null)
            try {
                StringBuilder builder = new StringBuilder();
                while(process2.getInputStream().read() != 0) {
                    builder.append(process2.getInputStream().read());
                }
                System.out.println(builder);
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }
}
