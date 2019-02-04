import java.io.*;
import java.awt.Color;
import java.util.ArrayList;

public class GPLReader {


    private BufferedReader inp;
    private int line;


    public GPLReader(String filename) {
        line = 0;
        try {
            inp = new BufferedReader( new FileReader(filename) );
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't open file: \"" + filename +
                "\" for input. \nError: " + e.getMessage());
        }
=   
        try {
            readHeader();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }


    public void readHeader() throws IOException {
        try {
            if ( !this.readLine().equals("GIMP Palette") ||
                 !this.readLine().substring(0, 5).equals("Name:") ||
                 !this.readLine().substring(0, 8).equals("Columns:") ||
                 !this.readLine().equals("#") )
                throw new IOException("Malformed header at line " + line);
        } catch (Exception e) {
            throw new IOException("Malformed header at line " + line);
        }
    }

    
    public String readLine() throws IOException {
        String str;
        try {
            line++;
            str = inp.readLine();
        } catch(Exception e) {
            throw new IOException("Expecting input on line " + line);
        }
        return str;
    }


    public ArrayList<Color> readFile() throws IOException {

    }


    public Color readColor() {
        String str;
        try {
            str = this.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }


    public void protectedClose() {
        try {
            inp.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\nprotectedClose failed");
        }
    }
}