package hw5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            for(;;) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(), StandardCharsets.UTF_8));


                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream());

                while (!reader.ready()) ;
                String [] a = reader.readLine().split("/");
                String [] b= a[1].split(" ");
                File stroke = new File("C:\\Users\\Asus ROG Strix Scar\\IdeaProjects\\hw5\\src\\main\\java\\www");
                FileReader fr = new FileReader("C:\\Users\\Asus ROG Strix Scar\\IdeaProjects\\hw5\\src\\main\\java\\www\\index.html");
                Scanner sc = new Scanner(fr);
                for (File file: stroke.listFiles()) {
                    if (b[0].equals(file.getName())){
                        writer.println("HTTP/1.1 200 OK");
                        writer.println("Content-Type: text/html; charset=utf-8");
                        writer.println();
                        writer.println(sc.nextLine());
                        writer.flush();
                        writer.println();
                        socket.close();
                    }
                    else {
                        System.out.println(file.getName());
                        writer.println("HTTP/1.1 404 OK");
                        writer.println("Content-Type: text/html; charset=utf-8");
                        writer.println();
                        writer.println("<h1>404 NOT FOUND </h1>");
                        writer.flush();
                        writer.println();
                        socket.close();
                    }

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
