import java.io.*;

public class IOController {

    private static final String baseFolderName = "data/";
    private static final String fileType = ".genshinCS";


    public static void init(){
        new File(baseFolderName).mkdir();
    }

    /**
     * createFilePath
     * returns a String of the full relative filepath using the default baseFolder and file name
     * @param fileName the file name of the object that will be referred to in the filepath
     * @return a String of the full relative filepath
     * @author Joshua Roovers
     */
    private static String createFilePath(String fileName){
        return baseFolderName+fileName+fileType;
    }



    /**
     * saveObjectToFile
     * creates or updates a file from the given object
     * @param fileName of the file that will be stored to an object
     * @param data the object to be stored
     * @author Joshua Roovers
     */
    public static void saveObjectToFile(String fileName, Object data) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(createFilePath(fileName)))) {
            // Serialize and write the object to the file
            outputStream.writeObject(data);
            System.out.println("Object stored in the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * getObjectFromFile
     * returns an object that was the file of the given file name
     * @param fileName the file name
     * @return returns the retrieved object
     * @author Joshua Roovers
     */
    public static Object getObjectFromFile(String fileName) {

        // Read the object back from the file
        Object recoveredObject = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(createFilePath(fileName)))) {
            // Read the object from the file
            recoveredObject = (Object) inputStream.readObject();
            //System.out.println("Object read from file: " + recoveredObject);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return recoveredObject;
    }

}
