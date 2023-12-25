package view.commands;

import view.View;

public class AddToyToMachine extends Command{
    public AddToyToMachine(View view)
    {
        super("Добавить игрушку в розыгрыш", view);
    }
    public void execute()
    {
        getView().addToyToMachine();
    }
}
