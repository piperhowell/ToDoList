//CSC 223
//Piper Howell

class PriQOverflowException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message = "This priority queue is full.";

    public PriQOverflowException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
