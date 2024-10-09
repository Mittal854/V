#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

typedef struct
{
    int **mat;
    int N;
    int SRN;
    int K;
} Sudoku;

Sudoku *createSudoku(int N, int K)
{
    Sudoku *sudoku = (Sudoku *)malloc(sizeof(Sudoku));
    sudoku->N = N;
    sudoku->K = K;
    double SRNd = sqrt(N);
    sudoku->SRN = (int)SRNd;
    sudoku->mat = (int **)malloc(N * sizeof(int *));
    for (int i = 0; i < N; i++)
    {
        sudoku->mat[i] = (int *)malloc(N * sizeof(int));
        memset(sudoku->mat[i], 0, N * sizeof(int));
    }
    return sudoku;
}

void fillValues(Sudoku *sudoku);
void fillDiagonal(Sudoku *sudoku);
int unUsedInBox(Sudoku *sudoku, int rowStart, int colStart, int num);
void fillBox(Sudoku *sudoku, int row, int col);
int randomGenerator(int num);
int CheckIfSafe(Sudoku *sudoku, int i, int j, int num);
int unUsedInRow(Sudoku *sudoku, int i, int num);
int unUsedInCol(Sudoku *sudoku, int j, int num);
int fillRemaining(Sudoku *sudoku, int i, int j);
void removeKDigits(Sudoku *sudoku);
void printSudoku(Sudoku *sudoku);

void fillValues(Sudoku *sudoku)
{
    fillDiagonal(sudoku);
    fillRemaining(sudoku, 0, sudoku->SRN);
    removeKDigits(sudoku);
}

void fillDiagonal(Sudoku *sudoku)
{
    for (int i = 0; i < sudoku->N; i += sudoku->SRN)
        fillBox(sudoku, i, i);
}

int unUsedInBox(Sudoku *sudoku, int rowStart, int colStart, int num)
{
    for (int i = 0; i < sudoku->SRN; i++)
    {
        for (int j = 0; j < sudoku->SRN; j++)
        {
            if (sudoku->mat[rowStart + i][colStart + j] == num)
                return 0;
        }
    }
    return 1;
}

void fillBox(Sudoku *sudoku, int row, int col)
{
    int num;
    srand(time(NULL));
    for (int i = 0; i < sudoku->SRN; i++)
    {
        for (int j = 0; j < sudoku->SRN; j++)
        {
            do
            {
                num = randomGenerator(sudoku->N);
            } while (!unUsedInBox(sudoku, row, col, num));
            sudoku->mat[row + i][col + j] = num;
        }
    }
}

int randomGenerator(int num)
{
    return (int)floor((float)(rand() / (double)RAND_MAX * num + 1));
}

int CheckIfSafe(Sudoku *sudoku, int i, int j, int num)
{
    return (unUsedInRow(sudoku, i, num) && unUsedInCol(sudoku, j, num) && unUsedInBox(sudoku, i - i % sudoku->SRN, j - j % sudoku->SRN, num));
}

int unUsedInRow(Sudoku *sudoku, int i, int num)
{
    for (int j = 0; j < sudoku->N; j++)
    {
        if (sudoku->mat[i][j] == num)
            return 0;
    }
    return 1;
}

int unUsedInCol(Sudoku *sudoku, int j, int num)
{
    for (int i = 0; i < sudoku->N; i++)
    {
        if (sudoku->mat[i][j] == num)
            return 0;
    }
    return 1;
}

int fillRemaining(Sudoku *sudoku, int i, int j)
{
    if (j >= sudoku->N && i < sudoku->N - 1)
    {
        i = i + 1;
        j = 0;
    }
    if (i >= sudoku->N && j >= sudoku->N)
    {
        return 1;
    }
    if (i < sudoku->SRN)
    {
        if (j < sudoku->SRN)
            j = sudoku->SRN;
    }
    else if (i < sudoku->N - sudoku->SRN)
    {
        if (j == (int)(i / sudoku->SRN) * sudoku->SRN)
            j = j + sudoku->SRN;
    }
    else
    {
        if (j == sudoku->N - sudoku->SRN)
        {
            i = i + 1;
            j = 0;
            if (i >= sudoku->N)
                return 1;
        }
    }
    for (int num = 1; num <= sudoku->N; num++)
    {
        if (CheckIfSafe(sudoku, i, j, num))
        {
            sudoku->mat[i][j] = num;
            if (fillRemaining(sudoku, i, j + 1))
                return 1;
            sudoku->mat[i][j] = 0;
        }
    }
    return 0;
}

void removeKDigits(Sudoku *sudoku)
{
    int count = sudoku->K;
    while (count != 0)
    {
        int cellId = randomGenerator(sudoku->N * sudoku->N) - 1;
        int i = (cellId / sudoku->N);
        int j = cellId % sudoku->N;
        if (sudoku->mat[i][j] != 0)
        {
            count--;
            sudoku->mat[i][j] = 0;
        }
    }
}

bool FindUnassignedLocation(Sudoku *sudoku, int row, int col)
{
    if (row > 8 || col > 8)
        return false;
    if (row < 0 || col < 0)
        return false;
    if (sudoku->mat[row][col] == 0)
        return true;
    return false;
}

bool SolveSudoku(Sudoku *sudoku, int row, int col, int num)
{
    if (!FindUnassignedLocation(sudoku, row, col))
        return true;
    if (CheckIfSafe(sudoku, row, col, num))
    {
        sudoku->mat[row][col] = num;
        if (SolveSudoku(sudoku, row, col, num))
            return true;
    }
    return false;
}

// ---------------------------------------------------------------------------------------------------------------------

