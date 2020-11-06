import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;

public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        try (var listener = new ServerSocket(port)) {
            System.out.println("The date server is running...");
            while (true) {
                try (var socket = listener.accept()) {
                    DataInputStream in = new DataInputStream(
                            new BufferedInputStream(socket.getInputStream()));
                    String line = in.readUTF();
                    System.out.println(line);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5590);
        server.run();

    }
}
