import java.io.*;
import java.net.Socket;

//定义玩家类
public class Joueur {
    Socket joueur = null;
    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;
    String name;
    String mark;
    Joueur (Socket j){
        this.joueur = j;
        try {
            InputStream inputStream = j.getInputStream();
            this.dataInputStream = new DataInputStream(inputStream);
            OutputStream outputStream = j.getOutputStream();
            this.dataOutputStream = new DataOutputStream(outputStream);
        } catch (IOException e){
            System.err.println("Erreur ouverture des flux serveur");
            System.exit(1);
        }
    }
    void initJoueur(String name,String mark){
        this.name = name;
        this.mark = mark;
    }

    public DataInputStream datainput() {
        return dataInputStream;
    }

    public void setDataInputStream(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    public DataOutputStream dataoutput() {
        return dataOutputStream;
    }

    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }
}
