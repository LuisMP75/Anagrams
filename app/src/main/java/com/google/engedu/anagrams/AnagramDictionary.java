/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    public ArrayList<String> wordList = new ArrayList<>();
    public Mashset <String> wordset =  new HashSet();
    public HashMap <String, ArrayList<String>> lettersToWord = new HashMap();



    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();

            // Adds word at every loop
            wordList.add(word);
            // pre sorts words to check
            String sortedWord = sortLetters(word);
            // checks tosee if sorted word is in the hashmap and if so add value

            if (lettersToWord.containsKey(sortedWord)) {
                lettersToWord.get(sortedWord).add(word);
            }
            // if not add the value ad the key
            else {
                ArrayList<String> temp = new ArrayList();
                temp.add(word);
                lettersToWord.put(sortedWord, temp);
            }
        }
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }

    public List<String> getAnagrams(String targetWord) {

        ArrayList<String> result = new ArrayList<String>();

        //sort given word in alphabetical
        String sortedTargetWord = sortLetter(targetWord);

        // words were compared
        for (String word:wordList ){
            String SortedWord = sortLetter(word);

            if (sortedWord.equals(sortedTargetWord)){

                result.add(word);
            }

        }




        return result;

    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }

    public String sortLetters(String word){
        char [] words = word.toCharArray();
        Arrays.sort(word);
        return new String(word);
    }
}
