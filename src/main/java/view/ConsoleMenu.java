package main.java.view;

import main.java.controller.DocumentService;

import java.util.Scanner;

public class ConsoleMenu {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        DocumentService documentService = new DocumentService();
        while(!str.equals("6")){
            System.out.println("1.Вывести все паспорта");
            System.out.println("2.Вывести все водительские права");
            System.out.println("3.Вывести имя и фамилию владельца паспорта по серии и номеру");
            System.out.println("4.Добавить паспорт и пользователя");
            System.out.println("5.Добавить вод.удостоверение пользователю");
            System.out.println("6.Удалить паспорт");
            System.out.println("7.Удалить вод.удостоверение");
            System.out.println("8.Выход");
            str = scanner.next();
            switch (str){
                case "1" -> documentService.getAllPassports();
                case "2" -> documentService.getAllDriveLicense();
                case "3" -> {
                    System.out.println("Введите серию паспорта");
                    int series = scanner.nextInt();
                    System.out.println("Введите номер паспорта");
                    int number = scanner.nextInt();
                    documentService.printFirstNameAndLastNameBySeriesAndNumber(series,number);
                }
                case "4" -> {
                    System.out.println("Введите имя владельца паспорта");
                    String firstName = scanner.next();
                    System.out.println("Введите фамилию владельца паспорта");
                    String lastName = scanner.next();
                    System.out.println("Введите серию паспорта");
                    int series = scanner.nextInt();
                    System.out.println("Введите номер паспорта");
                    int number = scanner.nextInt();
                    documentService.addPassport(firstName,lastName,series,number);
                }
                case "5" -> {
                    System.out.println("Введите серию паспорта");
                    int series = scanner.nextInt();
                    System.out.println("Введите номер паспорта");
                    int number = scanner.nextInt();
                    documentService.addDriveLicenseToUser(series,number);
                }
                case "6" -> {
                    System.out.println("Введите серию паспорта");
                    int series = scanner.nextInt();
                    System.out.println("Введите номер паспорта");
                    int number = scanner.nextInt();
                    documentService.removePassport(series,number);
                }
            }
        }
    }
}
