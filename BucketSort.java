import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BucketSort {

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
 
        double max = arr[0];
        double min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
 
        int bucketCount = n;
        ArrayList<Double>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }
 
        double range = max - min;
        for (int i = 0; i < n; i++) {
            int index;
            if (range == 0) {
                index = 0;
            } else {
                index = (int) (((arr[i] - min) / range) * (bucketCount - 1));
            }
            buckets[index].add(arr[i]);
        }
 
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);
        }
 
        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (double val : buckets[i]) {
                arr[k] = val;
                k++;
            }
        }
 
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sc.close();
    }

    
}
