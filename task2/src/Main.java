import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Frog frog = new Frog();
        Scanner scanner = new Scanner(System.in);
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        System.out.println("+N - прыгни на N шагов направо\n" +
                "-N - прыгни на N шагов налево\n" +
                "<< - Undo (отмени последнюю команду)\n" +
                ">> - Redo (повтори отменённую команду)\n" +
                "!! - повтори последнюю команду\n" +
                "0 - выход");
        System.out.println("Введите команды для лягушки:");
        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            String input = scanner.nextLine().trim();

            if ("0".equals(input)) break;

            if ("<<".equals(input)/*пользователь хочет отменить действие*/) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (">>".equals(input)/*пользователь хочет повторить отмененное действие*/) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего возвращать!");
                } else {
                    curCommand++;
                    commands.get(curCommand).execute();
                }
            } else if ("!!".equals(input)/*пользователь хочет повторить действие*/) {
                /*разрешаем повторять только не отмененную команду*/
                if (curCommand == commands.size() - 1 && curCommand != -1) {
                    commands.add(commands.get(curCommand));
                    curCommand++;
                    commands.get(curCommand).execute();
                } else {
                    System.out.println("Нечего повторять!");
                }
            } else { //пользователь ввёл новое движение для лягушки
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                    while (commands.size() - 1 > curCommand) {
                        commands.remove(commands.size() - 1);
                    }
                }
                int steps = 0;

                try {
                    steps = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Неизвестная команда!");
                }

                FrogCommand cmd = null;
                if (steps > 0) {
                    cmd = FrogCommands.jumpRightCommand(frog, steps);
                } else if (steps < 0) {
                    cmd = FrogCommands.jumpLeftCommand(frog, steps * -1);
                }

                if (cmd != null) {
                    curCommand++;
                    commands.add(cmd);
                    cmd.execute();
                }
            }

            //рисуем поле после команды
            System.out.println(frog);
        }
    }
}
