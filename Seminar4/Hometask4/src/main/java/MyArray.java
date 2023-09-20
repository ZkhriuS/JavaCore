public class MyArray {
    /**
     * итоговый целочисленный массив
     */
    private int[][] dstArray;
    /**
     * размерность по вертикали
     */
    private static final int SIZE_X=4;
    /**
     * размерность по горизонтали
     */
    private static final int SIZE_Y=4;
    public MyArray(){
        dstArray = new int[SIZE_X][SIZE_Y];
    }

    /**
     * инициализация массива назначения
     * @param srcArray исходный двумерный строковый массив
     * @throws MyArraySizeException - исключение, возникающее в случае несоответствия размерности исходного массива размерности массива назначения
     * @throws MyArrayDataException - исключение, возникающее в случае ошибки преобразования строки в число
     */
    private void init(String[][] srcArray) throws MyArraySizeException, MyArrayDataException{
        if(srcArray.length!=SIZE_X)
            throw new MyArraySizeException("Исходный массив состоит из неправильного количества строк: ", srcArray.length);
        for (int x=0; x<SIZE_X; x++) {
            if (srcArray[x].length != SIZE_Y)
                throw new MyArraySizeException("Неправильное количество ячеек в " + x + "-ой строке массива: ", srcArray[x].length);
            for (int y = 0; y < SIZE_Y; y++) {
                try {
                    dstArray[x][y] = Integer.parseInt(srcArray[x][y]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Встречены неконвертируемые символы в строке на позиции: ", x, y);
                }
            }
        }
    }

    /**
     * расчет суммы элементов массива
     * @return сумма
     */
    private int sum(){
        int result = 0;
        for(int x=0; x<SIZE_X; x++){
            for(int y=0; y<SIZE_Y; y++){
                result+=dstArray[x][y];
            }
        }
        return result;
    }

    /**
     * обработка исходного массива
     * @param srcArray исходный строковый двумерный массив
     * @return сумма
     * @throws MyArraySizeException - исключение, возникающее в случае несоответствия размерности исходного массива размерности массива назначения
     * @throws MyArrayDataException - исключение, возникающее в случае ошибки преобразования строки в число
     */
    public int process(String[][] srcArray) throws MyArraySizeException, MyArrayDataException{
        init(srcArray);
        return sum();
    }
}
