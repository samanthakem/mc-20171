package sort;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

	public class Mergesort	{

		private final static int VERSION = 1;
		
		public static void main(String[] args) {
			
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
	        
	        Integer[] values = new Integer[x.size()];
	        for(int i = 0; i < values.length; i++)
	        {
	        	values[i] = x.get(i); 
	        }

	        
			long start = System.currentTimeMillis();
			mergeSort(values);
			long elapsed = System.currentTimeMillis() - start;
			long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsed);
			System.out.format("%d,%d", seconds, VERSION);
		}

		public static void mergeSort(Comparable [ ] a) {
			Comparable[] tmp = new Comparable[a.length];
			mergeSort(a, tmp,  0,  a.length - 1);
		}


		private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right) {
			if( left < right ) {
				int center = (left + right) / 2;
				mergeSort(a, tmp, left, center);
				mergeSort(a, tmp, center + 1, right);
				merge(a, tmp, left, center + 1, right);
			}
		}


	    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd) {
	        int leftEnd = right - 1;
	        int k = left;
	        int num = rightEnd - left + 1;

	        while(left <= leftEnd && right <= rightEnd)
	            if(a[left].compareTo(a[right]) <= 0)
	                tmp[k++] = a[left++];
	            else
	                tmp[k++] = a[right++];

	        while(left <= leftEnd)    // copia o resto da primeira metade
	            tmp[k++] = a[left++];

	        while(right <= rightEnd)  // copia o resto da segunda metade
	            tmp[k++] = a[right++];

	        // Copy tmp back
	        for(int i = 0; i < num; i++, rightEnd--)
	            a[rightEnd] = tmp[rightEnd];
	    }
	 }

