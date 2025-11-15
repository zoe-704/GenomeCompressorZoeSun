/******************************************************************************
 *  Compilation:  javac GenomeCompressor.java
 *  Execution:    java GenomeCompressor - < input.txt   (compress)
 *  Execution:    java GenomeCompressor + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   genomeTest.txt
 *                virus.txt
 *
 *  Compress or expand a genomic sequence using a 2-bit code.
 ******************************************************************************/

/**
 *  The {@code GenomeCompressor} class provides static methods for compressing
 *  and expanding a genomic sequence using a 2-bit code.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Zach Blick
 */
public class GenomeCompressor {

    /**
     * Reads a sequence of 8-bit extended ASCII characters over the alphabet
     * { A, C, T, G } from standard input; compresses and writes the results to standard output.
     */
    public static void compress() {

        // TODO: complete the compress() method
        // Read in the string and find the first instance of TARGET
        String s = BinaryStdIn.readString();
        int n = s.length();
        // Write out each character
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == 'A') {
                BinaryStdOut.write(0, 2);
            } else if (cur == 'C') {
                BinaryStdOut.write(1, 2);

            } else if (cur == 'G') {
                BinaryStdOut.write(2, 2);

            } else {
                BinaryStdOut.write(3,2);
            }
        }

            BinaryStdOut.close();
    }

    /**
     * Reads a binary sequence from standard input; expands and writes the results to standard output.
     */
    public static void expand() {

        // TODO: complete the expand() method
        // Write out each character
        while (!BinaryStdIn.isEmpty()) {
            int cur = BinaryStdIn.readInt(2);
            if (cur == 00) {
                BinaryStdOut.write("A");
            } else if (cur == 01) {
                BinaryStdOut.write("C");
            } else if (cur == 10) {
                BinaryStdOut.write("G");
            } else {
                BinaryStdOut.write("T");
            }
        }

        BinaryStdOut.close();
    }


    /**
     * Main, when invoked at the command line, calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}