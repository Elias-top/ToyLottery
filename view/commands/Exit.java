package view.commands;

import view.View;

public class Exit extends Command{
    public Exit(View view)
    {
        super("Выйти", view);
    }
    public void execute()
    {
        getView().exit();
    }    
}
