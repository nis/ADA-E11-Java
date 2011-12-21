import java.util.Random;

public final class QuickSort {
	private static final int CUTOFF = 7;
	private int swaps = 0;
	
	public static void main (String[] args) {
		QuickSort my_class = new QuickSort();
		my_class.test();
	}
	
	private void test() {
		System.out.println("Testing QuickSort.");
		System.out.println("-----------------------------");
		int array_size = 100000;
		int runs = 100;
		System.out.println("Array size: \t" + array_size);
		System.out.println("Runs: \t\t" + runs);
		System.out.println("-----------------------------\n");
		
		System.out.println("Median 3 pivot:");
		System.out.println("-----------------------------");
		test_sorted_input(0, array_size, runs, 1); // Needed to get times that can be compared.
		test_sorted_input(1, array_size, runs, 1);
		test_reverse_sorted_input(array_size, runs, 1);
		test_random_input(array_size, runs, 1);
		System.out.println("-----------------------------");
	}
	
	private void test_sorted_input(int o, int array_size, int runs, int pivot_method) {
		Integer[] arr = new Integer[array_size];
		for (int i = 0; i < array_size ; i++ ) {
			arr[i] = i;
		}
		if (o == 1) {
			//System.out.println("Sorted input, " + array_size + " integers, " + runs + " times.");
		}
		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < runs ; i++ ) {
			Integer[] tarr = (Integer[])arr.clone();
			quicksort( tarr, 0, tarr.length -1, pivot_method );
		}
		
		if (o == 1) {
			time = System.currentTimeMillis() - time;
			System.out.println("Sorted: \t" + time + "ms.");
			//System.out.println("Swap: " + swaps);
			swaps = 0;
		}
		
	}
	
	private void test_reverse_sorted_input(int array_size, int runs, int pivot_method) {
		Integer[] arr = new Integer[array_size];
		for (int i = 0; i < array_size ; i++ ) {
			arr[i] = (array_size - 1) - i;
		}
		//System.out.println("Reverse sorted input, " + array_size + " integers, " + runs + " times.");
		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < runs ; i++ ) {
			Integer[] tarr = (Integer[])arr.clone();
			quicksort( tarr, 0, tarr.length -1, pivot_method );
		}
		
		time = System.currentTimeMillis() - time;
		System.out.println("Reverse: \t" + time + "ms.");
		//System.out.println("Swap: " + swaps);
		swaps = 0;
	}
	
	private void test_random_input(int array_size, int runs, int pivot_method) {
		Random randomGenerator = new Random();
		Integer[] arr = new Integer[array_size];
		for (int i = 0; i < array_size ; i++ ) {
			arr[i] = randomGenerator.nextInt(array_size - 1);
		}
		//System.out.println("Random input, " + array_size + " integers, " + runs + " times.");
		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < runs ; i++ ) {
			Integer[] tarr = (Integer[])arr.clone();
			quicksort( tarr, 0, tarr.length -1, pivot_method );
		}
		
		time = System.currentTimeMillis() - time;
		System.out.println("Random: \t" + time + "ms.");
		//System.out.println("Swap: " + swaps);
		swaps = 0;
	}
	
	/**
	 * Internal quicksort method that makes recursive calls.
	 * Uses median-of-three partitioning and a cutoff of 10.
	 * @param a an array of Comparable items.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	private void quicksort( Comparable [ ] a, int left, int right, int pivot_method )
	{
	    if( left + CUTOFF <= right )
	    {
			Comparable pivot;
			if (pivot_method == 1) {
				pivot = median3( a, left, right );
			} else {
				pivot = median3( a, left, right );
			}
	        
	
	            // Begin partitioning
	        int i = left, j = right - 1;
	        for( ; ; )
	        {
	            while( a[ ++i ].compareTo( pivot ) < 0 ) { }
	            while( a[ --j ].compareTo( pivot ) > 0 ) { }
	            if( i < j ) {
					swapReferences( a, i, j );
					swaps++;
				} else {
					break;
				}
	        }
	
	        swapReferences( a, i, right - 1 );   // Restore pivot
	
	        quicksort( a, left, i - 1, pivot_method );    // Sort small elements
	        quicksort( a, i + 1, right, pivot_method );   // Sort large elements
	    }
	    else  // Do an insertion sort on the subarray
	        insertionSort( a, left, right );
	}

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static Comparable median3( Comparable [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, right );

            // Place pivot at position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }

	/**
	 * Internal insertion sort routine for subarrays
	 * that is used by quicksort.
	 * @param a an array of Comparable items.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	private static void insertionSort( Comparable [ ] a, int left, int right )
	{
	    for( int p = left + 1; p <= right; p++ )
	    {
	        Comparable tmp = a[ p ];
	        int j;
	
	        for( j = p; j > left && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
	            a[ j ] = a[ j - 1 ];
	        a[ j ] = tmp;
	    }
	}
	
	/**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static final void swapReferences( Object [ ] a, int index1, int index2 )
    {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }
}
	