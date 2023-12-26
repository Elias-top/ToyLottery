# Формулировка задания 
Необходимо написать программу – розыгрыша игрушек в магазине детских товаров.
Приложение консольное. Программа должна уметь заходить в аккаунт пользователя для получения приза (можно реализовать вход только по логину).
Если логин совпадает с "Admin", то данный пользователь должен уметь:
- Добавлять игрушку в розыгрыш;
- Удалять игрушку из розыгрыша;
- Редактировать шанс выпадения игрушки;
- Просматривать список игрушек;
- Уметь участвовать в розыгрыше;
Если логин не совпадает с "Admin", то данный пользователь должен уметь:
- Просматривать список игрушек;
- Уметь участвовать в розыгрыше;
Программа должна сохранять список игрушек добавленный "Admin", а также отнимать игрушку от общего количества в случае, если ее выйграли.
Результат розыгршей должен сохраняться в файл.
# Структура проекта
Проект сделан в MVP паттерне.
- Main - стартовый файл, создает объект главного меню и вызывает метод начало работы с меню.
- LogFile.txt - имеет логированную информацию о проведении розыгршей в формате (USER_LOGIN win/not win toy ANY_TOY yyyy-mm-ddTh:m:s).
- ToysList.out - файл в который сохраняется изменения списка игрушек (!Примечание! сохранения происходит после корректного выхода из приложения. Загрузка происходит автоматически после запсука приложения)
## Компонент VIEW имеет следующие файлы:
- UserMainMenu - реализован базовый функционал главного меню для обычного пользователя в консоле для работы с доступными командами для его участия в розыгрыше.
- AdminMainMenu - реализован базовый функционал главного меню для администратора в консоле для работы с доступными командами для редактирования розыгрыша.
- View - интерфейс команд, который должен уметь реализовывать UI.
- ConsoleUI - в нем находятся реализация консольного интерфейса и вызов команд через Presenter (реализует интерфейс View).
- commands.py - файл в котором реализован функционал команд: (Добавление заметки, чтение заметок с форматированием по дате создания/изменения,)
- Директория commands содержит все доступные команды и их описание в консольном меню.
## Компонент PRESENTER имеет следующие файлы:
- Presenter - Необходим для связи между model (реализацией оснвоного функционала) и его вызова из View.
## Компонент MODEL имеет следующие файлы:
  - SlotMachineInt - интерфейс команд, который должен уметь реализовывать машина для розыгрша призов:
    - Добавление приза;
    - Просмотр всех доступных призов;
    - Редактирование шанса выпадения приза;
    - Проведение розыгрыша приза;
    - Удаление приза из списка достпуных;
  - Toy - файл объекта(сущности) приза;
  - ToyMachine - объект описывающий все команды для розыгрыша игрушек (реализует интерфйес SlotMachineInt);
  - Директория service содержит файл Service, в котором реализован вызов всех команд файла ToyMachine. Необходим для связи с Presenter 
## Директория file_system 
Cодержит файлы для создания файла отслеживания проведения розыгрышей (интерфйес Logable и его реализация в MakeLogBW), а также файлы для сохранения объектов серилизации.
# Дополнительно используемые библиотеки
- LocalDateTime - для формирования даты и времени в log-файле
- Scanner - для ввода информации с консоли 
- ArrayList\List - для работы массивами данных
- Serializable - для сохранения списка объектов игрушек в розыгрыше
- File - для создания файлов
- BufferedWriter - для созадния записей в файлах
# Примечание
Для работы с проектом была использован Java версии 17
