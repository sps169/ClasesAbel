import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int numComands = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader output;
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        ProcessBuilder pb1 = new ProcessBuilder();
        ProcessBuilder pb2 = new ProcessBuilder();
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
        pb1.redirectOutput(pb2.redirectInput());
        pb2.redirectOutput(outputFile);
        try {
            pb1.start();
            System.out.println("Process 1 started");
            process2 = pb2.start();
            System.out.println("Process 2 started");
        }catch (Exception e){
            System.err.println("Wrong command input: " + e.getMessage());
        }
        if (process2 != null)
            try {
                output = new BufferedReader(new InputStreamReader(process2.getInputStream()));
                System.out.println("Reading process 2 output");
                while(output.ready()) {
                    System.out.println(output.readLine());
                }
                input.close();
                output.close();
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }
}
