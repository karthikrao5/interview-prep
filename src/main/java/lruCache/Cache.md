LRU Cache (Least Recently Used Cache)

Once cache reaches capacity, adding new items should kick out the least recently used item first.

Adding an item should be O(1) since it goes at the head of the list

Retrieving an item should move the item to the top of the list

With a single double linked list implementation, retrieval is O(n) since you need to traverse the list to find the value
You can use a hashmap to keep track of the location of each node in the list so retrieval becomes O(1)

Cache.java has a single double linked list
FasterCache.java has a double linked list and Hashmap