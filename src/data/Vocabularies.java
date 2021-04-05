package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class Vocabularies extends WordInfo {

    TreeSet<WordInfo> list;
    String fileName;

    public Vocabularies(String filename) {
        super();
        list = new TreeSet<WordInfo>();
        this.fileName = filename;
    }

    public  TreeSet<WordInfo> getList() {
        return list;
    }

    public boolean add(String word, String synonym) {
        WordInfo tmp = checkWordExist(word);
        if (tmp != null) {
            returnSynonyms(synonym, tmp);                 
        } else {
            WordInfo w = new WordInfo(word, synonym);
            list.add(w);
        }
        saveToFile();
        return true;
    }

    void returnSynonyms(String synonym, WordInfo w) {
        String[] tmp = synonym.split(",");      
        for (String string : tmp) {              
            w.addSynonym(string.trim());
        }
    }

    public LinkedList<String> translate(String word) {
        WordInfo w = checkWordExist(word);
        if (w != null) {
            return w.getSynonyms();
        }
        return null;
    }

    public void saveToFile() {
        PrintWriter p = null;
        if (new File(fileName).exists()) {
            try {
                p = new PrintWriter(fileName);
                for (WordInfo string : list) {                    
                    p.println(string.toString().toLowerCase());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (p != null) {
                        p.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Can not found file.");
        }
    }

    public void loadFromFile() {
        if (fileName == null) {
            System.out.println("Null");
            return;
        }
        if (new File(fileName).exists()) {
            FileReader f = null;
            BufferedReader b = null;
            try {
                f = new FileReader(fileName);
                b = new BufferedReader(f);
                while (b.ready()) {
                    String[] tmp = b.readLine().split(":|,");
                    if (tmp.length >= 2) {
                        LinkedList<String> synonyms = new LinkedList();
                        for (int i = 1; i < tmp.length; i++) {
                            synonyms.add(tmp[i].trim());
                        }
                        WordInfo word = new WordInfo(tmp[0], synonyms);
                        list.add(word);
                    } else {
                        System.out.println("Not thing.");
                    }
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
            }
        } else {
            System.out.println("No file can be found.");
        }
    }

    WordInfo checkWordExist(String word) {
        word = word.toLowerCase();
        if (!list.isEmpty()) {
            for (WordInfo w : list) {
                if (w.getWord().equalsIgnoreCase(word) || w.getWord().indexOf(word) >= 0) {
                    return w;
                }
            }          
        }
        return null;
    }
}
