public class MergeSort {
	
	// O(n log n)	
	void merge(int arr[], int left, int right, int mid) {
		System.out.println("Merge Inside-----:"+left+" "+right+" "+mid);
		
		// Find sizes of two subarrays to be merged 
		int s1 = mid - left + 1;
		int s2 = right - mid;
		
		/* Create temp arrays */
		int L[] = new int[s1];
		int R[] = new int[s2];
		
		/*Copy data to temp arrays*/
        for (int i=0; i<s1; ++i) 
            L[i] = arr[left + i]; 
        for (int j=0; j<s2; ++j) 
            R[j] = arr[mid + 1 + j]; 
        
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;
        // Initial index of merged subarry array 
        int k = left;
        
        while(i < s1 && j < s2) {
        	if(L[i] <= R[j]) {
            	arr[k] = L[i];
            	i++;
            }else {
            	arr[k] = R[j];
            	j++;
            }
        	k++;
        }
        
        // Extra element remained in L[] or R[]
        while(j < s2) {
        	arr[k] = R[j];
        	k++;
        	j++;
        }
        while(i < s1) {
        	arr[k] = L[i];
        	k++;
        	i++;
        }
		
	}
	
	void mergeSort(int arr[], int left, int right) {
		if(left < right) {
			
			int mid = (left + right)/2;
			
			mergeSort(arr, left, mid);
			System.out.println("Pass: "+left+" "+mid);
			mergeSort(arr, mid+1, right);
			System.out.println("merge: "+(mid+1)+" "+right);
			
			merge(arr, left, right, mid);
		}
	}
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	
	public static void main(String[] args) {
		int[] arr = {38,27,43,3,9,82,10};
		MergeSort m = new MergeSort();
		
		m.mergeSort(arr, 0, arr.length-1);
		System.out.println("Sorted array:");
		printArray(arr);
	}
}