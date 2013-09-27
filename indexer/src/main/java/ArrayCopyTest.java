import java.util.Arrays;

/**
 * Created by eniayin on 13-9-27.
 */
public class ArrayCopyTest {
    private static String seed = "String[] source = new String[number];\n" +
            "        Arrays.fill(source, String.valueOf(Math.random()));\n" +
            "\n" +
            "        String[] target;\n" +
            "        long start = System.currentTimeMillis();\n" +
            "        target = Arrays.copyOf(source, source.length);\n" +
            "        long end = System.currentTimeMillis();\n" +
            "        System.out.println(\"Array Copy [\" + number + \"] Used :\" + (end - start));\n" +
            "        System.out.println(\"Datas in new array are: {array[3]=\" + target[3] + \",array[30]=\" + target[30] + \",array[99]=\" + target[99] + \"}\");";

    public static void main(String... args) {
        startCopy(100);
        startCopy(1000);
        startCopy(1000);
        startCopy(10000);
        startCopy(100000);
        startCopy(1000000);
        startCopy(10000000);
        startCopy(100000000);
    }

    private static void startCopy(int number) {
        String[] source = new String[number];
        Arrays.fill(source, String.valueOf(Math.random() + seed));

        String[] target;
        long start = System.currentTimeMillis();
        target = Arrays.copyOf(source, source.length);
        long end = System.currentTimeMillis();
        System.out.println("Array Copy [" + number + "] Used :" + (end - start));
//        System.out.println("Datas in new array are: {array[3]=" + target[3] + ",array[30]=" + target[30] + ",array[99]=" + target[99] + "}");
    }
}
