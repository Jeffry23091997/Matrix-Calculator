import java.util.Random;
/**
 * Program to create convolutional code word for
 * binary data streams.
 * @author Katherine Cabezas
 * @version 1.0
 */
public class ConvolCode {

    private int[] x;
    private Matrix matrixA0;
    private Matrix matrixA1;
    private Vector yZero;
    private Vector yOne;

    /**
     * Constructor for Encoder. Randomly generates
     * binary stream x.
     * @param length Desired length for binary stream x
     */
    public ConvolCode(int length) {
        matrixA0 = new Matrix(length, 3);
        matrixA1 = new Matrix(length, 3);
        yZero = new Vector(length);
        yOne = new Vector(length);
        x = new int[length];
        Random randNumList = new Random();

        for (int i = 0; i < length; i++) {
            x[i] = randNumList.nextInt(2);
        }
    }

    /**
     * Constructor for Encoder.
     * @param stream Assigns this array of integers to x
     */
    public ConvolCode(int[] stream) {
        matrixA0 = new Matrix(stream.length, 3);
        matrixA1 = new Matrix(stream.length, 3);
        yZero = new Vector(stream.length);
        yOne = new Vector(stream.length);
        x = stream;
    }

    /**
     * Returns x binary data stream.
     * @return x
     */
    public int[] getX() {
        return x;
    }

    /**
     * Calculates the ouput stream y0.
     * @return output stream y0
     */
    public void calculateY0() {
        int[] y0 = new int[x.length];
        for (int i = 0; i < y0.length; i++) {
            if ((i - 2) < 0) {
                y0[i] = x[i];
                matrixA0.set(i, 0, x[i]);
                matrixA0.set(i, 1, 0);
                matrixA0.set(i, 2, 0);
            } else if ((i - 3) < 0) {
                y0[i] = x[i] + x[i - 2];
                matrixA0.set(i, 0, x[i]);
                matrixA0.set(i, 1, x[i - 2]);
                matrixA0.set(i, 2, 0);
            } else {
                y0[i] = x[i] + x[i - 2] + x[i - 3];
                matrixA0.set(i, 0, x[i]);
                matrixA0.set(i, 1, x[i - 2]);
                matrixA0.set(i, 2, x[i - 3]);
            }
            y0[i] = y0[i] % 2;
        }
        yZero = new Vector(y0);
    }

    /**
     * Calculates the output stream y1.
     * @return output stream y1
     */
    public void calculateY1() {
        int[] y1 = new int[x.length];
        for (int i = 0; i < y1.length; i++) {
            if ((i - 1) < 0) {
                y1[i] = x[i];
                matrixA1.set(i, 0, x[i]);
                matrixA1.set(i, 1, 0);
                matrixA1.set(i, 2, 0);
            } else if ((i - 3) < 0) {
                y1[i] = x[i] + x[i - 1];
                matrixA1.set(i, 0, x[i]);
                matrixA1.set(i, 1, x[i - 1]);
                matrixA1.set(i, 2, 0);
            } else {
                y1[i] = x[i] + x[i - 1] + x[i - 3];
                matrixA1.set(i, 0, x[i]);
                matrixA1.set(i, 1, x[i - 1]);
                matrixA1.set(i, 2, x[i - 3]);
            }
            y1[i] = y1[i] % 2;
        }
        yOne = new Vector(y1);
    }

    public Vector getY0() {
        return yZero;
    }

    public Vector getY1() {
        return yOne;
    }

    public Matrix getMatrixA0() {
        return matrixA0;
    }

    public Matrix getMatrixA1() {
        return matrixA1;
    }

    /**
     * Method to create convolutional code word y obtained.
     * @param stream Binary data stream
     * @return convolutional code word y
     */
    public String[] encode() {
        int[] y0 = calculateY0();
        int[] y1 = calculateY1();
        String[] y = new String[x.length];

        for (int i = 0; i < x.length; i++) {
            if (y0[i] == 1 && y1[i] == 1) {
                y[i] = "11";
            } else if (y0[i] == 0 && y1[i] == 1) {
                y[i] = "01";
            } else if (y0[i] == 1 && y1[i] == 0) {
                y[i] = "10";
            } else {
                y[i] = "00";
            }
        }

        return y;
    }

    //for testing purposes
    public static void main(String[] args) {
        int[] stream = { 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0 };
        ConvolCode coder = new ConvolCode(stream);
        String[] y = coder.encode();

        System.out.println("Convolutional code word: ");
        for (String s : y) {
            System.out.print(s + " ");
        }
        System.out.println();

        Vector x_guess = new Vector({0, 0, 0})
        Vector x = jacobi.jacobi(coder.getMatrixA0(), coder.getY0(), x_guess)
    }
}