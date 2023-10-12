package Animal;

public class Animal {
    private String id;
    private String name;
    private String date_birthday;
    private String commands;
    private String classAnimal;

    public void setId(String id) {
        this.id = id;
    }

    public String getClassAnimal() {
        return classAnimal;
    }

    public Animal(String name, String classAnimal, String date_birthday, String commands) {
        this.name = name;
        this.date_birthday = date_birthday;
        this.commands = commands;
        this.classAnimal = classAnimal;
    }

    public Animal(String id, String name, String classAnimal, String date_birthday, String commands) {
        this(classAnimal, name, date_birthday, commands);
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate_birthday() {
        return date_birthday;
    }

    public String getCommands() {
        return commands;
    }

}
