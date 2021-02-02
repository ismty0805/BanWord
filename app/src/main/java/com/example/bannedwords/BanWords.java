package com.example.bannedwords;

import java.util.ArrayList;

public class BanWords {
    private static ArrayList<String> BanWords = new ArrayList<>();

    public static ArrayList<String> getBanWords() {
        return BanWords;
    }

    public void setBanWords(ArrayList<String> banWords) {
        BanWords = banWords;
    }

    public static String inBanWords(String sentence){
        for (int i=0; i<BanWords.size(); i++){
            if (sentence.contains(BanWords.get(i))){
                return BanWords.get(i);
            }
        }
        return null;
    }

    public static Boolean addBanWord(String word){
        if(BanWords.contains(word)){
            return false;
        }
        else{
            BanWords.add(word);
            return true;
        }
    }
}
