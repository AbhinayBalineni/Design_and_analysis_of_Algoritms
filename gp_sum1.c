#include <stdio.h>

int main(){
    int n, i;
    double a, r, sum = 0, term;

    printf("Enter first term (a): ");
    scanf("%lf", &a);

    printf("Enter common ratio (r): ");
    scanf("%lf", &r);

    printf("Enter number of terms (n): ");
    scanf("%d", &n);

    term = a;

    for (i = 0; i < n; i++){
        sum += term;
        term *= r;
    }

    printf("Sum = %.2lf\n", sum);

    return 0;
}