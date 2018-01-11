public class StringOperator{


	public static void main(String[] args){
		System.out.println("Hello world");
		String stringToCheck = "kokok";

		StringOperator stringOperator = new StringOperator();
		boolean result = stringOperator.isPalindrome(stringToCheck);
		System.out.println("Is \"" + stringToCheck + "\" is panlindrome: " + result);

		System.out.println("Reversed string: " + stringOperator.reverse("Czarny niedzwiedz"));
	}

	

	private boolean isPalindrome(String str){
		int n = str.length();
		int halfN = (n/2);

		System.out.println(halfN);

		for(int i = 0; i < (n/2); ++i){
			if(str.charAt(i) != str.charAt(n-i-1)){
				return false;
			}
		}

		return true;
	}

	private String reverse(String str){
		String reversedString = "";
		for(int i = str.length()-1;  i >= 0 ; i-- ){
			reversedString += str.charAt(i);
		}
		return reversedString;
	}

}