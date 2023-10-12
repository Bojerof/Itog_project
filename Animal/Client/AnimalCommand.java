package Client;

import Animal.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalCommand {
    FileWork fileWork = new FileWork("Animal/ListAnimal.csv");
    AnimalMap animalMap = new AnimalMap();
    AnimalFactory animalFactory = new AnimalFactory();
    Scanner in = new Scanner(System.in);


    public Animal input() throws ParseException {
        System.out.println("Какое животное вы хотите добавить?");
        int op = Integer.parseInt(print("1 - кот, 2 - собака, 3 - хомячок, 4 - верблюд, 5 - осёл, 6 - лошадь"));
        ClassAnimal classAnimal = choiseClassAnimal(op);
        String name = print("Напишите имя");
        String date = print("Напишите дату рождения в формате 01.01.1990");
        String command = print("Напишите команды через пробел");
        return AnimalFactory.createAnimal(classAnimal, name, date, command);

    }

    private List<Animal> getAllAnimal() {
        List<String> list = fileWork.printAllAnimal();
        List<Animal> animalList = new ArrayList<>();
        for (var item : list) {
            animalList.add(animalMap.map(item));
        }
        return animalList;
    }

    private void saveAll(List<Animal> animal) {
        List<String> list = new ArrayList<>();
        for (var item : animal) {
            list.add(animalMap.map(item));
        }
        fileWork.saveAnimal(list);
    }

    public void addAnimals() {
        List<Animal> animalList = getAllAnimal();
        try {
            Animal animal = input();
            int max = 0;
            for (var item : animalList) {
                int id = Integer.parseInt(item.getId());
                if (id > max)
                    max = id;
            }
            int newId = max + 1;
            String id = String.format("%d", newId);
            animal.setId(id);
            animalList.add(animal);
            System.out.println(animal);
            saveAll(animalList);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printAnimal() {
        List<String> list = fileWork.printAllAnimal();
        List<Animal> animalList = new ArrayList<>();
        for (var item : list) {
            String[] line = item.split(",");
            animalList.add(animalFactory.createAnimal(line[1], line[2], line[3], line[4]));
        }
        for (var item : animalList) {
            System.out.println(item);
        }
    }
    public void changeCommands(){
        List<Animal> animalList = getAllAnimal();
        String findId = print("Введите ID животного");
        System.out.println("Введите новые команды");
        String newCommand = in.nextLine();
        for (var item : animalList) {
            if(item.getId().equals(findId)){
                item.setCommands(newCommand);
            }
        }
        saveAll(animalList);
    }

    public ClassAnimal choiseClassAnimal(int op) {
        switch (op) {
            case 1:
                return ClassAnimal.CAT;
            case 2:
                return ClassAnimal.DOG;
            case 3:
                return ClassAnimal.HAMSTER;
            case 4:
                return ClassAnimal.CAMEL;
            case 5:
                return ClassAnimal.DONKEY;
            case 6:
                return ClassAnimal.HORSE;
            default:
                System.out.println("Такого класса нету\nПопробуйте ещё раз!");
                return choiseClassAnimal(in.nextInt());
        }
    }

    public String print(String message) {
        System.out.println(message);
        return in.nextLine();
    }
}
