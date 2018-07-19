import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//将E盘的一个文件复制到D盘。
public class Test {
    //思考：
    //
    //其实就是将E盘下的文件数据存储到D盘的一个文件中。
    //
    //步骤：
    //
    //1.在D盘创建一个文件，存储F盘中文件的数据。
    //2.定义读取流和F：盘文件关联。
    //3.通过不断读写完成数据存储。
    //4.关闭资源。

    public static void main(String[] args) throws IOException {
        copyFile("e:/InputDemo.txt","d:/CopyNewFile.txt");
    }

    private static void copyFile(String sourcePath,String newPath) throws IOException{
        // 读取目录得数据
        StringBuffer sb = readerUtil(sourcePath);
        // 查看数据结果
        System.out.println(sb);
        // 创建一个输入流
        FileWriter fw = new FileWriter(newPath);
        // 将数据结果写入
        fw.write(sb.toString());
        // 关闭流
        fw.close();
    }

    private static StringBuffer readerUtil(String path) throws IOException{
        // 创建一个操作对象
        FileReader fr = new FileReader(path);
        // 创建一个读取到数据得载体
        StringBuffer sb = new StringBuffer();
        // -1说明文件已经读完
        int num ;
        while ((num = fr.read()) != -1){
            // 读取得数据加入到载体中
            // System.out.print((char)num);
//
            sb.append((char)num);
        }
        // 关闭流
        fr.close();
        return sb;
    }
}
