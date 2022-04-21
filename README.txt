Enter the number of items to sort followed by the sort algorithm(s) or "all": 
1. bubble
2. selection
3. insertion
4. merge
5. shell
6. quick
7. heap

example for starting app from the command line:
    
    java Sort.java 100 bubble
    
    java Sort.java 100 bubble quick
    
    java Sort.java 100 bubble quick merge shell bubble
    
    java Sort.java 100 all

example output(s):
It took bubble sort 348567900 nanoseconds.
It took selecion sort 344400 nanoseconds.
It took insertion sort 4263300 nanoseconds.
It took merge sort 2781300 nanoseconds.
It took shell sort 2569400 nanoseconds.
It took quick sort 1660400 nanoseconds.

JUnit5 was used inorder to simplify testing and adding sort algorithms in the future.