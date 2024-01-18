//CSC223
//Piper Howell

import java.util.Comparator;

public class PriorityQueue<T extends ToDoItem> implements PriQueueInterface<T> {
    private static final int DEFAULT_SIZE = 42;
    private final int SIZE;
    private final ToDoItem[] priorityList;
    private final Comparator<T> comparator;
    private int currentSize;

    public PriorityQueue() {
        this(DEFAULT_SIZE, null);
    }

    public PriorityQueue(int size) {
        this(size, null);
    }

    public PriorityQueue(Comparator<T> comparator) {
        this(DEFAULT_SIZE, comparator);
    }

    public PriorityQueue(int size, Comparator<T> comparator) {
        SIZE = size;
        priorityList = new ToDoItem[SIZE];
        this.comparator = comparator;
        currentSize = 0;
    }

    @Override
    public void enqueue(T element) throws PriQOverflowException {
        if (isFull()) {
            throw new PriQOverflowException("This priority queue is full.");
        }

        priorityList[currentSize] = element;
        reHeapUp(currentSize);
        currentSize++;
    }

    @Override
    public T dequeue() throws PriQUnderflowException {
        if (isEmpty()) {
            throw new PriQUnderflowException("This priority queue is empty.");
        }

        T highestPriority = (T) priorityList[0];
        currentSize--;
        priorityList[0] = priorityList[currentSize];
        priorityList[currentSize] = null;
        reHeapDown(0);

        return highestPriority;
    }

    private void reHeapUp(int nodeIndex) {
        int parentIndex = (nodeIndex - 1) / 2;
        T bottom = (T) priorityList[nodeIndex];

        while (nodeIndex > 0 && compare(bottom, (T) priorityList[parentIndex]) < 0) {
            priorityList[nodeIndex] = priorityList[parentIndex];
            nodeIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }

        priorityList[nodeIndex] = bottom;
    }

    private void reHeapDown(int nodeIndex) {
        int smallerChildIndex;

        T top = (T) priorityList[nodeIndex];
        while (nodeIndex < currentSize / 2) {
            int leftChildIndex = 2 * nodeIndex + 1;
            int rightChildIndex = leftChildIndex + 1;

            if (rightChildIndex < currentSize && compare((T) priorityList[leftChildIndex], (T) priorityList[rightChildIndex]) > 0) {
                smallerChildIndex = rightChildIndex;
            } else {
                smallerChildIndex = leftChildIndex;
            }

            if (compare(top, (T) priorityList[smallerChildIndex]) <= 0) {
                break;
            }

            priorityList[nodeIndex] = priorityList[smallerChildIndex];
            nodeIndex = smallerChildIndex;
        }

        priorityList[nodeIndex] = top;
    }

    private int compare(T item1, T item2) {
        if (comparator != null) {
            return comparator.compare(item1, item2);
        } else {
            return item1.compareTo(item2);
        }
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == SIZE;
    }

    @Override
    public int size() {
        return currentSize;
    }

    public T[] toArray() {
        T[] array = (T[]) new ToDoItem[currentSize];
        System.arraycopy(priorityList, 0, array, 0, currentSize);
        return array;
    }
}
