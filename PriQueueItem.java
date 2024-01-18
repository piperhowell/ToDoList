//CSC 223
//Piper Howell

class PriQueueItem implements Comparable<PriQueueItem> {
    private int priority;
    private int sequenceNumber;

    public PriQueueItem(int priority, int sequenceNumber) {
        this.setPriority(priority);
        this.setSequenceNumber(sequenceNumber);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int compareTo(PriQueueItem other) {
        int result = Integer.compare(this.priority, other.sequenceNumber);

        if (result == 0) {
            result = Integer.compare(this.priority, other.sequenceNumber);
        }
        return result;
    }
}
