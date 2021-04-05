package data;




import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Dictionary {

    Vocabularies EnVi;
    Vocabularies ViEn;
    String EnVi_fileName;
    String ViEn_fileName;

    public Dictionary(String EV_fileName, String VE_fileName) {
        EnVi_fileName = EV_fileName;
        ViEn_fileName = VE_fileName;
        
        EnVi = new Vocabularies(EnVi_fileName);
        EnVi.loadFromFile();
        ViEn = new Vocabularies(ViEn_fileName);
        ViEn.loadFromFile();
    }

    public LinkedList<String> translateViToEn(String word) {
        return ViEn.translate(word);
    }
    public LinkedList<String> translateEnToVi(String word) {
        return EnVi.translate(word);
    }
    
    public boolean addEnWord(String newWord, String synonym){
          return EnVi.add(newWord, synonym);
    }
    public boolean addVnWord(String newWord, String synonym){
        return ViEn.add(newWord, synonym);
    }
    public void addEVToVn_En(String newWord, String synonym){
        String[] tmp = synonym.split(",");
        for (int i = 0; i < tmp.length; i++) {
            ViEn.add(tmp[i].trim(), newWord);
        }
    }
    public void addVEToEn_Vn(String newWord, String synonym){
        String[] tmp = synonym.split(",");
        for (int i = 0; i < tmp.length; i++) {
            EnVi.add(tmp[i].trim(), newWord);
        }
    }
    
    // you add more methods .....
}
