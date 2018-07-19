import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//字符流的缓冲区
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException{

        //创建一个字符读取流流对象，和文件关联

        FileReader fr = new FileReader("e:/inputdemo.txt");

        //只要将需要被提高效率的流作为参数传递给缓冲区的构造函数即可
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        while (true){
            String s = br.readLine();

            if(s == null){
                break;
            }
            sb.append(s + "\n");
        }
        br.close();
        fr.close();
        System.out.println(sb);
    }
}
