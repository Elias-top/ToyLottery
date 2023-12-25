package view.commands;

import view.View;

public class EditChance extends Command{
    public EditChance(View view)
    {
        super("Редактировать шанс выподения игрушки", view);
    }
    public void execute()
    {
        getView().editChance();
    }    
}
