
/*      */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Random;
public class all_Sorting_algo_switch_case
{
    public static void main(String[] args)
    {
        // switch insertion, selection , bubble , merge , quick
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("***********************************");
        System.out.println("SWITCH CASE INSERTION, SELECTION, MERGE, QUICK, BUBBLE, HEAP \nENTER SIZE OF ARRAY : ");
        System.out.println("***********************************");

        // making array
        int size = scan.nextInt();
        int[]arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = rand.nextInt(100);
        }
        
        /*
        int[] arr = new int[]{1,2,3,4,8,7,9,5,6};
        int size  = arr.length;
        */

        // printing un-modified array 
        System.out.println("  ORIGINAL ARRAY IS: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nEnter \n1. INSERTION SORT \n2. SELECTION SORT \n3. MERGE SORT \n4. QUICK SORT \n5. BUBBLE SORT \n6. HEAP SORT \n");

        int ch = scan.nextInt();

        switch(ch){
            case 1: System.out.println("*** INSERTION SORT ***");
                    insertionSort(arr);
                    break;
            case 2: System.out.println("*** SELECTION SORT ***");
                    selectionSort(arr);
                    break;
            case 3: System.out.println("*** MERGE SORT ***");
                    mergeSort(arr, 0, arr.length-1);
                    break;
            case 4: System.out.println("*** QUICK SORT ***");
                    quickSort(arr, 0, arr.length-1);
                    break;
            case 5: System.out.println("*** BUBBLE SORT ***");
                    bubbleSort(arr);
                    break;
            case 6: System.out.println("*** HEAP SORT ***");
                    build_heap(arr);
                    heapSort(arr);
                    break;
            default: System.out.println("invalid input");
        }

        //quickSort(arr, 0, arr.length-1);

        //printing modified array 
        //System.out.println("\n  MODIFIED ARRAY : ");
        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }


    }

    static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j= i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++)
        {
            int min_index = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
            
        }
    }


    static void mergeSort(int[] arr, int beg, int end){
        if(beg<end){
            int mid = (beg+end)/2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, beg, mid, end);
        }
    }
    

    static void merge(int[] arr, int beg, int mid, int end){
        int i=beg, j=mid+1;
        int[] temp = new int[arr.length];
        int temp_index = beg;

        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[temp_index] = arr[i];
                i++;
            }
            else{
                temp[temp_index] = arr[j];
                j++;
            }
            temp_index++;
        }

        if(i>mid){
            while(j<=end){
                temp[temp_index] = arr[j];
                j++;
                temp_index++;
            }
        }
        else if(j>end){
            while(i<=mid){
                temp[temp_index] = arr[i];
                i++;
                temp_index++;
            }
        }

        int k=beg;
        while(k<temp_index){
            arr[k] = temp[k];
            k++;
        }
    }


    static void quickSort(int[] arr, int beg, int end){
        if(beg<end){
            int pi = partition(arr, beg, end);
            quickSort(arr, beg, pi-1);
            quickSort(arr, pi+1, end);
        }
    }


    static int partition(int[] arr, int beg, int end){
        int i=-1, j=0, pivot = arr[end];

        while(j<end){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        int temp2 = arr[end];
        arr[end] = arr[i+1];
        arr[i+1] = temp2;

        return i+1;
        
    }

    static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=1; j<(arr.length-i); j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void build_heap(int[] arr){
        int n = arr.length;
        for(int i=(n/2)-1; i>=0; i--){
            
            //calling function
            max_heapify(arr, n, i);
        }
    }
    
    static void max_heapify(int[] arr, int n,  int i){
        int l = 2*i+1; // left child's index
        int r = 2*i+2; // right child's index 
        int largest  = i;
        
        if(l<n && arr[l]>arr[i]){
            largest = l;
        }
        else{
            largest = i;
        }
        
        if(r<n && arr[r]>arr[largest]){
            largest = r;
        }
        
        if(largest != i){
            
            //swapping
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            
            //calling function
            max_heapify(arr, n, largest);
        }
        
    }
    

    
    static void heapSort(int[] arr){
        
        int size = arr.length;
        
        for(int i=size-1; i>=0; i--){
            
            //swapping
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            //calling function
            max_heapify(arr, i, 0);
        }
        
        
    }
}