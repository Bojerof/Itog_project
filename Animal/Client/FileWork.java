package Client;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    static private String fileName;
    public FileWork(String fileName) {
        this.fileName = fileName;
        try (FileWriter fileWriter = new FileWriter(fileName, true)){
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public List<String> printAllAnimal() {
        List<String> animalList = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bf = new BufferedReader(fileReader);
            String line = bf.readLine();
            if(line == null)
                System.out.println("Нет ни одного животного в списке");
            if (line != null)
                animalList.add(line);
            while (line != null) {
                line = bf.readLine();
                if (line != null)
                    animalList.add(line);
            }
            fileReader.close();
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
        return animalList;
    }
    public void saveAnimal(List<String> list){
        try (FileWriter fileWriter = new FileWriter(fileName, false)){
            for (String line : list) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