bool UsedInRow(Sudoku *sudoku, int row, int num)
{
    for (int col = 0; col < 9; col++)
        if (sudoku->mat[row][col] == num)
            return true;
    return false;
}

bool UsedInCol(Sudoku *sudoku, int col, int num)
{
    for (int row = 0; row < 9; row++)
        if (sudoku->mat[row][col] == num)
            return true;
    return false;
}

bool UsedInBox(Sudoku *sudoku, int boxStartRow, int boxStartCol, int num)
{
    for (int row = 0; row < 3; row++)
        for (int col = 0; col < 3; col++)
            if (sudoku->mat[row + boxStartRow][col + boxStartCol] == num)
                return true;
    return false;
}

bool isSafe(Sudoku *sudoku, int row, int col, int num)
{
    return !UsedInRow(sudoku, row, num) && !UsedInCol(sudoku, col, num) &&
           !UsedInBox(sudoku, row - row % 3, col - col % 3, num) &&
           sudoku->mat[row][col] == 0;
}

bool FindLocation(Sudoku *sudoku, int *row, int *col)
{
    for (*row = 0; *row < 9; (*row++))
        for (*col = 0; *col < 9; (*col++))
            if (sudoku->mat[*row][*col] == 0)
                return true;
    return false;
}

bool FullSolution(Sudoku *sudoku)
{
    int row, col;
    if (!FindLocation(sudoku, &row, &col))
        return true;
    for (int num = 1; num <= 9; num++)
    {
        if (isSafe(sudoku, row, col, num))
        {
            sudoku->mat[row][col] = num;
            if (FullSolution(sudoku))
                return true;
            sudoku->mat[row][col] = 0;
        }
    }
    return false;
}

// ---------------------------------------------------------------------------------------------------------------------

void printSudoku(Sudoku *sudoku)
{
    printf("  ");
    for (int i = 0; i < 9; i++)
    {
        if (i % 3 == 0)
            printf("  %d", i);
        else
            printf(" %d", i);
        if (i == 5 || i == 2)
            printf(" ");
    }
    printf("\n");

    for (int i = 0; i < sudoku->N; i++)
    {
        if (i % 3 == 0)
            printf("  -------------------------\n");
        for (int j = 0; j < sudoku->N; j++)
        {
            if (j == 0)
                printf("%d ", i);
            if (j % 3 == 0)
                printf("| %d ", sudoku->mat[i][j]);
            else if (j == 8)
                printf("%d |", sudoku->mat[i][j]);
            else
                printf("%d ", sudoku->mat[i][j]);
        }
        printf("\n");
    }
    printf("  -------------------------\n");
}

void func(Sudoku *sudoku)
{
    int op;
    // while(op!=1 && op!=2) {

    // }
    printf("\nOptions:\n1. Quit     2. See Solution\n");
    printf("Press '1' to quit and press '2' to see the solution\n");
    printf("Choose Option: ");
    scanf("%d", &op);
    printf("\n");
    switch (op)
    {
    case 1:
        printf("\nYou Quit. Game Over.\n");
        return;
    case 2:
        FullSolution(sudoku);
        printSudoku(sudoku);
        return;
    default:
        return;
    }
}

int main()
{
    int N = 9;
    int K = 0;
    int diff_mode;
    printf("Welcome to Sudoku!!\n\n");
    printf("Instructions:\nInput the row number, column number and the element you want to fill the particular cell with.\nYou can type '-1' to escape where you will be given the choice to either quit the game or see the solution.\n");

    // char ch;
    // printf("\nPress any key to continue");

    printf("\nModes:\n1. Easy\n2. Medium\n3. Hard\n");
    printf("Choose your mode: ");
    scanf("%d", &diff_mode);
    printf("\n");
    switch (diff_mode)
    {
    case 1:
        K = 20;
        break;
    case 2:
        K = 30;
        break;
    case 3:
        K = 40;
        break;
    default:
        printf("Wrong Input. Try again\n");
        break;
    }

    Sudoku *sudoku = createSudoku(N, K);
    fillValues(sudoku);
    printSudoku(sudoku);

    FullSolution(sudoku);
    printSudoku(sudoku);

    int lives = 5;
    int op;
    while (lives != 0 && K != 0)
    {
        int row, col, num;
        printf("\nEnter row number: ");
        scanf("%d", &row);

        if (row == -1)
        {
            func(sudoku);
            break;
        }

        printf("Enter column number: ");
        scanf("%d", &col);

        if (col == -1)
        {
            func(sudoku);
            break;
        }

        printf("Enter number: ");
        scanf("%d", &num);
        printf("\n");

        if (sudoku->mat[row][col] != 0)
        {
            printf("Cell not Empty. Try Again.\n\n");
            printSudoku(sudoku);
        }

        else
        {
            if (SolveSudoku(sudoku, row, col, num))
            {
                printSudoku(sudoku);
                K--;
                printf("\nLives Remaining: %d", lives);
                printf("\nCells Remaining: %d\n", K);
            }

            else
            {
                printf("\nWrong Input. Try Again\n");
                lives--;
                printf("Lives Left: %d\n", lives);
                printf("Cells Remaining: %d\n", K);
                printSudoku(sudoku);
            }
        }
    }

    for (int i = 0; i < N; i++)
    {
        free(sudoku->mat[i]);
    }
    free(sudoku->mat);
    free(sudoku);

    if (lives == 0)
        printf("\nYOU LOST. GAME OVER!\n");
    else if (K == 0)
        printf("\nYOU WON! CONGRATULATIONS!\n");
    else
        return 0;

    return 0;
}