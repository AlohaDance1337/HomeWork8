int[,] CreatTDArray(int n, int m)
{
    int[,] array = new int[n, m];
    Random rnd = new Random();
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            array[i, j] = rnd.Next(0,9); 
        }
    }
    return array;
}

void PrintArray(int[,] a, string message)
{
    for (int i = 0; i < a.GetLength(0); i++)
    {
        for (int j = 0; j < a.GetLength(1); j++)
        {
            Console.WriteLine($"Элемент {j+1}-ого столбца {message}: {a[i, j]}");
        }
        Console.WriteLine();
    }
}

int[,] MatrixMul(int[,] a, int[,] b)
{
    int[,] tmp = new int[a.GetLength(0), b.GetLength(1)];
    if ((a.GetLength(0) != b.GetLength(1)))
    throw new Exception("Матрици нельзая перемножить");
    for (int i = 0; i < a.GetLength(0); i++)
    {
        for (int j = 0; j < b.GetLength(1); j++)
        {
            for (int k = 0; k < b.GetLength(0); k++)
            {
                    tmp[i, j] = a[i, k] * b[k, j];
            }
        }
    }
    return tmp;
}

Console.Write("Введите кол-во строк первой матрици:");
int n = int.Parse(Console.ReadLine());
Console.Write("Введите кол-во солбцов первой матрици:");
int m = int.Parse(Console.ReadLine());
Console.WriteLine();

Console.Write("Введите кол-во строк второй матрици:");
int k = int.Parse(Console.ReadLine());
Console.Write("Введите кол-во солбцов второй матрици:");
int l = int.Parse(Console.ReadLine());
Console.WriteLine();

PrintArray(CreatTDArray(n, m), "перовой матрици");
PrintArray(CreatTDArray(k, l), "второй матрици");
PrintArray(MatrixMul(CreatTDArray(n,m), CreatTDArray(k,l)), "перемнодинная матрица");
