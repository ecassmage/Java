import java.io.IOException;

import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class CSVReader{
    private ArrayList<ArrayList<String>> ColumnsAndRows;  // Holds a Multidimensional array for the rows and columns.
    private int[] ColumnSize;  // Stores Column Sizes, For pretty formatting.
    private boolean ColumnSizeMeasured = false; // For Telling toString if the format has been set or not. Prevents tediously doing the numbers over and over again, and instead is only done once.
    private FileReader file;  // Holds the File to be opened.

    public static void main(String[] args){
        CSVReader fd = new CSVReader("file.csv");
        System.out.println(fd.numberOfRows());
        System.out.println(fd.numberOfFields(3));
        System.out.println(fd.field(1, 3));
        System.out.println("\n" + fd);
    }

    public CSVReader(String fileName){
        try{
            this.file = new FileReader(fileName);
            this.ColumnsAndRows = new ArrayList<>();
            formatCSV();
        }
        catch(IOException e){  // I don't like throws, so I do it this way.
            System.out.println("File Not Found");
            e.printStackTrace();
            System.exit(1);
        }
    }
    private void formatCSV() throws IOException{
        Scanner S = new Scanner(file);  // Scanner
        boolean insideQuotations = false;  // Keeps track of being inside a quotation bracket.
        for (int i = 0; S.hasNextLine(); i++){  // Checks if there is a next line
            ArrayList<String> tempArray = new ArrayList<>();  // Creates a new ArrayList<String> for Each Row.
            String tempStr = S.nextLine();  //  Stores the nextLine so I can use it over and over again.
            String addStr = "";  // Stores the Field Being Looked At.
            for (int c = 0; c < tempStr.length(); c++) {  //Goes through 1 character at a time.
                if (tempStr.charAt(c) == '"') {  // Do these things if we find a double quotation.
                    if (!insideQuotations) insideQuotations = true;  // Checks if we are already in Double Quotations
                    else if (c+1 < tempStr.length() && tempStr.charAt(c+1) == '"'){  // Checks if this is a double double Quotation Sections.
                        addStr = addStr.concat("\"");  // Replaces Double Double Quotation with just a double quotation.
                        c++;  // Skips the extra double quotation.
                    }
                    else{
                        insideQuotations = false;  // We found the end of the quotation. This else will probably cause Problems if you don't have a properly formatted csv file.
                        tempArray.add(addStr); // Adds field to the Row.
                        addStr = ""; // resets the addStr
                        if (c+1 < tempStr.length() && tempStr.charAt(c+1) == ',') c++;  //skips the , that will usually appear after the double quotation.
                    }
                }
                else if (!insideQuotations && tempStr.charAt(c) == ','){  // Deals with things that aren't inside of quotation marks.
                    if (tempStr.charAt(c + 1) == ' '){  // Gets rid of the space after a , this might go against what is meant to be done, but I personally think that space is unlikely to be there intentionally part of the field.
                        c++;  // Skip the Space
                    }
                    tempArray.add(addStr);  // adds the field to row
                    addStr = "";  // resets the field for the next field
                }
                else addStr = addStr.concat(Character.toString(tempStr.charAt(c)));  // Adds a character to the field.
            }
            if (addStr.length() > 0) tempArray.add(addStr);  // Because Numbers at the end are ignored without this.
            ColumnsAndRows.add(tempArray);  // Adds row to the Columns and Rows array.
        }
    }

    public int numberOfRows(){ return ColumnsAndRows.size(); } // Returns the number of lines in the CSV file
    public int numberOfFields(int row) { return ColumnsAndRows.get(row).size(); }// Returns the number of fields in a particular row
    public String fieldOther(int row, int column) { return ColumnsAndRows.get(row-1).get(column-1); }  // well was wrong about that
    public String field(int row, int column) { return fieldOther(row+1, column+1); } // I assume that both row and column start at 1 like in excel instead of 0 like in most programming languages.

    private void FormatTable(){
        // Formats toString nicely so it can be more readable
        if (ColumnSizeMeasured) return;
        int maxLength = 0;
        for (int i = 0; i < ColumnsAndRows.size(); i++) if (numberOfFields(i) > maxLength) maxLength = numberOfFields(i);
        ColumnSize = new int[maxLength];
        for (int i = 0; i < ColumnsAndRows.size(); i++)
            for (int j = 0; j < ColumnsAndRows.get(i).size(); j++)
                if (ColumnsAndRows.get(i).get(j).length() > ColumnSize[j]) ColumnSize[j] = ColumnsAndRows.get(i).get(j).length();
        ColumnSizeMeasured = true;
    }

    public String toString(){
        // This is mostly for printing the entire thing so as to see everything better
        String str = "";
        FormatTable();
        for (int i = 0; i < numberOfRows(); i++){
            str = str.concat("| ");
            int num1 = numberOfRows(), num2 = numberOfFields(i);
            for (int j = 0; j < numberOfFields(i); j++){
                for (int space = 0; space < ColumnSize[j] - ColumnsAndRows.get(i).get(j).length(); space++) str = str.concat(" ");
                str = str.concat(field(i, j) + " | ");
            }
            str = str.concat("\n");
        }
        return str;
    }
}
