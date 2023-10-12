package Client;

import Animal.*;

class AnimalFactory {

    public static Animal createAnimal(ClassAnimal className, String name, String date, String commands){
        switch (className) {
            case CAT:
                return new Cat(name, "CAT", date, commands);
            case DOG:
                return new Dog(name, "DOG", date, commands);
            case HAMSTER:
                return new Hamster(name, "HAMSTER", date, commands);
            case HORSE:
                return new Horse(name, "HORSE", date, commands);
            case CAMEL:
                return new Camel(name, "CAMEL", date, commands);
            case DONKEY:
                return new Donkey(name, "DONKEY",date, commands);
            default:
                return null;
        }
    }
    public static Animal createAnimal(String className, String name, String date, String commands){
        switch (className) {
            case "CAT":
                return new Cat(name, "CAT", date, commands);
            case "DOG":
                return new Dog(name, "DOG", date, commands);
            case "HAMSTER":
                return new Hamster(name, "HAMSTER", date, commands);
            case "HORSE":
                return new Horse(name, "HORSE", date, commands);
            case "CAMEL":
                return new Camel(name, "CAMEL", date, commands);
            case "DONKEY":
                return new Donkey(name, "DONKEY",date, commands);
            default:
                return null;
        }
    }
}
