
import data.Dictionary;
import data.Vocabularies;
import data.WordInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
//Class này dùng để test các functions, chạy chính ở package gui, class MainFrame
public class Test {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
////        writeListVn_En();
////          LinkedList<WordInfo> list = new LinkedList();
////        list.add("a");
////        list.add("b");
////        System.out.println("List: " + list.toString());
////          System.out.println("Quỳnh Anh".indexOf("Quỳnh"));
////        Dictionary d = new Dictionary("test.txt", "test2.txt");
////        d.addEnWord("meme", "hình chế", 0);
////        d.addEVToVn_En("meme", "hình chế,hình biến tấu", 1);
////        d.addVnWord("bánh quy", "cookie, bisquist", 1);
////        d.addVEToEn_Vn("bánh quy", "cookie, bisquist", 0);
////        d.addEVToVn_En("flat", synonym, 0);
////        Vocabularies v = new Vocabularies("test.txt");
////        v.loadFromFile();
////        v.add("fan", "cái quạt, người hâm mộ",1);
////        v.saveToFile();
////          WordInfo w= new WordInfo("đn","tre");
////          WordInfo w1 = new WordInfo("dn","táo");
////          list.add(w);
////          list.add(w1);
////          Collections.sort(list,WordInfo.byWord_VN);
////          System.out.println("List: " + list.toString());
//    }

    static Vector<String> returnListEn_Vn(String file) {
        if (new File(file).exists()) {
            Vector<String> listEn_Vn = new Vector();
            //Vector<String> listVn_En = new Vector();
            String[] tmp;
            FileReader f = null;
            BufferedReader b = null;
            try {
                f = new FileReader(file);
                b = new BufferedReader(f);
                while (b.ready()) {
                    tmp = b.readLine().split(":");
                    String tmpword = tmp[0].trim() + ":" + tmp[1].trim();
                    listEn_Vn.add(tmpword);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (f != null) {
                        f.close();
                    }
                    if (b != null) {
                        b.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Collections.sort(listEn_Vn);
                return listEn_Vn;
            }
        } else {
            System.out.println("No file can be found.");
            return null;
        }
    }

    static Vector<String> returnListVn_En(String file) {
        if (new File(file).exists()) {
            Vector<String> listVn_En = new Vector();
            String[] tmp;
            FileReader f = null;
            BufferedReader b = null;
            try {
                f = new FileReader(file);
                b = new BufferedReader(f);
                while (b.ready()) {
                    tmp = b.readLine().split(":");
                    String tmpword = tmp[1].trim() + ":" + tmp[0].trim();
                    //System.out.println("TMPword: " + tmpword);
                    listVn_En.add(tmpword);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (f != null) {
                        f.close();
                    }
                    if (b != null) {
                        b.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Collections.sort(listVn_En);
                return listVn_En;
            }
        } else {
            System.out.println("No file can be found.");
            return null;
        }
    }
    static void writeListVn_En(){
        String filename = "en_vn.txt";
        Vector<String> listVn_En = returnListEn_Vn("en_vn_2.txt");
        PrintWriter p = null;
        
            if(new File(filename).exists()){
                try {
                    p = new PrintWriter(filename);
                    for (String string : listVn_En) {
//                        if(string.indexOf(",") == 0) string = string.substring(1);
                        p.println(string.toLowerCase());
                    }
//                    p.print("Quỳnh");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    try {
                        if(p != null) p.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else{
                System.out.println("Can not found file.");
            }
         
    }

}
