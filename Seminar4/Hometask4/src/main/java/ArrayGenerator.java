import java.util.Random;

public class ArrayGenerator {
    private static final Random random = new Random();

    /**
     * генерация произвольного двумерного массива
     * @param sizeX размерность строк
     * @param sizeY размерность столбцов
     * @return сгенерированный массив
     */
    public static String[][] generate(int sizeX, int sizeY){
        String[][] array = new String[sizeX][sizeY];
        double p = random.nextDouble();
        for(int x=0; x<sizeX; x++){
            for (int y=0; y<sizeY; y++){
                if(p<0.5) {
                    array[x][y] = generateString(random.nextInt(1, 20));
                }
                else{
                    array[x][y] = String.valueOf(random.nextInt(100));
                }
            }
        }
        return array;
    }

    /**
     * генерация произвольной строки
     * @param size количество символов в строке
     * @return сгенерированная строка
     */
    private static String generateString(int size){
        char[] string = new char[size];
        for(int i=0; i<size; i++)
            string[i] = (char)(random.nextInt(Character.MAX_CODE_POINT));
        return String.valueOf(string);
    }


}
