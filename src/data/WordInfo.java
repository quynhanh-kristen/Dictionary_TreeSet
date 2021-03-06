package data;
import java.util.HashMap;
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
public class WordInfo implements Comparable<WordInfo>{

    String word;
    LinkedList<String> synonyms;

    public WordInfo() {
        synonyms = new LinkedList<String>();
    }
    public WordInfo(String NewWord) {
        word = NewWord;
    }

    public WordInfo(String NewWord, String synonym) {
        word = NewWord;
        synonyms = new LinkedList<String>();
        synonyms.add(synonym);
    }

    public WordInfo(String word, LinkedList<String> synonyms) {
        this.word = word;
        this.synonyms = synonyms;
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public LinkedList<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(LinkedList<String> synonyms) {
        this.synonyms = synonyms;
    }

    
    public boolean contains(String synonym) {
        if (this.synonyms.contains(synonym)) {
            return true;
        }
        return false;
    }

    public boolean addSynonym(String synonym) {
        if (this.getSynonyms().contains(synonym)) {
            return false;
        }
        return this.getSynonyms().add(synonym);
    }
	
//	@Override
//	public boolean equals()
//	{
//		
//	}

    @Override
    public String toString() {
        return word + ":" + formatSynonyms();

    }
    
    String formatSynonyms(){
        if(!synonyms.isEmpty()){
            String tmp = this.getSynonyms().get(0);
            if(this.getSynonyms().size() >= 1){
                for (String synonym : this.synonyms) {
                    if(tmp.indexOf(synonym) < 0) tmp = (tmp + "," + synonym).trim();
                }
                return tmp;
            }                  
        }
        return this.getSynonyms().get(0);   
    }

    @Override
    public int compareTo(WordInfo o) {
        vnDic v = new vnDic();
        return v.generator(this.word).compareToIgnoreCase(v.generator(o.word));
    }
}

class vnDic{    
    private HashMap<Character, String> codeVN = new HashMap<>();

    public vnDic() {
        createCode();
    }    
    private void createCode(){
         codeVN.put('a', "000");        codeVN.put('??', "001");        codeVN.put('??', "002");
        codeVN.put('???', "003");        codeVN.put('??', "004");        codeVN.put('???', "005");
        codeVN.put('??', "006");        codeVN.put('???', "007");        codeVN.put('???', "008");
        codeVN.put('???', "009");        codeVN.put('???', "010");        codeVN.put('???', "011");
        codeVN.put('??', "012");        codeVN.put('???', "013");        codeVN.put('???', "014");
        codeVN.put('???', "015");        codeVN.put('???', "016");        codeVN.put('???', "017");
        codeVN.put('b', "018");        codeVN.put('c', "019");        codeVN.put('d', "020");
        codeVN.put('??', "021");        codeVN.put('e', "022");        codeVN.put('??', "023");
        codeVN.put('??', "024");        codeVN.put('???', "025");        codeVN.put('???', "026");
        codeVN.put('???', "027");        codeVN.put('??', "028");        codeVN.put('???', "029");
        codeVN.put('???', "030");        codeVN.put('???', "031");        codeVN.put('???', "032");
        codeVN.put('???', "033");        codeVN.put('f', "034");        codeVN.put('g', "035");
        codeVN.put('h', "036");        codeVN.put('i', "037");        codeVN.put('??', "038");
        codeVN.put('??', "039");        codeVN.put('???', "040");        codeVN.put('??', "041");
        codeVN.put('???', "042");        codeVN.put('j', "043");        codeVN.put('k', "044");
        codeVN.put('l', "045");        codeVN.put('m', "046");        codeVN.put('n', "047");
        codeVN.put('o', "048");        codeVN.put('??', "049");        codeVN.put('??', "050");
        codeVN.put('???', "051");        codeVN.put('??', "052");        codeVN.put('???', "053");
        codeVN.put('??', "054");        codeVN.put('???', "055");        codeVN.put('???', "056");
        codeVN.put('???', "057");        codeVN.put('???', "058");        codeVN.put('???', "059");
        codeVN.put('??', "060");        codeVN.put('???', "061");        codeVN.put('???', "062");
        codeVN.put('???', "063");        codeVN.put('???', "064");        codeVN.put('???', "065");
        codeVN.put('p', "066");        codeVN.put('q', "067");        codeVN.put('r', "068");
        codeVN.put('s', "069");        codeVN.put('t', "070");        codeVN.put('u', "071");
        codeVN.put('??', "072");        codeVN.put('??', "073");        codeVN.put('???', "074");
        codeVN.put('??', "075");        codeVN.put('???', "076");        codeVN.put('??', "077");
        codeVN.put('???', "078");        codeVN.put('???', "079");        codeVN.put('???', "080");
        codeVN.put('???', "081");        codeVN.put('???', "082");        codeVN.put('v', "083");
        codeVN.put('x', "084");        codeVN.put('y', "085");        codeVN.put('z', "086");
        codeVN.put(' ', "087");        codeVN.put('-', "088");        codeVN.put('/', "089");
        codeVN.put('0', "090");        codeVN.put('1', "091");        codeVN.put('2', "092");
        codeVN.put('3', "093");        codeVN.put('4', "094");        codeVN.put('5', "095");
        codeVN.put('6', "096");        codeVN.put('7', "097");        codeVN.put('8', "098");
        codeVN.put('9', "099");      

    }
    
    public String generator(String input) {
        StringBuilder result = new StringBuilder();
        char[] b = input.toLowerCase().toCharArray();
        for (int i = 0; i < b.length; i++) {
            result.append(codeVN.get(b[i]));
        }
        return result.toString();
    }
    
}