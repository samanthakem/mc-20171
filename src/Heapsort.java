package src;

public class Heapsort implements Sortable {
	
	private static int tamanho;
	
	@Override
	public void sort(int[] array) {
		buildMaxHeap(array);
		for (int i = tamanho; i > 0; i--) {
			int aux = array[i];
			array[i] = array[0];
			array[0] = aux;
			tamanho--;
			maxHeapify(array, 0);
		}
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
}
