import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor 
{

    // Attributes
    private String fileName;
    private int stringLength;
    private ArrayList<String> stringList;
    private Scanner input;

    // Constructor
    public FileProcessor(String fileName, int stringLength) 
    {
        this.fileName = fileName;
        setStringLength(stringLength); // Using the setter with bounds check
        this.stringList = new ArrayList<>();
    }

    // Get the number of elements in the ArrayList
    public int getArrayListSize() 
    {
        return stringList.size();
    }

    // Complete processFile method
    public void processFile() 
    {
    	stringList = new ArrayList<>();//instantiate
        try 
        {
            input = new Scanner(new java.io.File(fileName));

            while (input.hasNextLine())
            {
                String line = input.nextLine();
                if (line.length() > stringLength) 
                {
                    throw new StringTooLongException("String is too long!");
                }
                stringList.add(line);
            }
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        } 
        catch (StringTooLongException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    // Getter for fileName
    public String getFileName() 
    {
        return fileName;
    }

    // Setter for fileName
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    // Getter for stringLength
    public int getStringLength() 
    {
        return stringLength;
    }

    // Setter for stringLength with bounds check
    public void setStringLength(int stringLength) 
    {
        if (stringLength < 5) 
        {
            this.stringLength = 5;
        } else 
        {
            this.stringLength = stringLength;
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        FileProcessor fp = new FileProcessor("String1.txt", 10);
        fp.processFile();
        System.out.println("ArrayList size: " + fp.getArrayListSize());

        FileProcessor fp2 = new FileProcessor("BadString.txt", 10);
        fp2.processFile();
        System.out.println("ArrayList size: " + fp2.getArrayListSize());
    }

}