import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class RandomCode {

    ArrayList <String> LIST_OF_CODES = new ArrayList<>();

    int randI1, randI2, randI3;
    String UpperC [] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String SpecialC [] = {"!", "#", "$", "@", "%"};
    String resCode = "";

    Random random =  new Random();
    int MIN = 0;
    int MAX1 = 26;
    int MAX2 = 5;

    RandomCode() { // Default Constructor...

    }

    public String generateCode(int numOfletters)
    {
        resCode = " ";
        int counter = 0; //counter to know when to exit...
        while(true)
         {
             randI1 = (int)Math.floor(Math.random()*(MAX1-MIN-1)+MIN); //random for the letters UPPER
             resCode = resCode + UpperC[randI1];
             counter++;

             if(counter >= numOfletters)
             {
                 if(checkIfExist() == true)
                 {
                     System.out.println("--FOUND A SAME CODE, WE WILL TRY AGAIN GENERATED --> CODE --> " + resCode);
                     resCode = " ";
                     continue;
                 }
                 else
                 {
                     LIST_OF_CODES.add(resCode); //add to the list the code generated
                     break;
                 }
             }


             randI2 = (int)Math.floor(Math.random()*(MAX1-MIN-1)+MIN); //random for the letters LOWER
             resCode = resCode + (UpperC[randI2].toLowerCase());
             counter++;

             if(counter >= numOfletters)
             {
                 if(checkIfExist() == true)
                 {
                     System.out.println("--FOUND A SAME CODE, WE WILL TRY AGAIN GENERATED --> CODE --> " + resCode);
                     resCode = " ";
                     continue;
                 }
                 else
                 {
                     LIST_OF_CODES.add(resCode); //add to the list the code generated
                     break;
                 }
             }

             randI3 = (int)Math.floor(Math.random()*(MAX2-MIN-1)+MIN); //random for the letters SPECIAL
             resCode = resCode + SpecialC[randI3];
             counter++;

             if(counter >= numOfletters)
             {
                 if(checkIfExist() == true)
                 {
                     System.out.println("--FOUND A SAME CODE, WE WILL TRY AGAIN GENERATED --> CODE --> " + resCode);
                     resCode = " ";
                     continue;
                 }
                 else
                 {
                     LIST_OF_CODES.add(resCode); //add to the list the code generated
                     break;
                 }
             }
         }
        numOfletters = 0;
        return resCode;
    }

    public boolean checkIfExist()
    {
        for(int i=0;i < LIST_OF_CODES.size();i++)
        {
            if(LIST_OF_CODES.get(i).equals(resCode))
            {
                return true;
            }
        }
        return false;
    }
}
