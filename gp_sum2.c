#include <stdio.h>
#include <math.h>

int main() {
    float a, r, sum;
    int n;

    printf("Enter first term (a): ");
    scanf("%f", &a);

    printf("Enter common ratio (r): ");
    scanf("%f", &r);

    printf("Enter number of terms (n): ");
    scanf("%d", &n);

    if (r == 1)
        sum = a * n;
    else
        sum = a * (pow(r, n) - 1) / (r - 1);

    printf("Sum of the series = %f\n", sum);

    return 0;
}