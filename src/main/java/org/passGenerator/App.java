package org.passGenerator;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A Password generator
 *
 */
public class App
{
    public static void main( String[] args )
    {
        char[] JavaCharArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', '%', '&', '-', '_'};

        Scanner sc = new Scanner(System.in);
        boolean valid = false;

        int passLength = 0;
        char hasSpecial;
        char hasNum;
        char hasCapital;

        do {
            valid = false;

            System.out.print( "Password size: " );
            if(sc.hasNextInt()){
                passLength = sc.nextInt();
                if(passLength < 4 || passLength > 256){
                    System.out.println( "Please answer only by numerical values between 4 and 256." );
                } else {
                    valid = true;
                }
            } else {
                System.out.println( "Please answer only by numerical values between 4 and 256." );
                sc.nextLine();
            }
        } while (!valid);


        do {
            valid = false;

            System.out.print( "Special characters? (y/n): " );
            hasSpecial = sc.next().charAt(0);

            if(hasSpecial == 'y' || hasSpecial == 'n'){
                valid = true;
            } else {
                System.out.println( "Please answer only by y or n." );
            }
        } while (!valid);

        do {
            valid = false;

            System.out.print( "Numerical characters? (y/n)." );
            hasNum = sc.next().charAt(0);

            if(hasNum == 'y' || hasNum == 'n'){
                valid = true;
            } else {
                System.out.println( "Please answer only by y or n: " );
            }
        } while (!valid);

        do {
            valid = false;

            System.out.print( "Capital letters? (y/n)." );
            hasCapital = sc.next().charAt(0);

            if(hasCapital == 'y' || hasCapital == 'n'){
                valid = true;
            } else {
                System.out.println( "Please answer only by y or n: " );
            }
        } while (!valid);


        ArrayList<String> chars = new ArrayList<String>();

        //storing lowercase
        for(int i = 0; i < 26; i++)
        {
            chars.add(Character.toString(JavaCharArray[i]));
        }

        if (hasCapital == 'y') {

            //storing uppercase
            for (int i = 26; i < 52; i++) {
                chars.add(Character.toString(JavaCharArray[i]));
            }
        }

        if (hasNum=='y') {

            //storing num
            for (int i = 52; i < 62; i++) {
                chars.add(Character.toString(JavaCharArray[i]));
            }
        }

        if (hasSpecial=='y') {
            //storing num
            for (int i = 62; i < JavaCharArray.length; i++) {
                chars.add(Character.toString(JavaCharArray[i]));
            }
        }

        Random random = new Random();

        ArrayList<String> password = new ArrayList<String>();
        for (int i=0; i<passLength; i++){
            password.add(chars.get(random.nextInt(chars.size())));
        }

        System.out.println("Passord: ");
        for (String c: password) {
            System.out.print(c);
        }
    }
}
