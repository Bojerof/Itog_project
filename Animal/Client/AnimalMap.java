package Client;
import Animal.Animal;
public class AnimalMap {
    public String map(Animal animal){
        return String.format("%s,%s,%s,%s,%s", animal.getId(), animal.getClassAnimal(), animal.getName(),
                animal.getDate_birthday(), animal.getCommands());
    }
    public Animal map(String lines){
        String[] line = lines.split(",");
        return new Animal(line[0], line[1], line[2], line[3], line[4]);
    }
}
