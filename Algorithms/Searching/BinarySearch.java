
public class BinarySearch {
	
	static int itr = 0;
	
	/*
	 * returns index of value if it is present
	 * O(log n)
	 */
	static int binarySearch(int arr[], int value, int left, int right) {
		
		int mid = (left + right)/2;
		System.out.println("iteration "+itr+"> left: "+left+" right: "+right+" mid: "+mid);
		itr++;
		
		if(left <= right) {
			if(value < arr[mid]) {
				return binarySearch(arr, value, left, mid-1);
			}else if(value > arr[mid]) {
				return binarySearch(arr, value, mid+1, right);
			}else if(value == arr[mid]){
				return mid;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,5,8,12,16,23,38,56,72,91};
		
		if(binarySearch(arr, 91, 0, arr.length-1) != -1) {
			System.out.println("Value found");
		}else {
			System.out.println("value not found!");
		}
		
	}
}
