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

void PrintArray(int[,] a)
{
    for (int i = 0; i < a.GetLength(0); i++)
    {
        for (int j = 0; j < a.GetLength(1); j++)
        {
            Console.WriteLine($"Элемент {j+1}-ого столбца: {a[i, j]}");
        }
        Console.WriteLine();
    }
}

int SumOfRow(int[,] a)
{
    int index = 0;
    int minSum = 0;
    for (int i = 0; i < a.GetLength(0); i++)
    {
        int sum = 0;
        for (int j = 0; j < a.GetLength(1); j++)
        {
            sum += a[i, j];
        }
        if (i == 0)
        {
            minSum = sum;
        }
        else if (sum < minSum)
        {
            index = i;
            minSum = sum;
        }
    }
    Console.WriteLine($"Строка с наименьшей суммой в массиве: {index+1}");
    return index;
}

Console.Write("Введите кол-во строк:");
int n = int.Parse(Console.ReadLine());
Console.Write("Введите кол-во солбцов:");
int m = int.Parse(Console.ReadLine());
Console.WriteLine();

PrintArray(CreatTDArray(n,m));
SumOfRow(CreatTDArray(n,m));
