/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String x= preProcess(str1);
		String y=preProcess(str2);
		boolean Anagram = true;
		for(int i=0;i<x.length();i++){
			char ch = x.charAt(i);
			if((ch!= ' ') && (count(y,ch)!= count(x,ch))){
				return false;
			}
		}

		
		return Anagram;
	}
	public static int count(String str,char c){
		int count = 0;
		for(int i=0; i< str.length(); i++){
			if(str.charAt(i)== c){
			count++;
			}
		}
		return count;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String check = "";
		int length = str.length();
		int i =0;
		while(i<length){
			char ch = str.charAt(i);
			if((ch <= 90) && (ch >= 65)){
				ch += 32;
				check += ch;
			}
			else if((ch>= 97 && ch<=122) || ch == 32 ){
				check = check + ch;
			}
		i++;
		}	
		return check;
		}
		
	 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr= "";
		String help = str;
		String noRep = str;
		for(int i = 0; i < str.length(); i++){
			int index = (int)(Math.random()*(noRep.length()-1));
			char ch =noRep.charAt(index);
			newStr += ch;
			help = noRep;
			noRep = "";
			for(int j = 0; j < index; j++){
				noRep += help.charAt(j);
			}
			for(int x =(index+1); x < help.length(); x++){
				noRep += help.charAt(x);	
			}

			

		}
		return newStr;
	}
}
