//CSC 223
//Piper Howell

class PriQUnderflowException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message = "This priority queue is empty.";

    public PriQUnderflowException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
