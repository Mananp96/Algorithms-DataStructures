
public class BubbleSort {
	
	enum order{
		ASC, DSC
	};
	
	/* Best case: O(n)
	 * Average case: O(n^2)
	 * Best case: O(n^2)
	 */
	void bubbleSort(int[] arr, order type) {
		boolean swapped = true;
		
		while(swapped != false) {
			swapped = false;
			for(int i = 0; i < arr.length - 1; i++) {
				
				if(type == order.ASC) {// Sort in Ascending order
					if(arr[i] > arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						swapped = true;
					}
				}else {//Sort in Descending order
					if(arr[i] < arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						swapped = true;
					}
				}
				
			}
		}
		
	}
	
	static void printArray(int arr[]){ 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] arr = {38,27,43,3,9,82,10};
		
		bs.bubbleSort(arr, order.ASC);
		System.out.println("sorted array in Ascending order:");
		printArray(arr);
		
		int[] arr2 = {38,27,43,3,9,82,10};
		
		bs.bubbleSort(arr2, order.DSC);
		System.out.println("sorted array in Descending order:");
		printArray(arr2);
	}
}
