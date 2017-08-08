package sort;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Heapsort {

	  private final static int VERSION = 1;
	  private static int tamanho;
	  
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

			long start = System.currentTimeMillis();
			heapSort(values);
			long elapsed = System.currentTimeMillis() - start;
			long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsed);
			System.out.format("%d,%d", seconds, VERSION);
	    }

	  
	  private final static void maxHeapify(int[] A, int pai) {
	        int esq = 2 * pai + 1;
	        int dir = (2 * pai) + 2;
	        int maior = pai;
	        if (esq <= tamanho && A[esq] > A[maior]) {
	            maior = esq;
	        }
	        if (dir <= tamanho && A[dir] > A[maior]) {
	            maior = dir;
	        }
	        if (maior != pai) {
	            int aux = A[pai];
	            A[pai] = A[maior];
	            A[maior] = aux;
	            maxHeapify(A, maior);
	        }
	    }

	  public final static void buildMaxHeap(int[] A) {
	        tamanho = A.length - 1;
	        for (int pai = tamanho / 2; pai >= 0; pai--) {
	            maxHeapify(A, pai);
	        }
	    }

	    public final static void heapSort(int[] A) {
	        buildMaxHeap(A);
	        for (int i = tamanho; i > 0; i--) {
	            int aux = A[i];
	            A[i] = A[0];
	            A[0] = aux;
	            tamanho--;
	            maxHeapify(A, 0);
	        }
	    }
}


