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
    static void heapify(String[] arr, int size, int i){
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < size && arr[left].compareTo(arr[smallest]) < 0)
            smallest = left;
        if(right < size && arr[right].compareTo(arr[smallest]) < 0)
            smallest = right;
        if(smallest != i){
            String temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            
            heapify(arr,size, smallest);
        }
            
    }
    /* Build bottom up*/
    static void buildBottomUp(String[] heap, int index){
        
    }
    }
}
