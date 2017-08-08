package sort;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Quicksort {
	
	private final static int VERSION = 1;
    
    public final static void main(String[] args) {
        String infile = args[0];
        List<Integer> x = new ArrayList<Integer>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(infile));
            String line = null;

            while ((line = br.readLine()) != null) {
              x.add(Integer.parseInt(line));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        
        int[] values = new int[x.size()];
        for(int i = 0; i < values.length; i++)
        {
        	values[i] = x.get(i); 
        }

		int low = 0;
		int high = values.length - 1;
		
		long start = System.currentTimeMillis();
		quickSort(values, low, high);
		long elapsed = System.currentTimeMillis() - start;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsed);
		System.out.format("%d,%d", seconds, VERSION);
    }

    public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}

}