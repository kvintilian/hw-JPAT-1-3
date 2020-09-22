public class FrogCommands {
    public static FrogCommand jumpRightCommand(final Frog frog, final int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            @Override
            public boolean execute() {
                return frog.jump(steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(steps * -1);
            }
        };
    }

    public static FrogCommand jumpLeftCommand(final Frog frog, final int steps) {
        return new FrogCommand() {
            @Override
            public boolean execute() {
                return frog.jump(steps * -1);
            }

            @Override
            public boolean undo() {
                return frog.jump(steps);
            }
        };
    }
}
