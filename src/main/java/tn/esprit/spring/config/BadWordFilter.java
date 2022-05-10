
package tn.esprit.spring.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BadWordFilter {

 private static int largestWordLength = 0;

 private static Map<String, String[]> allBadWords = new HashMap<String, String[]>();

 public static String getCensoredText(final String input) {
 loadBadWords();
   if (input == null) {
     return "";
   }

   String modifiedInput1 = input;

   modifiedInput1 = modifiedInput1.replaceAll("1", "i").replaceAll("!", "i").replaceAll("3", "e").replaceAll("4", "a")
       .replaceAll("@", "a").replaceAll("5", "s").replaceAll("7", "t").replaceAll("0", "o").replaceAll("9", "g");

   modifiedInput1 = modifiedInput1.toLowerCase().replaceAll("[^a-zA-Z]", "");

   ArrayList<String> badWordsFound = new ArrayList<>();
   String[] list = modifiedInput1.split(" ");
   for (String modifiedInput : list)
   {
   for (int start = 0; start < modifiedInput.length(); start++) {
   
     for (int offset = 1; offset < (modifiedInput.length() + 1 - start) && offset < largestWordLength; offset++) {
       String wordToCheck = modifiedInput.substring(start, start + offset);
       if (allBadWords.containsKey(wordToCheck)) {
         String[] ignoreCheck = allBadWords.get(wordToCheck);
         boolean ignore = false;
         for (int stringIndex = 0; stringIndex < ignoreCheck.length; stringIndex++) {
           if (modifiedInput.contains(ignoreCheck[stringIndex])) {
             ignore = true;
             break;
           }
         }
         
         if (!ignore) {
           badWordsFound.add(wordToCheck);
         }
       }
     }
   }
   }
 
   return badWordsFound.toString();
 
   }

 private static void loadBadWords() {
   int readCounter = 0;
   try {
         
  BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://docs.google.com/spreadsheets/d/1r1j_bZ7CjcDiFWVeQrsuZ3oRwvppwGwczzf3mXEEwEo/export?format=csv").openConnection().getInputStream()));
     
     
     String currentLine = "";
     while ((currentLine = reader.readLine()) != null) {
       readCounter++;
       String[] content = null;
       try {
         if (1 == readCounter) {
           continue;
         }

         content = currentLine.split(",");
         if (content.length == 0) {
           continue;
         }

         final String word = content[0];

         if (word.startsWith("-----")) {
           continue;
         }

         if (word.length() > largestWordLength) {
           largestWordLength = word.length();
         }

         String[] ignore_in_combination_with_words = new String[] {};
         if (content.length > 1) {
           ignore_in_combination_with_words = content[1].split("_");
         }

         allBadWords.put(word.replaceAll(" ", "").toLowerCase(), ignore_in_combination_with_words);
       } catch (Exception except) {
       }
     }
   } catch (IOException except) {
   }
 }

}
