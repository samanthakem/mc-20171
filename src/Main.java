package src;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

	private static String sortMethod;
	private static File inputFile;
	private static File outputFile;
	private static int[] array;
	private static Sortable sortable;
	private final static String QUICKSORT = "quicksort";
	private final static String MERGESORT = "mergesort";
	private final static String HEAPSORT = "heapsort";

	public final static void main(String[] args) {
		
		sortMethod = args[0];
		inputFile = new File(args[1]);
		outputFile = new File(args[2]);
		
		array = getArrayFromFile(inputFile);
		
		if (sortMethod.equals(QUICKSORT)) {
			sortable = new Quicksort();
		} else if (sortMethod.equals(HEAPSORT)) {
			sortable = new Heapsort();
		} else if (sortMethod.equals(MERGESORT)) {
			sortable = new Mergesort();
		} else {
			throw new IllegalArgumentException("Invalid sorting method!");
		}
		
		long start = System.currentTimeMillis();
		sortable.sort(array);
		long elapsed = System.currentTimeMillis() - start;
		
		System.out.println("Running time: " + elapsed + " ms");
		
		try(FileWriter fw = new FileWriter(outputFile, true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            PrintWriter writer = new PrintWriter(bw))
	        {
				writer.write("Sort method: " + sortMethod + ".\n");
				writer.write("Run time: " + elapsed + " ms.\n");
				
				Date date = Calendar.getInstance().getTime();
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
			    writer.write("Today's date: " + sdf.format(date) + ".\n\n");

	        } catch (IOException e) {
	            throw new IllegalArgumentException("Failed to write on file.");
	        }

	}

	private static int[] getArrayFromFile(File inputFile2) {
		BufferedReader br = null;
		List<Integer> list = new ArrayList<Integer>();
		
		try {
			br = new BufferedReader(new FileReader(inputFile));
			String line = null;

            while ((line = br.readLine()) != null) {
            	list.add(Integer.parseInt(line));
            }
            
        } catch (IOException e) {
            System.out.println("File Read Error");
        } finally {
            try {
                if (br != null) {
                	br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
		int[] array = new int[list.size()];
        for(int i = 0; i < array.length; i++) {
        	array[i] = list.get(i); 
        }
        return array;
	}
}