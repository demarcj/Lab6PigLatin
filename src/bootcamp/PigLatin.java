package bootcamp;

import java.util.Scanner;

/**
 * Created by DeMarcj on 2/3/2017.
 */



public class PigLatin {
    public static void main(String[] args) {
        System.out.println("Welcome to the Pig Latin Translator");
        translator();
        System.out.println("Thanks for using our Pig Latin translator!");
    }

    public static void translator(){
        Scanner scan = new Scanner(System.in);
        String repeatTranslation = "y";
        while(repeatTranslation.equalsIgnoreCase("y")){
            System.out.println("Enter a line to be translated: ");
            String input = scan.nextLine();
            String[] inputSplit = input.toLowerCase().trim().split(" ");
            //This for loop will take the beginning consonants and put it at the end of the word
            for(String translation : inputSplit) {
                if(translation.startsWith("a")
                        || translation.startsWith("e")
                        || translation.startsWith("i")
                        || translation.startsWith("o")
                        || translation.startsWith("u")){
                    System.out.print(translation + "way ");
                } else{
                    System.out.print(translation.substring(findVowel(translation), translation.length())
                            + translation.substring(0, findVowel(translation))
                            + "ay ");
                }
            }
            System.out.println("");
            System.out.print("Translate another line? (y/n): ");
            repeatTranslation = scan.next();
            if(!repeatTranslation.equalsIgnoreCase("y")){
                scan.close();
            } else{
                input = scan.nextLine();
            }
        }
    }

    public static int findVowel(String vowel){

        int position = 0;


        //This loop is to return the vowel position as an int
        for(int i = 0; i < vowel.length(); i++){
            if('a' == vowel.charAt(i)
                    || 'e' == vowel.charAt(i)
                    || 'i' == vowel.charAt(i)
                    || 'o' == vowel.charAt(i)
                    || 'u' == vowel.charAt(i)){
                position = i;
                return position;
            }
        }
        return position;
    }
}
