#include <stdio.h>
 
void towerOfHanoi(int n, char from, char aux, char to) {
    if (n == 0)
        return;
    towerOfHanoi(n - 1, from, to, aux);
    printf("Move disk %d from %c to %c\n", n, from, to);
    towerOfHanoi(n - 1, aux, from, to);
}
 
int main() {
    int n;
    printf("Enter number of disks: ");
    scanf("%d", &n);
    printf("\nSequence of moves (Recursive):\n");
    towerOfHanoi(n, 'A', 'B', 'C');
    return 0;
}
