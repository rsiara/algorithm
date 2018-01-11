public class MergeSort{


	private int[] array;
	private int[] tmpArray;

	public static void main(String[] args){
		System.out.println("Hello world");

		int[] arrayToSort = {1,5,4,3,8,4,2,7,11,2,3,24,4,2,1,8};
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arrayToSort);

		for(int i : arrayToSort){
			System.out.print(i + " ");
		}
	}

	public void sort(int[] inputArray){
		this.array = inputArray;
		
		
		int lowerIndex = 0;
		int higherIndex = inputArray.length - 1;

		mergeSort(lowerIndex, higherIndex);
	}


	private void mergeSort(int lowerIndex, int higherIndex){
		this.tmpArray = new int[array.length];

		int i = lowerIndex;
		int j = higherIndex;

		int pivot = i + (j-i) / 2;

		if(i < j){ 
			mergeSort(i, pivot);
			mergeSort(pivot +1 , j); 
		}

		mergeParts(i, pivot, j);

	}

	private void mergeParts(int i, int m, int j){
		
		int aPointer = i;
		int bPointer = m+1;

		int tmpPosition = i;

		while(aPointer <= m && bPointer <= j){
			if(array[aPointer] <= array[bPointer] ){
				tmpArray[tmpPosition] = array[aPointer];
				aPointer++;
			}else{
				tmpArray[tmpPosition] = array[bPointer];
				bPointer++;
			}
			tmpPosition++;
		}

		while(aPointer <= m){
			tmpArray[tmpPosition] = array[aPointer];
			aPointer++;
			tmpPosition++;
		}	

		while(bPointer <= j){
			tmpArray[tmpPosition] = array[bPointer];
			bPointer++;
			tmpPosition++;
		}
		
		for(int k = i; k<=j; k++){
			array[k] = tmpArray[k];
		}

	}

}