public class AssortedMethods {
    public static int randonInRange(int min, int max) {

        return randomInt(max + 1 - min) + min;
    }

    private static int randomInt(int i) {

        return (int) (Math.random() * i);
    }
}
