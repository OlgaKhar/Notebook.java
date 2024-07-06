public class Main {
    public static void main(String[] args) {
        Notebook.Mag store = new Notebook.Mag();
        // Создание нового ноутбука и добавление его в магазин
        Notebook notebook1 = new Notebook("Fly", 2024, 16, 256, "blue", "Windows");
        Notebook notebook2 = new Notebook("Asus", 2024, 64, 512, "white", "Windows");
        Notebook notebook3 = new Notebook("Acer", 2024, 64, 256, "black", "Linux");
        Notebook notebook4 = new Notebook("Samsung", 2023, 8, 128, "black", "Windows");
        Notebook notebook5 = new Notebook("Fly", 2022, 32, 512, "red", "Windows");
        Notebook notebook6 = new Notebook("Samsung", 2024, 16, 256, "blue", "Windows");
        Notebook notebook7 = new Notebook("Asus", 2024, 8, 128, "black", "Linux");
        Notebook notebook8 = new Notebook("HP", 2021, 32, 256, "red", "Windows");
        Notebook notebook9 = new Notebook("Asus", 2024, 8, 128, "black", "Linux");


                store.addNotebook(notebook1);
                store.addNotebook(notebook2);
                store.addNotebook(notebook3);
                store.addNotebook(notebook4);
                store.addNotebook(notebook5);
                store.addNotebook(notebook6);
                store.addNotebook(notebook7);
                store.addNotebook(notebook8);
                store.addNotebook(notebook9);

                // Вызов метода для запроса фильтров и вывода ноутбуков
                store.zapros();
            }
        }


