package view.commands;

import view.View;

public class DeleteToyFromList extends Command{
    public DeleteToyFromList(View view)
    {
        super("Удалить игрушку из списка", view);
    }
    public void execute()
    {
        getView().deleteToyFromList();
    }
}
