import java.io.*;

public class mySystem {

    private static String fileName = "save.txt"; // the format of the save file will be the same as it is in the setter
                                                 // method
    // for the score. Each value will be written on a different line.

    static double strength;
    static double pts;
    static double minerR8;
    static double perice;
    static double minerPerice;
    static double minerTlPrice;
    static double mod;
    static double increase;
    static int numMiners;

    private static String[] parameters = new String[9];

    public static void save() { // wrties to a file "save.txt" in the same directory as all the other java
                                // files.
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // the order: strength, pts, minerR8, perice, minerPerice, minerTlPrice,
            // numMiners
            bufferedWriter.write("strength:" + score.getStrength());
            bufferedWriter.newLine();
            bufferedWriter.write("points:" + score.getPoints());
            bufferedWriter.newLine();
            bufferedWriter.write("minerRate:" + score.getMinerStrength());
            bufferedWriter.newLine();
            bufferedWriter.write("price:" + score.getPlayerPrice());
            bufferedWriter.newLine();
            bufferedWriter.write("miner Price:" + score.getMinerPrice());
            bufferedWriter.newLine();
            bufferedWriter.write("Miner Tool Price:" + score.getMinerToolPrice());
            bufferedWriter.newLine();
            bufferedWriter.write("mod:" + score.getMod());
            bufferedWriter.newLine();
            bufferedWriter.write("IncreaseBy:" + score.getIncreaseBy());

            bufferedWriter.newLine();
            bufferedWriter.write("Number of Miners:" + score.getNumOfMiners());

            // Always close files.
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }

    // public static void reset(){}

    public static void load() { // loads and sets all the variables from the "save.txt" file;
        String temp = null;

        int position = 0;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((temp = bufferedReader.readLine()) != null) {
                String newTemp = temp.replaceAll("[a-zA-Z]", "");
                newTemp = newTemp.replaceAll("[: ]", "");
                parameters[position] = newTemp;
                position++;
            }
            strength = Double.parseDouble(parameters[0]);
            pts = Double.parseDouble(parameters[1]);
            minerR8 = Double.parseDouble(parameters[2]);
            perice = Double.parseDouble(parameters[3]);
            minerPerice = Double.parseDouble(parameters[4]);
            minerTlPrice = Double.parseDouble(parameters[5]);
            mod = Double.parseDouble(parameters[6]);
            increase = Double.parseDouble(parameters[7]);
            numMiners = Integer.parseInt(parameters[8]);

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        score.setter(strength, pts, minerR8, perice, minerPerice, minerTlPrice, mod, increase, numMiners); // sets all
                                                                                                           // the
                                                                                                           // variables
                                                                                                           // to those
                                                                                                           // of the
                                                                                                           // save file.
                                                                                                           // Although
                                                                                                           // some
                                                                                                           // variables
                                                                                                           // are not
                                                                                                           // implimented
                                                                                                           // as i could
                                                                                                           // not
                                                                                                           // implement
                                                                                                           // a timed
                                                                                                           // function
                                                                                                           // like I
                                                                                                           // wanted.
    }
}
