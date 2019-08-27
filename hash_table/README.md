# Hash Table

In computing, a hash table (hash map) is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.

	+-----------+-----------+-----------+
	|Algorithm  |Average    |Worst case |
	+-----------+-----------+-----------+
	|Space      |O(n)       |O(n)       |
	+-----------+-----------+-----------+
	|Search     |O(1)       |O(n)       |
	+-----------+-----------+-----------+
	|Insert     |O(1)       |O(n)       |
	+-----------+-----------+-----------+
	|Delete     |O(1)       |O(n)       |
	+-----------+-----------+-----------+
	
	
# Hashmap vs Hashtable
1. HashMap is non synchronized. It is not-thread safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
2. HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.