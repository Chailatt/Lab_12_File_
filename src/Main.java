import java.io.IOException;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main

{
    public static void main(String[] args)
    {
        int w = 0;
        int l = 0;
        int c = 0;

      // variable declaration
        Scanner File;
        JFileChooser chooser = new JFileChooser();
        String num4line;


        Path goal = new File(System.getProperty("user.dir")).toPath();
        goal = goal.resolve("src");
        chooser.setCurrentDirectory(goal.toFile());


        try {

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)

            {
                goal = chooser.getSelectedFile().toPath();
                File = new Scanner(goal);
                System.out.println("File: " + goal.getFileName());
                while
                (File.hasNextLine())
                {
                    num4line = File.nextLine();
                    l++;
                    c += num4line.length();
                    w += new StringTokenizer(num4line, " ,").countTokens();
                }
                File.close();
                System.out.printf("# of Lines: %d ,    " +
                        "# of Words: %d  ,   " +
                        "# of Characters: %d ,   " +
                        "", l, w, c);
            } else


            //prompts the user to pick a file
            {
                System.out.println("PLease choose a file");
                System.exit(0);
            }
        }

        //File not found prompt and error message
        catch (FileNotFoundException e)
        {
            System.out.println("Unfortunately the file is missing");
            e.printStackTrace();
        }
        catch (IOException e)

        {
            System.out.println("ERROR - IOException .");
            e.printStackTrace();
        }
    }
}