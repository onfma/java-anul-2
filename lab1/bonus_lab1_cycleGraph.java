public class bonus_lab1_cycleGraph {
    static int[][] AdjacencyMatrixForCycleGraph(int n)
    {
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(Math.abs(i-j) == 1)
                {
                    // primul nod din graf
                    if(i == 0) {matrix[i][n-1] = 1;}
                    // ultimul nod in graf
                    else if(i == n-1) {matrix[i][0] = 1;}
                    // cazul general
                    matrix[i][j] = 1;
                }
                else if(matrix[i][j] != 1) matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    static int[][] MatrixPower(int[][] matrix, int dimension, int powNumber)
    {
        // TEORIE INMULTIRE MATRICI
        // linie din mat 1 se inmulteste si aduna cu coloana din mat 2, pe rand

        while(powNumber-- != 1)
        {
            int[][] matrixOfPower = new int[dimension][dimension];

            for(int iMat1=0; iMat1<dimension; iMat1++)
            {
                for(int jMat1=0; jMat1<dimension; jMat1++)
                {
                    for(int jMat2=0; jMat2<dimension; jMat2++)
                    {
                        for(int iMat2=0; iMat2<dimension; iMat2++)
                        {
                            matrixOfPower[jMat2][iMat1] += 1;
                        }
                    }
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args) {

        int n = 7;
        int[][] matrix1 = AdjacencyMatrixForCycleGraph(n);

        for(int i=0;i<n;i++) // afisare
        {
            for(int j=0;j<n;j++) System.out.print(matrix1[i][j] + " ");
            System.out.println();
        }
    }
}