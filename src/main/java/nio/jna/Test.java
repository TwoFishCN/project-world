package nio.jna;

public class Test {

    public static void main(String[] args) {

        args = new String[]{"a", "b"};

        show(args);
    }

    private static void show(String[] args) {
        for (int i = 0; i < args.length; i++) {
            CLibrary.INSTANCE.printf("Hello Word. Argument %d: %s\n", i, args[i]);
        }
    }

}
