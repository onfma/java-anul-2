import java.util.Random;
import java.utils.Arrays;
import java.io.*;

public class compulsory_lab1 {
 
    public static void main(String []args) {
       System.out.println("Hello World \n"); // prints Hello World

       String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
       System.out.println(languages);

       int n = (int) (Math.random() * 1_000_000);
       System.out.println("\n" + n + "\n");
       
       
       n*=3;
       System.out.println(n + "\n");

       int x1 = Integer.parseInt("10101", 2);
       n+=x1;
       System.out.println(n + "\n");

       int x2 = Integer.parseInt("FF", 16);
       n+=x2;
       System.out.println(n + "\n");

       n*=6;
       System.out.println(n + "\n");

       while(n>10)
       {
        int digit_sum =0;
        while(n>9)
        {
            digit_sum += n%10;
            n/=10;
        }
        digit_sum += n;
        n = digit_sum;
       }

       System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }

    

 }