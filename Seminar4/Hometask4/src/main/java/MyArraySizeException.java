public class MyArraySizeException extends RuntimeException{
    private int size;
    public MyArraySizeException(String message, int size){
        super(message);
        this.size = size;
    }
    public int getSize(){
        return size;
    }
}
