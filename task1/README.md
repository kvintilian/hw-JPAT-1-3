В исходниках представлен вариант решения задачи для версии 1.8 и выше (14.0.2).

С этой версии появился метод Random.ints(...), возвращающий поток псевдослучайных чисел.

С этой версии задачу можно было бы решить так:
(но это именно решение "проблеммы", а не поставленной задачи использования паттерна)

```java
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int randomOrigin = 90;
        final int randomBound = 100;

        Iterable<Integer> iterator = new Iterable<>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Random().ints(randomOrigin, randomBound + 1).iterator();
            }
        };

        for (int r : iterator) {
            System.out.println("Случайное число: " + r);
            if (r == 100) {
                System.out.println("Выпало число 100, давайте на этом закончим");
                break;
            }
        }
    }
}

```