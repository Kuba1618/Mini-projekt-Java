package grafika.aplikacja;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;

public class Server {

    private int port;
    private List texts;

    public Server(int port) {
        this.port = port;
        this.texts = new LinkedList();
    }

    public void run() throws IOException {
        try (var listener = new ServerSocket(port)) {
            System.out.println("The date server is running...");
            while (true) {
                try (var socket = listener.accept()) {
                    DataInputStream in = new DataInputStream(
                            new BufferedInputStream(socket.getInputStream()));

                    String cmd = in.readUTF();
                    System.out.println(cmd);
                    if(cmd.contains("set")) {
                    String text = in.readUTF();
                    System.out.println(text);
                    texts.add(text);
                    }
                    else if(cmd.contains("get")) {
                        PrintWriter pr = new PrintWriter(socket.getOutputStream());

                        for(int i = 0; i < texts.size(); i++) {
                            pr.println(texts.get(i));
                        }
                        pr.flush();
                        pr.close();
                    }
                    socket.close();
                    in.close();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5590);
        server.run();

    }
}