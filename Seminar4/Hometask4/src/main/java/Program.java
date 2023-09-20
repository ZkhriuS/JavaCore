public class Program {
    /**
     * точка входа в программу, создание и обработка тестовых массивов
     * @param args
     */
    public static void main(String[] args) {
        try{
            MyArray arr = new MyArray();
            String[][] arr1 = ArrayGenerator.generate(4,4);
            String[][] arr2 = ArrayGenerator.generate(3,3);

            print(arr1);
            System.out.println("Сумма: "+arr.process(arr1));
            print(arr2);
            System.out.println("Сумма: "+arr.process(arr2));

        }catch(MyArrayDataException e){
            System.out.println(e.getMessage() + e.getPosX() + "; " + e.getPosY());
        }catch(MyArraySizeException e){
            System.out.println(e.getMessage()+e.getSize());
        }
    }

    /**
     * вывод двумерного массива в консоль
     * @param array
     */
    private static void print(String[][] array){
        for(int x=0; x< array.length; x++){
            for (int y=0; y<array[x].length; y++){
                System.out.print(array[x][y]+" ");
            }
            System.out.println();
        }
    }
}
