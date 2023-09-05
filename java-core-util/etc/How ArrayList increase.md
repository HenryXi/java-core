# How ArrayList increase
As we all know `ArrayList` use array to store the items. The length of array is fixed. When the array can't hold
all items it will increase. I want to know how `ArrayList` increases the length. I found the source code(JDK1.8) like
following.
```java
/**
 * Increases the capacity to ensure that it can hold at least the
 * number of elements specified by the minimum capacity argument.
 *
 * @param minCapacity the desired minimum capacity
 */
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```
The "minCapacity" is the min length which can hold all items. When we add an item into the ArrayList which length
is 10. The "minCapacity" is 10 + 1 = 11. `oldCapacity >> 1` means to get the half of the length. So the logic is 
when the space is not enough the space will increase 0.5 times.