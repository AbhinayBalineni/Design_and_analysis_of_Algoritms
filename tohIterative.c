#include <stdio.h>

#define MAX 100

int a[MAX], b[MAX], c[MAX];
int topA = -1, topB = -1, topC = -1;

void push(int stack[], int *top, int value)
{
    stack[++(*top)] = value;
}

int pop(int stack[], int *top)
{
    return stack[(*top)--];
}

int peek(int stack[], int top)
{
    return stack[top];
}

int isEmpty(int top)
{
    return top == -1;
}

void move(int x[], int *topX, int y[], int *topY, char a, char b)
{
    int disk;

    if (isEmpty(*topX) ||
        (!isEmpty(*topY) && peek(x, *topX) > peek(y, *topY)))
    {
        disk = pop(y, topY);
        push(x, topX, disk);

        printf("Move %d from %c to %c\n", disk, b, a);
    }
    else
    {
        disk = pop(x, topX);
        push(y, topY, disk);

        printf("Move %d from %c to %c\n", disk, a, b);
    }
}

void hanoi(int n)
{
    int i;
    long long moves;

    for (i = n; i > 0; i--)
        push(a, &topA, i);

    moves = (1LL << n) - 1;

    for (i = 1; i <= moves; i++)
    {
        if (n % 2 == 1)
        {
            if (i % 3 == 1)
                move(a, &topA, c, &topC, 'A', 'C');

            else if (i % 3 == 2)
                move(a, &topA, b, &topB, 'A', 'B');

            else
                move(b, &topB, c, &topC, 'B', 'C');
        }
        else
        {
            if (i % 3 == 1)
                move(a, &topA, b, &topB, 'A', 'B');

            else if (i % 3 == 2)
                move(a, &topA, c, &topC, 'A', 'C');

            else
                move(b, &topB, c, &topC, 'B', 'C');
        }
    }
}

int main()
{
    int n;
    printf("enter the number of diskd: ");
    scanf("%d",&n);

    return 0;
}