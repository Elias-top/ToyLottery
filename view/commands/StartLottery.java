package view.commands;

import view.View;

public class StartLottery extends Command{
    public StartLottery(View view)
    {
        super("Запустить розыгрыш игрушек", view);
    }
    public void execute()
    {
        getView().startLottery();
    }   
}
