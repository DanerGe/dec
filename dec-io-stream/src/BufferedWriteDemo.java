import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//BufferedWriter示例：
public class BufferedWriteDemo {
    public static void main(String[] args) throws IOException{

        //创建一个字符写入流对象
        FileWriter fw = new FileWriter("e:/inputdemo.txt", true);

        //为了提高字符写入效率，加入了缓冲技术。
        //只要将需要被提高效率的流作为参数传递给缓冲区的构造函数即可
        BufferedWriter bw = new BufferedWriter(fw);

        //用到缓冲区就必须要刷新
        bw.newLine();
        //java提供了一个跨平台的换行符newLine();
        bw.write("//BufferedWriter示例：");

        //注意，关闭缓冲区就是在关闭缓冲中的流对象
        bw.close();

        fw.close();

    }
}
