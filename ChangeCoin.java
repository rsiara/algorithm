import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChangeCoin{

	private QuickSort qs = new QuickSort();
	private long[][] resultList;

	private long result;

	 class  QuickSort{

		private long[] array;
		
		public long[] sort(long[] inputArray){
			array = new long[inputArray.length];
			for(int i = 0; i < inputArray.length ; i++){
				array[i] = inputArray[i];
			}
			int lowerIndex = 0;
			int higherIndex = inputArray.length - 1;
			quickSort(lowerIndex, higherIndex);
			
			return array;
		
		}

		public void quickSort(int lowerIndex, int higherIndex){

		int i = lowerIndex;
		int j = higherIndex;

		long pivot = array[lowerIndex + (higherIndex - lowerIndex)/2];

			while(i <= j){

				while(array[i] < pivot){
					i++;
				}	
				while(array[j] > pivot){
					j--;
				}

				if(i <= j){
					swap(i,j);
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

		private void swap(int i, int j){
			long tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}

	}




	public static void main(String[] args){

		System.out.println("* * * Change coin * * *");
	
		Scanner in = new Scanner(System.in);
		System.out.println("Number to change: ");
        int numberToChange = in.nextInt();
        System.out.println("Size of table: ");
        int m = in.nextInt();
        long[] coins = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            coins[c_i] = in.nextLong();
        }



		//long [] coins = new long[]{1,2,3};
		int numberOfCoinToUse = 4;
		/*int numberToChange = 4;*/

		ChangeCoin changeCoin = new ChangeCoin();
		changeCoin.printWaysToChange(coins, numberOfCoinToUse, numberToChange);
		

	}

	public long printWaysToChange(long[] coins, int numberOfCoinToUse, int numberToChange){

		permute(coins, numberOfCoinToUse, numberToChange);
		System.out.println("Result list:");
		print2dArray(resultList);
		System.out.println("Result:  " + result);
		return resultList.length;

	}

	public void permute(long[] arr, int numberOfCoinToUse, int numberToChange){
    	permuteHelperSecond(arr, null, 0, numberOfCoinToUse, numberToChange);
	}	

	private void permuteHelper(long[] coins, long[] exchangeCoin, int column){
		//boolean con = column < coins.length;
		//System.out.println("column < coins.length: " + con);
		if(column < coins.length){
			if(exchangeCoin==null){
				exchangeCoin = new long[coins.length];
			}
			
			for(int i = 0; i < coins.length; i++){
				exchangeCoin[column] = coins[i];

				printArray(exchangeCoin);

				isChangableForN(exchangeCoin,10);

				if(column < coins.length-1){
					permuteHelper(coins,exchangeCoin,column+1);
				}
				exchangeCoin[column] = 0;
			}
		}

	}

	private void permuteHelperSecond(long[] coins, long[] exchangeCoin, int column, int numberOfCoinToUse, int numberToChange){

		if(column < numberOfCoinToUse){
			if(exchangeCoin==null){
				exchangeCoin = new long[numberOfCoinToUse];
			}
			
			for(int i = 0; i < coins.length; i++){
				exchangeCoin[column] = coins[i];
				
		
				isChangableForN(exchangeCoin, numberToChange);


				if(column < numberOfCoinToUse-1){
					permuteHelperSecond(coins,exchangeCoin,column+1,numberOfCoinToUse, numberToChange);
				}
				exchangeCoin[column] = 0;
			}
		}

	}

	private void isChangableForN(long[] arr, long n){


		long sum = 0;
		for(long a : arr){
			sum += a;
		}

		arr = qs.sort(arr);
	
		

		if(sum == n && isUnique(arr)){
			addToResultList(arr);
			result++;
		
		}

		
	}

	public void addToResultList(long[] arr){
		if(resultList == null){
			resultList = new long[1][];
			resultList[0] = new long[arr.length];
			copyArray(arr, resultList[0]);
		
	
		}else{
			 long[][] newResultList = new long[resultList.length+1][];
	
			 
				for(int i = 0; i < resultList.length; i++){
						newResultList[i] = new long[resultList[i].length];
						copyArray(resultList[i], newResultList[i]);
				}


			 newResultList[newResultList.length-1] = new long[arr.length];
			
			 copyArray(arr, newResultList[newResultList.length -1]);
			
			 resultList = newResultList;

		}
	}

	private boolean isUnique(long[] arr){
		if(resultList==null){
			return true;
		}else{
			boolean isUnique = true;
			for(int i = 0 ; i < resultList.length; i++){
			/*	System.out.println("Compare arr: ");
				printArray(arr);
				System.out.println("Compare result: " + i);
				printArray(resultList[i]);*/
				if(compareArrays(arr, resultList[i])){
					isUnique = false;
					break;
				}
			}
			return isUnique;
		}
	}

	private boolean compareArrays(long[] array1, long [] array2){
		 boolean b = true;
        if (array1 != null && array2 != null){
          if (array1.length != array2.length)
              b = false;
          else
              for (int i = 0; i < array2.length; i++) {
                  if (array2[i] != array1[i]) {
                      b = false;    
                  }                 
            }
        }else{
          b = false;
        }
      
        return b;
	}

	private void printArray(long[] arr){
		for(long i : arr){
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	private void print2dArray(long[][] arr){

		if(resultList==null){
			System.out.println("resultList is empty");
		}else{

			System.out.println("---------- ");
			 for(int i=0; i<arr.length; i++){
				for(int j=0; j<arr[i].length; j++) {
					
					System.out.print(arr[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("--------- ");
		}

	}

	private void copyArray(long[] source, long[] target){

		//printArray(target);
		for(int i = 0; i < source.length; i++){
			target[i] = source[i];
		}

	}
		
	

}
	