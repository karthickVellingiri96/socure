package interview.socure;

import java.util.*;

public class Solution {
    
    // Function to get the strings in sorted order by their length
    public String sortStringBasedOnLength(String input){
        //return empty string if the length of the input is 0
        if(input.length() == 0){
            return "";
        }
        
        String[] splitStrings =  input.split(" ");
        
        //return the same input if the length of the input is 1
        if(splitStrings.length == 1){
            return input;
        }
        
        List<String> output = sortStrings(Arrays.asList(splitStrings));
        String outputStr = String.join(" ", output);
        return outputStr;
    }
    
    private List<String> sortStrings(List<String> arr) {
        
        // Sorting the List based on string length
        Collections.sort(arr, Comparator.comparingInt(String::length));
        
        int length = arr.get(0).length();
        List<String> stringsWithSameLength = new ArrayList<>();
        List<String> output = new ArrayList<>();
        
        // split the strings based on length and sort in Lexicographical order
        for(String str : arr){
            if(length == str.length()){
                stringsWithSameLength.add(str);
            }else{
                sortWordsInSameLength(output, stringsWithSameLength);
                length = str.length();
                stringsWithSameLength.clear();
                stringsWithSameLength.add(str);
            }
        }
        
        if(stringsWithSameLength.size()>0){
            sortWordsInSameLength(output, stringsWithSameLength);
        }
        
        return output;
    }
    
    private void sortWordsInSameLength(List<String> output, List<String>  stringsWithSameLength){
        String[] stringArraysWithSameLength = new String[stringsWithSameLength.size()];
        int i=0;
        for (String x : stringsWithSameLength){
            stringArraysWithSameLength[i++] = x;
        }
        output.addAll(Arrays.asList(sortLexicographical(stringArraysWithSameLength)));
    }
    
    
    // Sorting the array based on Lexicographical order
    private String[] sortLexicographical(String[] strArr){
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if (strArr[i].compareToIgnoreCase(strArr[j])
                        > 0) {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;
                }
            }
        }
        return strArr;
    }
    
    

}
