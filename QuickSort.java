public class QuickSort{


	private int[] array;

	public static void main(String[] args){
		System.out.println("Hello world");

		int[] arrayToSort = {4,1,2};
		QuickSort quickSort = new QuickSort();
		quickSort.sort(arrayToSort);

		for(int i : arrayToSort){
			System.out.print(i + " ");
		}
	}

	public void sort(int[] inputArray){
		this.array = inputArray;
		
		int lowerIndex = 0;
		int higherIndex = inputArray.length - 1;

		quickSort(lowerIndex, higherIndex);
	}


	private void quickSort(int lowerIndex, int higherIndex){

		int i = lowerIndex;
		int j = higherIndex;

		int pivot = array[lowerIndex + (higherIndex - lowerIndex)/2];

		while(i <= j){

			while(array[i] < pivot){
				i++;
			}	
			while(array[j] > pivot){
				j--;
			}

			if(i <= j){
				doSwap(i,j);
				i++;
				j--;
			}

		}

		if(lowerIndex < j){
			quickSort(lowerIndex, j);
		}
		if(higherIndex > i){
			quickSort(i, higherIndex);
		}

	}

	private void doSwap(int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}