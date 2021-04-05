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
         codeVN.put('a', "000");        codeVN.put('á', "001");        codeVN.put('à', "002");
        codeVN.put('ả', "003");        codeVN.put('ã', "004");        codeVN.put('ạ', "005");
        codeVN.put('ă', "006");        codeVN.put('ắ', "007");        codeVN.put('ằ', "008");
        codeVN.put('ẳ', "009");        codeVN.put('ẵ', "010");        codeVN.put('ặ', "011");
        codeVN.put('â', "012");        codeVN.put('ấ', "013");        codeVN.put('ầ', "014");
        codeVN.put('ẩ', "015");        codeVN.put('ẫ', "016");        codeVN.put('ậ', "017");
        codeVN.put('b', "018");        codeVN.put('c', "019");        codeVN.put('d', "020");
        codeVN.put('đ', "021");        codeVN.put('e', "022");        codeVN.put('é', "023");
        codeVN.put('è', "024");        codeVN.put('ẻ', "025");        codeVN.put('ẽ', "026");
        codeVN.put('ẹ', "027");        codeVN.put('ê', "028");        codeVN.put('ế', "029");
        codeVN.put('ề', "030");        codeVN.put('ể', "031");        codeVN.put('ễ', "032");
        codeVN.put('ệ', "033");        codeVN.put('f', "034");        codeVN.put('g', "035");
        codeVN.put('h', "036");        codeVN.put('i', "037");        codeVN.put('í', "038");
        codeVN.put('ì', "039");        codeVN.put('ỉ', "040");        codeVN.put('ĩ', "041");
        codeVN.put('ị', "042");        codeVN.put('j', "043");        codeVN.put('k', "044");
        codeVN.put('l', "045");        codeVN.put('m', "046");        codeVN.put('n', "047");
        codeVN.put('o', "048");        codeVN.put('ó', "049");        codeVN.put('ò', "050");
        codeVN.put('ỏ', "051");        codeVN.put('õ', "052");        codeVN.put('ọ', "053");
        codeVN.put('ô', "054");        codeVN.put('ố', "055");        codeVN.put('ồ', "056");
        codeVN.put('ổ', "057");        codeVN.put('ỗ', "058");        codeVN.put('ộ', "059");
        codeVN.put('ơ', "060");        codeVN.put('ớ', "061");        codeVN.put('ờ', "062");
        codeVN.put('ở', "063");        codeVN.put('ỡ', "064");        codeVN.put('ợ', "065");
        codeVN.put('p', "066");        codeVN.put('q', "067");        codeVN.put('r', "068");
        codeVN.put('s', "069");        codeVN.put('t', "070");        codeVN.put('u', "071");
        codeVN.put('ú', "072");        codeVN.put('ù', "073");        codeVN.put('ủ', "074");
        codeVN.put('ũ', "075");        codeVN.put('ụ', "076");        codeVN.put('ư', "077");
        codeVN.put('ứ', "078");        codeVN.put('ừ', "079");        codeVN.put('ử', "080");
        codeVN.put('ữ', "081");        codeVN.put('ự', "082");        codeVN.put('v', "083");
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