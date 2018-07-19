
// IO流上：概述、字符流、缓冲区(java基础)

// IO流简单来说就是Input和Output流，IO流主要是用来处理设备之间的数据传输，
// java对于数据的操作都是通过流实现，而java用于操作流的对象都在IO包中。

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDemo {
}

class FireWriteDemo{
    public static void main(String[] args) throws IOException{

        //创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
        //而且该文件会被创建到指定目录下。如果该目录有同名文件，那么该文件将被覆盖
        FileWriter fw = new FileWriter("E:\\InputDemo.txt");//目的是明确数据要存放的目的地。

        //调用write的方法将字符串写到流中
        fw.write("JAVA-IO很简单");

        //刷新流对象缓冲中的数据，将数据刷到目的地中
        fw.flush();

        //关闭流资源，但是关闭之前会刷新一次内部缓冲中的数据。当我们结束输入时候，必须close();
        fw.write("这句话不会出现在文本中");

        fw.close();
        //flush和close的区别：flush刷新后可以继续输入，close刷新后不能继续输入。
    }
}

//示例3：对已有文件的数据进行续写
class FileWriteDemo{

    public static void main(String[] args) throws IOException{
        //传递一个参数,代表不覆盖已有的数据。并在已有数据的末尾进行数据续写
        //true为不覆盖
        FileWriter fw = new FileWriter("E:/InputDemo.txt", true);

        //false为覆盖原有数据
//        FileWriter fw = new FileWriter("E:/InputDemo.txt", false);

        fw.write(" \n --这行字可以换行吗？");

        fw.close();
    }
}