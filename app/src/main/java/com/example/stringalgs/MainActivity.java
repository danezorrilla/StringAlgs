package com.example.stringalgs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String reverseString(String s){
        String output = "";
        char[] charArray = s.toCharArray();
        for(int index = charArray.length - 1; index >= 0; index--){
            output = output + charArray[index];
        }
        return output;
    }

    private String duplicateChar(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();

        for (char c: charArray){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if (entry.getValue() > 1){
                return  entry.getKey() + " : " + entry.getValue();
            }
        }
        return "No Duplicate Chars";
    }

    private boolean areAnagrams(String s1, String s2){
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        String sortString1 = new String(charArray1);
        String sortString2 = new String(charArray2);
        return sortString1.equals(sortString2);
    }

    private void findPermutations(String s, String ans){
        if (s.length() == 0){
            System.out.println(ans + " ");
            return;
        }
        for (int index = 0; index < s.length(); index++){
            char ch = s.charAt(index);
            String ros = s.substring(0, index) + s.substring(index + 1);
            findPermutations(ros, ans + ch);
        }
    }

    private void reverseRecursion(String s){
        if((s==null)||s.length() <= 1){
            System.out.println(s);
        } else {
            System.out.print(s.charAt(s.length()-1));
            reverseRecursion(s.substring(0,s.length()-1));
        }
    }

    private void containsDigits(String s){
        for (int index = 0; index < s.length(); index++){
            if (!Character.isDigit(s.charAt(index))){
                System.out.println("String doesn't contain only digits");
            }
        }
        System.out.println("String contains only digit");
    }

    private void countVowelsAndCons(String s){
        String newString = s.toLowerCase();
        int vow = 0, con = 0;
        String ref = "aeiou";
        for(int index = 0; index < newString.length(); index++){
            if(newString.charAt(index) >= 'a' && newString.charAt(index) <= 'z'){
                if (ref.indexOf(newString.charAt(index)) != -1){
                    vow++;
                } else {
                    con++;
                }
            }
        }
        System.out.println("Number of Vowels: " + vow + "\nNumber of Consonants: " + con);
    }

    private void occurrenceCount(String s, Character ch){
        int count = 0;
        for(int index = 0; index < s.length(); index++){
            if (s.charAt(index) == ch){
                count++;
            }
        }
        System.out.println(count);
    }

    private void printNonRepeatedChar(String s){
        for(int index = 0; index < s.length(); index++){
            if (s.indexOf(s.charAt(index), s.indexOf(s.charAt(index)) + 1) == -1){
                System.out.println(s.charAt(index));
            }
        }
    }
}