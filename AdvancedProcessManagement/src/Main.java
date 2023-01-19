import java.io.*;

public class Main {
    public static void main(String[] args) {
        int numComands = 0;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        File inputFile = new File("input.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find input file");
        }
        ProcessBuilder pb1 = new ProcessBuilder();
        ProcessBuilder pb2 = new ProcessBuilder();
        Process process1 = null;
        Process process2 = null;
        while (numComands < 2) {
            String[] command = {};
            try {
                command = keyboard.readLine().split(" ");
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }
            if (numComands % 2 == 0){
                System.out.println("First command setup");
                pb1.command(command);
            } else {
                System.out.println("Second command setup");
                pb2.command(command);
            }
            numComands++;
        }
        try {
            keyboard.close();
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
            process1 = pb1.start();
            System.out.println("Process 1 started");
            process2 = pb2.start();
            System.out.println("Process 2 started");

            if (reader != null) {
                while (reader.ready()) {
                    process1.getOutputStream().write(reader.read());
                    System.out.print(".");
                }
                process1.getOutputStream().flush();
                System.out.println("\nFile read into process 1 input");
            }
            while (process1.getInputStream().available() > 0) {
                process2.getOutputStream().write(process1.getInputStream().read());
                System.out.print(".");
            }
            process2.getOutputStream().flush();
            System.out.println("\nProcess 1 wrote all bytes");
            System.out.println("\nProcess 2 output:\n");
            while (process2.getInputStream().available() > 0) {
                System.out.print((char)process2.getInputStream().read());
            }
            System.out.println();
        }catch (Exception e){
            System.err.println("Wrong command input: " + e.getMessage());
        }
    }
}
