package Animal;

public class Hamster extends Pets{
    public Hamster(String name, String classAnimal, String date_birthday, String commands) {
        super(name, classAnimal, date_birthday, commands);
    }
    @Override
    public String toString() {
        return String.format("Класс животного: %s, имя: %s, возраст животного: %s, команды животного: %s",
                getClassAnimal() ,getName(), getDate_birthday(), getCommands());
    }
}
