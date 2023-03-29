import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private int port;
    private String host;

    public Client(String host, int port){
        this.host = host;
        this.port = (port>=0)?port:-port;
    }

    public void start(){
        Socket s;
        try {
            s = new Socket(host, port);
            var pw = new PrintWriter(s.getOutputStream());
            pw.println("Привет!");
            pw.flush();
            var br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            var serverMessage = br.readLine();
            System.out.println("Сервер ответил: "+serverMessage);
            s.close();
        } catch (IOException e) {
            System.out.println("Ошибка: "+e.getMessage());
        }
    }
}
