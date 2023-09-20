public class MyArrayDataException extends NumberFormatException{
    private int posX;
    private int posY;
    public MyArrayDataException(String message, int posX, int posY){
        super(message);
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
