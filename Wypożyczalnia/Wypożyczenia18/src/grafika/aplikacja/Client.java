package grafika.aplikacja;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

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
        out.writeUTF("set\n");
        out.writeUTF(text);

        out.close();
        socket.close();
    }

    public List read() throws IOException {
        List texts = new LinkedList();
        Socket socket = new Socket(address, port);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("get");

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        while(str!=null) {
            texts.add(str);
            str=bf.readLine();
        }
        out.close();
        in.close();
        bf.close();
        socket.close();

        return texts;
    }
}
