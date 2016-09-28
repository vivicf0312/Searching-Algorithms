
public class BinarySearch {

	static void findIndex(int arr[],int target){
		int length=arr.length;
		binarySearch(arr,target,0,length-1);
	}
	static int binarySearch(int arr[],int target,int start,int end){
		if(start>end){
			return -1;
		}
		int middle=(start+end)/2;
		int value=arr[middle];
		if(value>target){
			return binarySearch(arr, target, start, middle-1);
		}
		if(value<target){
			return binarySearch(arr, target, middle+1, end);
		}
		System.out.print("The target "+target+" was found on index "+ middle);
		return middle;
	}
	public static void main(String[] args) {
		int arr[]={2,4,7,9,13,15};
		System.out.print("Array: " + java.util.Arrays.toString(arr));
		System.out.println("");
		findIndex(arr,4);
		
	}

}
