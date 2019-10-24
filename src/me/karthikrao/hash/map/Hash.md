In java, the HashMap implementation uses an Entry node that has: 
1. key
2. value
3. hash
4. reference to next node

The fourth item means collisions are handled by adding to the bucket to create a linked list

By default, the hashmap comes with size 16 capacity and load factor 0.75 meaning if you know the capacity will be larger, it is better to initialize it with a larger size since an insertion that reaches load factor capacity will trigger a full map rehash which is O(n) and doubles the size. This is largely negligible.

Hashmap is not thread safe and permits null values.

HashTable is full map thread safe. This can be bad in multithreaded use cases since the entire map is locked down. If Thread A is getting key A, and Thread B is getting key B, thread B has to wait for thread A even though they are not interacting with the same bucket.

ConcurrentHashMap implementation has only the buckets being synchronized meaning only read/writes to the same bucket will be locked instead of the whole map.


**QUESTIONS**
Java object default hashCode() function is an int that represents the internal memory address of that object. Two distinct objects can never have the same memory address so why is this not a sufficient hashing function? 