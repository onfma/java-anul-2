import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class homework_lab1 {

    static boolean verificareStringToInt(String s)
    {
        // cod verificare si validare ca string ul este un nr int
        return true;
    }

    static void LatinSquare(int n)
    {
        int[][] mat = new int[n][n];

        // diagonala principala are 1
        // tot ce se afla desaupra diag principale in mat va fi crescator de la 2 la n
        // tot ce se afla sub diagonala principala va fi descrescator de la n la 2

        // constructie matrice
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i == j) mat[i][j] = 1; // daigonala principala
                if(i > j) mat[i][j] = n-(i-j)+1; // sub diag principala, descrescator
                if(i < j) mat[i][j] = j-i+1; // deasupra diag principala, crescator
            }
        }

        //afisare
        if (n < 30000)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++) System.out.print(mat[i][j] + " ");

                System.out.println();
            }
        }

    }

    public static void main(String []args) throws IOException
    {
        int n = -1;
        do{
            // citire
            System.out.print("n = ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String numberString = reader.readLine();


            // validare
            boolean verificareInt = verificareStringToInt(numberString); // verificare daca string ul este acc un int
            if(verificareInt)
            {
                n = Integer.parseInt(numberString);
                if (n < 2)
                {
                    System.out.println("eroare! numar prea mic introdus \nintroduceti un nr");
                    n = -1;
                }
            }
            else System.out.println("eroare! nu este variabila de tip int \nintroduceti un nr");

        }while(n == -1);

        if (n >= 30000)
        {
            long startTime = System.nanoTime();
            LatinSquare(n);
            long endTime = System.nanoTime();

            System.out.println("timpul de executie in nanosec: " + (endTime - startTime));
        }
        else LatinSquare(n);
    }
}
