import java.io.*;
import java.util.*;

public class tryHeapsort {
    public static String[] loadWords(String filename) throws Exception {

        ArrayList<String> list = new ArrayList<>();
        Scanner s = new Scanner(new File(filename));

        while (s.hasNext()){
            String w = s.next();
            w = w.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!w.equals("")) list.add(w);


        }
        s.close();
        return list.toArray(new String[0]);

    }
    public static void heapify(String[] arr, int n, int i){
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

    public static void buildBottomUp(String[] arr){
        for (int i = arr.length/2 - 1; i >= 0; i--)
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
        for (int i = arr.length - 1; i > 0; i-- ){
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);

        }    }
    public static void main(String[] args){
        try{
            String filename = "joyce1922_ulysses.text";
            String[] words = loadWords(filename);

            String[] a = Arrays.copyOf(words, words.length);
            long start1 = System.nanoTime();
            buildBottomUp(a);
            heapSort(a);
            long end1 = System.nanoTime();

            String[] b = Arrays.copyOf(words, words.length);
            long start2 = System.nanoTime();
            buildTopDown(b);
            heapSort(b);
            long end2 = System.nanoTime();

            System.out.println("Bottom up time: " + (end1 - start1));
            System.out.println("Top down time: " + (end2 - start2));

        }
        catch (Exception e){
            System.out.println("File error");

        }    }


}
