int[,] CreatTDArray(int n, int m)
{
    int[,] array = new int[n, m];
    Random rnd = new Random();
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            array[i, j] = rnd.Next(10,99); 
        }
    }
    return array;
}

string PrintArray(int[,] a, string massage)
{
    for (int i = 0; i < a.GetLength(0); i++)
    {
        for (int j = 0; j < a.GetLength(1); j++)
        {
            Console.WriteLine($"Элемент {i+1}-ого столбца {massage}: {a[i, j]}");
        }
        Console.WriteLine();
    }
    return "1";
}

int[,] SortArray(int[,] a)
{
    int tmpArray = a[0,0];
    for (int i = 0; i < a.GetLength(0); i++)
    {
        for (int j = 0; j < a.GetLength(1); j++)
        {
            for (int k = 0; k < a.GetLength(0); k++)
            {
                for (int l = 0; l < a.GetLength(1); l++)
                {
                    if (a[i, j] > a[k,l])
                    {
                         tmpArray = a[k, l];
                         a[k, l] = a[i, j];
                         a[i, j] = tmpArray;
                    }
                }
            }
        }
    }
    return a;
}

Console.Write("Введите кол-во строк:");
int n = int.Parse(Console.ReadLine());
Console.Write("Введите кол-во солбцов:");
int m = int.Parse(Console.ReadLine());

PrintArray(CreatTDArray(n,m), "созданного массива");
PrintArray(SortArray(CreatTDArray(n,m)), "отсортированного по убыванию");r
