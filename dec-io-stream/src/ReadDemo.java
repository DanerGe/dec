import java.io.FileReader;
import java.io.IOException;

//示例2：FileReader的reade()方法.
//
//要求：用单个字符和字符数组进行分别读取
public class ReadDemo {

    public static void main(String[] args) throws IOException {
        charset();
        System.out.println("===========");
        singleReader();
    }
    /*****************字符数组进行读取*********************/
    private static void charset() throws IOException{
        FileReader fr = new FileReader("e:/InputDemo.txt");
        char[] buf = new char[6];
        //将Denmo中的文件读取到buf数组中。
        int num = 0;
        while ((num = fr.read(buf))!= -1){
            //String(char[] value , int offest,int count) 分配一个新的String,包含从offest开始的count个字符
            sop(new String(buf , 0 ,num));
        }
        sop("\n");
        fr.close();
    }


    /*****************单个字母读取*************************/
    private static void singleReader() throws IOException{
        //创建一个文件读取流对象，和指定名称的文件关联。
        //要保证文件已经存在，否则会发生异常：FileNotFoundException
        FileReader fr = new FileReader("e:/InputDemo.txt");

        //如何调用读取流对象的read方法？
        //read()方法，一次读取一个字符，并且自动往下读。如果到达末尾则返回-1
        int ch = 0;
        while((ch = fr.read()) != -1){
            sop((char)ch);
//            sop(ch);
        }
        sop("\n");
        fr.close();
    }

    private static void sop(Object s) {
        System.out.println(s);
    }
}

