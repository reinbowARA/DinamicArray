import java.util.Arrays;

public class MyVector<T>{
    private int SizeArray;
    private final int CUT_RATE = 4;
    private Object[] array;
    private int pointer = 0;
 
    /**
     * InnerMyVector
     */
    MyVector(){}
    MyVector(int SizeArray) {
        this.SizeArray = SizeArray;  
    }
    public void setSizeArray(int sizeArray) {
        this.SizeArray = sizeArray;
        array = new Object[SizeArray];
    }
    /*
    Добавляет новый элемент в список. При достижении размера внутреннего
    массива происходит его увеличение в два раза.
    */
    public void add(T item) {
      if(pointer == array.length-1)
         resize(array.length*2); // увеличу в 2 раза, если достигли границ
      array[pointer++] = item;
    }
 
    /*
    Возвращает элемент списка по индексу.
    */
    public void get(int index) {
        var item = array[index];
        System.out.println(item);
    }
 
    /*
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого 
    перемещаются на шаг налево. Если после удаления элемента количество    
    элементов стало в CUT_RATE раз меньше чем размер внутреннего массива, 
    то внутренний массив уменьшается в два раза, для экономии занимаемого 
    места.
    */
    public void remove(int index) {
       for (int i = index; i<pointer; i++) 
         array[i] = array[i+1];
       array[pointer] = null;
       pointer--;
       if (array.length > SizeArray && pointer < array.length / CUT_RATE) 
          resize(array.length/2); // если элементов в CUT_RATE раз меньше чем 
                                  // длина массива, то уменьшу в два раза
    }
    /*Возвращает количество элементов в списке*/
    public int size() {
       return pointer;
    }
 
    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
       Object[] newArray = new Object[newLength];
       System.arraycopy(array, 0, newArray, 0, pointer);
       array = newArray;
    }
    
    /*Вывод в консоль всех элементов динамичского массива */
    public void getArray() {
        for (int i = 0; i < pointer; i++) {
            System.out.println(array[i]);
        }   
    }
    
    public void addIndex(T item, int index){
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        try{if(pointer < index){
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        var array2 = Arrays.copyOfRange(array, pointer - index, pointer+1);
        array[index]= item;
        /*for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }*/
        array[pointer++] = item;
        for (int i = 0; i < array2.length; i++) {
            array[index + i +1] = array2[i];
        }}catch(ArrayIndexOutOfBoundsException e){
            System.out.println("входящий индекс превышает размер изначального массива");
        }
    }

    public void removeAll() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        pointer  = 0;
        if (array.length > SizeArray && pointer < array.length / CUT_RATE) 
          resize(array.length/2); // если элементов в CUT_RATE раз меньше чем 
                                  // длина массива, то уменьшу в два раза
    }

    public void removeEndElements(){
        array[pointer] = null;
        pointer--;
        if (array.length > SizeArray && pointer < array.length / CUT_RATE) 
          resize(array.length/2); // если элементов в CUT_RATE раз меньше чем 
                                  // длина массива, то уменьшу в два раза
    }

}