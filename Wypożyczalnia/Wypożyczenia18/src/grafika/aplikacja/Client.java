package grafika.aplikacja;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public String address;
    public int port;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void send(String text) throws IOException {
        Socket socket = new Socket(address, port);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(text);

        out.close();
        socket.close();
    }
}
