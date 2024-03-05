package io.zipcoder;


import java.util.Arrays;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case-sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */

    // Create a counter
    // Split input into words
    // Iterate of array of words
    // Check if last index of each word ends in y, Y, z, or Z
    // If so increase counter
    public Integer countYZ(String input){
        int total = 0;
        String[] word_array = input.split(" ");
        for(String i: word_array){
            int checked_index = i.length() - 1;
            if(i.charAt(checked_index) == 'y' || i.charAt(checked_index) == 'Y'
                    || i.charAt(checked_index) == 'z' || i.charAt(checked_index) == 'Z'){
                total += 1;
            }
        }
        return total;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case-sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */

    // Call replace all and replace with empty string
    public String removeString(String base, String remove){
        return base.replaceAll(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */

    /*
    Create a counter for is and not
    Create an index counter for is and not
    While index isn't -1 (thus a new index for the substring was found)
        Search for new index of is between index and end of string
        if new index found (Index != -1)
            increase is counter
            increase index  ( Allows us to not get the same substring index every time)

     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int countIs = 0;
        int countNot = 0;
        int index = 0;
        while(index != -1){
            index = input.indexOf("is", index);
            if(index != -1) {
                // ASSERT: No more is substrings were found
                countIs++;
                index++; // Stops from searching the same area infinitely
            }
        }
        int isIndex = 0;
        while(isIndex != -1){
            isIndex = input.indexOf("not", isIndex);
            if(isIndex != -1) {
                // ASSERT: No more not substrings were found
                countNot++;
                isIndex++;
            }
        }

        return countIs == countNot;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return false
     */

    /*
    Turn input into a charArray
    iterate through the array checking if each character is a 'g'
    if there is a g then check if there is a g to the left or right
    if not return false
    else continue
    if end of loop then return true
     */
    public Boolean gIsHappy(String input){
        char[] inputArray = input.toCharArray();
        // boolean isHappy = true;
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i] == 'g'){
                if(inputArray[i + 1] != 'g' && inputArray[i - 1] != 'g'){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            if(i + 2 <= input.length()) {
                if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2)) {
                    count++;
                }
            }
        }
        return count;
    }
}
