import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Server {
    private int port;
    public Server(int port){
        this.port = (port>=0)?port:-port;
    }

    public void start(){
        ServerSocket ss;

        try {
            ss = new ServerSocket(port);
            var s = ss.accept();
            var br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            var clientMessage = br.readLine();
            System.out.println("Клиент прислал: "+clientMessage);
            var pw = new PrintWriter(s.getOutputStream());
            pw.println("Привет в ответ!");
            pw.flush();
            ss.close();
        } catch (IOException e) {
            System.out.println("Ошибка: "+e.getMessage());
        }
    }
}
