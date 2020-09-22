public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        int newPosition = position + steps;
        if (newPosition >= MIN_POSITION && newPosition <= MAX_POSITION) {
            position = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
            sb.append(i == position ? "0" : "-");
        }
        return sb.toString();
    }
}
