import java.util.Iterator;
import java.util.Random;

public class RandomIterator implements Iterator<Integer> {

    final protected Random random;
    final protected int max;
    final protected int min;

    public RandomIterator(Random random, int min, int max) {
        this.random = random;
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public void remove() {

    }
}
