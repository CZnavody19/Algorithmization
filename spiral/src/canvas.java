import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class canvas extends Canvas {
    int firstLength;
    int spacing;
    int mode;

    public canvas(int width, int height, int padding, int firstLength, int spacing, int mode) {
        this.firstLength = firstLength;
        this.spacing = spacing;
        this.mode = mode;

        setBackground(Color.WHITE);
        setBounds(padding, padding, width, height);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);

        switch (this.mode) {
            case 0:
                noRecursion(g, this.firstLength, this.spacing);
                break;

            case 1:
                yesRecursion(g, new int[] { 0, 0 }, 0, this.firstLength, this.spacing);
                break;
        }
    }

    void yesRecursion(Graphics g, int[] start, int i, int currentLength, int spacing) {
        if (currentLength <= 0) {
            return;
        }

        int[] end = start.clone();

        switch (i % 4) {
            case 0:
                end[0] += currentLength;
                end[1] = start[1];
                if (i > 0) {
                    currentLength -= spacing;
                }
                break;
            case 1:
                end[1] += currentLength;
                end[0] = start[0];
                break;
            case 2:
                end[0] -= currentLength;
                end[1] = start[1];
                currentLength -= spacing;
                break;
            case 3:
                end[1] -= currentLength;
                end[0] = start[0];
                break;
        }
        g.drawLine(start[0], start[1], end[0], end[1]);
        yesRecursion(g, end, i + 1, currentLength, spacing);
    }

    void noRecursion(Graphics g, int firstLength, int spacing) {
        int[] start = { 0, 0 };
        int[] end = { 0, 0 };
        int currentLength = firstLength;
        int i = 0;

        while (currentLength > 0) {
            switch (i % 4) {
                case 0:
                    end[0] += currentLength;
                    end[1] = start[1];
                    if (i > 0) {
                        currentLength -= spacing;
                    }
                    break;
                case 1:
                    end[1] += currentLength;
                    end[0] = start[0];
                    break;
                case 2:
                    end[0] -= currentLength;
                    end[1] = start[1];
                    currentLength -= spacing;
                    break;
                case 3:
                    end[1] -= currentLength;
                    end[0] = start[0];
                    break;
            }
            g.drawLine(start[0], start[1], end[0], end[1]);
            start = end.clone();
            i++;
        }
    }
}
