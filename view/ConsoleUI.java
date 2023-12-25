package view;
import java.time.LocalDateTime;
import java.util.Scanner;

import file_system.FS;
import file_system.MakeLogBW;
import file_system.OOS;
import file_system.enums.StatusFileFS;
import model.ToyMachine;

public class ConsoleUI implements View{
    private Scanner scanner;
    private boolean inProgress;
    String file_path = "ToysList.out";
    String file_log_path = "LogFile.txt";
    private ToyMachine toyMachine;
    private FS fileOperationsOOS;
    private MakeLogBW makeLogBW ;
    private AdminMainMenu adminMainMenu;
    private UserMainMenu userMainMenu;
    private String user_login;

    public ConsoleUI(){
        makeLogBW = new MakeLogBW();
        fileOperationsOOS = new FS(new OOS());
        toyMachine = new ToyMachine();
        scanner = new Scanner(System.in);
        adminMainMenu = new AdminMainMenu(this);
        userMainMenu = new UserMainMenu(this);
        load();
    }

    public void start(){
        inProgress = true;
        user_login = logIn();
        while(inProgress){
            if(user_login.equals("Admin")){
                printAdminMenu();
                scanAdminInput();
            }
            else{
                printUserMenu();
                scanUserMenuInput();
            }
        }
    }

    private void scanAdminInput(){
        String choiceStr = scanner.nextLine();
        if(checkTextForInt(choiceStr))
        {
            int choice = Integer.parseInt(choiceStr);
            if(checkCommandList(choice))
            {
                adminMainMenu.execute(choice);
            }
        }
    }

    private void scanUserMenuInput(){
        String choiceStr = scanner.nextLine();
        if(checkTextForInt(choiceStr))
        {
            int choice = Integer.parseInt(choiceStr);
            if(checkCommandList(choice))
            {
                userMainMenu.execute(choice);
            }
        }
    }

    public void addToyToMachine(){
        try{
            System.out.println("Введите количество добавляемых игрушек: ");
            int count = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите шанс выподения данного типа игрушек от 0 до 100: ");
            int chance = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите название игрушки: ");
            String name = scanner.nextLine();

            toyMachine.addNewItem(count, chance, name);
        }catch (NumberFormatException e){
            System.out.println("Введены некорректные данные ");
        }
    }

    public void editChance(){
        try{
            System.out.println("Введите индекс игрушки: ");
            int index = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите новый шанс выподения данного типа игрушек от 0 до 100: ");
            int chance = Integer.parseInt(scanner.nextLine());
            toyMachine.editChanceItem(index, chance);
        }catch(NumberFormatException e){
            System.out.println("Введены некорректные данные ");
        }
    }

    public void getListToyInfo(){
        toyMachine.getListItemsInfo();
    }

    public void startLottery(){
        try{
            System.out.println("Введите id игрушки, которую хотите получить");
            int index = Integer.parseInt(scanner.nextLine());

            boolean result = toyMachine.startLottery(index);

            if(result == true){
                System.out.println("Поздравляем вы выйграли игрушку:");
                System.out.println(toyMachine.getNameItemByID(index));
                makeLogBW.writeToLogFile(file_log_path, user_login + " win toy " + toyMachine.getNameItemByID(index) + " " + LocalDateTime.now());
            }
            else{
                System.out.println("К сохалению вы проиграли :(");
                makeLogBW.writeToLogFile(file_log_path, user_login + " not win toy " + toyMachine.getNameItemByID(index) + " " + LocalDateTime.now());
            }
        }catch(NumberFormatException e){
            System.out.println("Введены некорректные данные ");
        }
    }

    public void deleteToyFromList(){
        try{
            System.out.println("Введите id игрушки, которую хотите удалить: ");
            int index = Integer.parseInt(scanner.nextLine());

            toyMachine.removeItemFromList(index);
        }catch(NumberFormatException e){
            System.out.println("Введены некорректные данные ");
        }

    }
    private void printAdminMenu(){
        System.out.println(adminMainMenu.print());
    }

    private void printUserMenu(){
        System.out.println(userMainMenu.print());
    }

    private String logIn(){
        System.out.println("Введите имя пользователя: ");
        String input_login = scanner.nextLine();
        return input_login;
    }

    public void exit(){
        save();
        this.inProgress = false;
    }

    private void save()
    {
        if(fileOperationsOOS.Save(toyMachine, file_path) == StatusFileFS.FileSaved)
        {
            System.out.println("Файл со списком игрушек успешно был сохранен");
        }
        else
        {
            System.out.println("Произошла ошибка, файл со списком игрушек не был сохранен");
        }
    }

    private void load()
    {
        if(fileOperationsOOS.IsFileExist(file_path) == true)
        {
            System.out.println("Файл с списком игрушек успешно был загружен");
            toyMachine = (ToyMachine) fileOperationsOOS.Read(file_path);
        }
        else if (fileOperationsOOS.IsFileExist(file_path) == false)
        {
             return;
        }
    }

    private void error() {
        System.out.println("Введено неверное значение!");
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            error();
            return false;
        }
    }

    private boolean checkCommandList(int itemNum)
    {
        if (itemNum <= adminMainMenu.size()){
            return true;
        } else {
            error();
            return false;
        }
    }
}
