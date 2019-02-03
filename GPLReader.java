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
                "\" for input. \nError: " + e);
        }

        protectedReadLine();
        protectedReadLine();
/** 
        try {
            readHeader();
        } catch (Exception e) {
            throw new IOException(e.getMessage())
        }
        **/
    }


    public void readHeader() throws IOException {
        String str; 
        if ( !inp.readLine().equals("GIMP Palette") ) {
            line++;
            throw new IOException("Malformed file at line " + line);
        } 

        try {
            str = inp.readLine();
        } catch (Exception e) {
            throw new IOException();
        }

        line++;

        

        str = inp.readLine();
        line++;

        if ( str.length() < 8 ) 
            throw new IOException("Malformed file at line " + line);
        if ( !str.substring(0, 8).equals("Columns:") ) 
            throw new IOException("Malformed file at line " + line);

        str = inp.readLine();
        line++;

        if ( !str.equals("#") )
            throw new IOException("Malformed file at line " + line);
    }

    
    public String protectedReadLine() throws IOException {
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


    public Color readColor() throws IOException {

    }


    public void close() {
        inp.close();
    }
}