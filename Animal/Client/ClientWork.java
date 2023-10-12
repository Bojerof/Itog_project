package Client;

import java.util.Scanner;

public class ClientWork {
    Scanner in = new Scanner(System.in);
    AnimalCommand animalCommand = new AnimalCommand();
    public void run(){
        while (true){
            System.out.println("1 - добавить животное, 2 - показать список животных, 3 - добавить команду" +
                    " 4 - выход из программы");
            int command = in.nextInt();
            switch (command){
                case 1:
                        animalCommand.addAnimals();
                        break;
                case 2:
                        animalCommand.printAnimal();
                        break;
                case 3:
                        animalCommand.changeCommands();
                        break;
                default: return;
            }
        }
    }
}
