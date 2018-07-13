package app.demo.utils;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;

public class OutOfMemeryTest {
    static ArrayList<Object> arrayList = new ArrayList<Object>();

    public static void main(String[] args) {
        int i = 0;
        try{
            while (true){
                System.out.println(i++);
                arrayList.add("1");
                arrayList.add("1");
                arrayList.add("1");
                arrayList.add("1");
                arrayList.add("1");
                arrayList.add("1");
                arrayList.add("1");
                arrayList.add("1");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
