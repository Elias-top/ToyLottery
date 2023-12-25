package view.commands;

import view.View;

public class GetListToyInfo extends Command{
    public GetListToyInfo(View view)
    {
        super("Посмотреть список игрушек", view);
    }
    public void execute()
    {
        getView().getListToyInfo();
    } 
}
