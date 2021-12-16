package ru.mirea.task13;

public class MyCollection<T> {
    private final int INIT_SIZE = 16; // начальный размер внутреннего массива
    private Object[] array = new Object[INIT_SIZE]; // внутренний массив
    private final int CUT_RATE = 4; // если кол-во элементов массива в X раз меньше его размера,
                                    //  то сократить его в 2 раза
    private int pointer = 0; // указатель на последний элемент

    // Добавление нового элемента в список (+ расширение внутреннего массива в два раза, если нужно)
    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }

    // Получение элемента по индексу
    public T get(int index) {
        return (T) array[index];
    }

    // Удаление элемента по индексу (сдвиг влево всех последующих элементов + уменьшение размера в 2 раза, если нужно)
    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
    }
    // Получить кол-во элементов в коллекции
    public int size() {
        return pointer;
    }

    // Масштабирование внутреннего массива
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    // Вывод коллекции на экран
    public void print()
    {
        System.out.println("Вывод всех элементов коллекции MyCollection с их индексами:");
        for(int i=0; i<pointer; i++)
            System.out.println(Integer.toString(i) + ": " + array[i]);
    }
}