
import java.util.*;
import java.util.stream.Collectors;

public class Notebook {
    private String name;
    private int date;
    private int ram; // ОЗУ
    private int hardDrive; // жесткий диск
    private String colour;
    private String os;

    public Notebook(String name, int date, int ram, int hardDrive, String colour, String os) {
        this.name = name;
        this.date = date;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.colour = colour;
        this.os = os;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public String getColour() {
        return colour;
    }

    public String getOs() {
        return os;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        String result = "Название: " + name + System.lineSeparator()
                + "Дата выпуска: " + date + System.lineSeparator()
                + "ОЗУ: " + ram + System.lineSeparator()
                + "Жеский диск: " + hardDrive + System.lineSeparator()
                + "Цвет: " + colour + System.lineSeparator()
                + "Операционная система: " + os + System.lineSeparator();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Notebook notebook = (Notebook) obj;
        return name.equals(notebook.name) && date == notebook.date && ram == notebook.ram
                && hardDrive == notebook.hardDrive && colour.equals(notebook.colour) && os.equals(notebook.os);

    }

    @Override
    public int hashCode() {

        return Objects.hash(name, date, ram, hardDrive, colour, os);
    }


    public static class Mag {
        List<Notebook> notebooks;
       // private List<Notebook> notebooks = new ArrayList<>();

        public Mag() {
            this.notebooks = new ArrayList<>();
        }

        public void addNotebook(Notebook notebook) {
            notebooks.add(notebook);
        }


        public List<Notebook> filterNotebooks(Map<String, String>kriterii) {

            return notebooks.stream()
                    .filter(notebook -> kriterii.entrySet().stream()
                            .allMatch(entry -> {
                                try {
                                    switch (entry.getKey()) {
                                        case "Название":
                                            return notebook.getName().equalsIgnoreCase(entry.getValue());
                                        case "Дата выпуска":
                                            return notebook.getDate() == Integer.parseInt(entry.getValue());
                                        case "ОЗУ":
                                            return notebook.getRam() == Integer.parseInt(entry.getValue());
                                        case "ОбъемЖД":
                                            return notebook.getHardDrive() == Integer.parseInt(entry.getValue());
                                        case "Операционная Система":
                                            return notebook.getOs().equalsIgnoreCase(entry.getValue());
                                        case "Цвет":
                                            return notebook.getColour().equalsIgnoreCase(entry.getValue());
                                        default:
                                            return true;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Ошибка ввода: " + e.getMessage());
                                    return false;
                                }
                            }))
                    .collect(Collectors.toList());
        }

        public void zapros() {
            Scanner scanner = new Scanner(System.in);
            Map<String, String> kriterii = new HashMap<>();

            System.out.println("Сколько критериев вы хотите задать?");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите число.");
                scanner.next(); // очистка некорректного ввода
            }
            int count = scanner.nextInt();

            for (int i = 0; i < count; i++) {
                System.out.println("Введите цифру, соответствующую необходимому критерию:");
                System.out.println("1 - Название");
                System.out.println("2 - год выпуска");
                System.out.println("3 - ОЗУ");
                System.out.println("4 - Объем жесткого диска");
                System.out.println("5 - Операционная система");
                System.out.println("6 - Цвет");

                while (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: введите число.");
                    scanner.next(); // очистка некорректного ввода
                }


                int vibor = scanner.nextInt();
                switch (vibor) {
                    case 1:
                        System.out.println("Введите название:Fly, Samsung, Aser, Asus,HP");
                        kriterii.put("Название", scanner.next());
                        break;
                    case 2:
                        System.out.println("Введите год выпуска:2021, 2022, 2023, 2024");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ошибка: введите число.");
                            scanner.next(); // очистка некорректного ввода
                        }
                        kriterii.put("Дата выпуска", scanner.next());
                        break;

                    case 3:
                        System.out.println("Введите минимальное значение ОЗУ: 8, 16, 32, 64");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ошибка: введите число.");
                            scanner.next(); // очистка некорректного ввода
                        }
                        kriterii.put("ОЗУ", scanner.next());
                        break;
                    case 4:
                        System.out.println("Введите минимальный объем ЖД:128, 256, 512 ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ошибка: введите число.");
                            scanner.next(); // очистка некорректного ввода
                        }
                        kriterii.put("ОбъемЖД", scanner.next());
                        break;
                    case 5:
                        System.out.println("Введите название операционной системы: Windows, Linux");
                        kriterii.put("Операционная Система", scanner.next());
                        break;
                    case 6:
                        System.out.println("Введите цвет: blue, black, red");
                        kriterii.put("Цвет", scanner.next());
                        break;
                    default:
                        System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 6.");
                        i--;
                        continue;
                }


                List<Notebook> filteredNotebooks = filterNotebooks(kriterii);
                if (filteredNotebooks.isEmpty()) {
                    System.out.println("По заданным критериям ноутбуки не найдены.");
                } else {
                    filteredNotebooks.forEach(notebook -> System.out.println(notebook));
                }
            }
        }
    }
}





