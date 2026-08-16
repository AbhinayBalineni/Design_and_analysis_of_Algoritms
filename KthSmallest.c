#include <stdio.h>

void sort(int arr[], int n){
    int i, j, temp, swapped;
    for (i = 0; i < n - 1; i++){
        swapped = 0;
        for (j = 0; j < n - i - 1; j++){
            if (arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = 1;
            }
        }

        if (swapped == 0)
            break;
    }
}

int main()
{
    int arr[100], n, k, i;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter array elements:\n");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    printf("Enter k: ");
    scanf("%d", &k);
    if (k < 1 || k > n){
        printf("Invalid value of k.\n");
        return 0;
    }

    sort(arr, n);

    printf("\n%dth smallest element = %d\n", k, arr[k - 1]);

    return 0;
}