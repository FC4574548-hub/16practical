import java.io.*;
import java.util.*;

public class tryHeapsort {
    static String[] load(String filename) throws Exception {

        ArrayList<String> words = new ArrayList<>();
        Scanner s = new Scanner(new File(filename));

        while (s.hasNext()){
            String w = s.next();
            w = w.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!w.isEmpty())
                words.add(w);

        }
        s.close();;
        return words.toArray(new String[0]);

    }
    static void heapify(String[] arr, int n, int i){
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left].compareTo(arr[smallest]) < 0)
            smallest = left;
        if(right < n && arr[right].compareTo(arr[smallest]) < 0)
            smallest = right;
        if(smallest != i){
            String temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr,n, smallest);
        }

    }
    /* Build bottom up*/
    static void buildBottomUp(String[] arr){
        for (int i = arr.length/2 - 1; i >= 0; i++)
            heapify(arr, arr.length, i);


    }
    public static void insert(String[] arr, int index){
        int parent = (index - 1)/2;

        while (index > 0 && arr[index].compareTo(arr[parent]) < 0) {
            String temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
            index = parent;
            parent = (index - 1)/2;
        }
    }
    public static void buildTopDown(String[] arr){
        for (int i = 1; i < arr.length; i++)
            insert(arr, i);
    }
    public static void heapSort(String[] arr){
        for (int i = arr.length - 1; i > 0; i++ ){
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);

        }    }
    public static void main(String[] args){}
    

}
