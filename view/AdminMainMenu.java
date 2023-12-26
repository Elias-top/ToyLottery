package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.AddToyToMachine;
import view.commands.Command;
import view.commands.DeleteToyFromList;
import view.commands.EditChance;
import view.commands.Exit;
import view.commands.GetListToyInfo;
import view.commands.StartLottery;

public class AdminMainMenu {
    private List<Command> commandList;

    public AdminMainMenu(View view)
    {
        commandList = new ArrayList<>();
        commandList.add(new AddToyToMachine(view));
        commandList.add(new DeleteToyFromList(view));
        commandList.add(new EditChance(view));
        commandList.add(new GetListToyInfo(view));
        commandList.add(new StartLottery(view));
        commandList.add(new Exit(view));
    }
    
    public String print()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список доступных комманд:\n");
        for (int i = 0; i < commandList.size(); i++)
        {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public void execute(int choice)
    {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int size()
    {
        return commandList.size();
    }
}
