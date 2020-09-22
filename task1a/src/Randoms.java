import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    final protected Random random;
    final protected RandomIterator iterator;

    public Randoms(int min, int max) {
        random = new Random();
        iterator = new RandomIterator(random, min, max);
    }

    @Override
    public Iterator<Integer> iterator() {
        return iterator;
    }
}