import java.awt.Frame;

public class App {
    public App(int width, int height, int padding, String title, int firstLength, int spacing, int mode) {
        Frame frame = new Frame(title);
        frame.add(new canvas(width, height, padding, firstLength, spacing, mode));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(width + 2 * padding, height + 2 * padding);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println(
                    "Usage: java App <canvas width> <canvas height> <length> <spacing> <mode>");
            // ^^^^^^ kys prettier
            // god damnit it formatted the stupid comment too
            System.exit(1);
        }
        try {
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);
            int length = Integer.parseInt(args[2]);
            int spacing = Integer.parseInt(args[3]);
            int mode = Integer.parseInt(args[4]);
            new App(width, height, 20, "meow", length, spacing, mode);
        } catch (NumberFormatException e) {
            System.out.println("Cmon enter something valid meow");
            System.exit(1);
        }
    }
}
