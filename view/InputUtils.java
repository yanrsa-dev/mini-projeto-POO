package view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

  private static final Scanner scanner = new Scanner(System.in);
  private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static String lerString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public static int lerInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        int valor = scanner.nextInt();
        scanner.nextLine(); // Consome o "enter" pendente
        return valor;
      } catch (InputMismatchException e) {
        System.out.println("Erro: Por favor, digite um número inteiro válido.");
        scanner.nextLine(); // Limpa o buffer do scanner
      }
    }
  }

  public static Long lerLong(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        long valor = scanner.nextLong();
        scanner.nextLine(); // Consome o "enter" pendente
        return valor;
      } catch (InputMismatchException e) {
        System.out.println("Erro: Por favor, digite um número longo válido.");
        scanner.nextLine(); // Limpa o buffer do scanner
      }
    }
  }

  public static double lerDouble(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consome o "enter" pendente
        return valor;
      } catch (InputMismatchException e) {
        System.out.println("Erro: Por favor, digite um número válido.");
        scanner.nextLine(); // Limpa o buffer do scanner
      }
    }
  }

  public static BigDecimal lerBigDecimal(String prompt) {
    while (true) {
      try {
        String input = lerString(prompt);
        return new BigDecimal(input);
      } catch (NumberFormatException e) {
        System.out.println("Erro: Por favor, digite um valor numérico válido (ex: 99.90).");
      }
    }
  }

  public static LocalDate lerLocalDate(String prompt) {
    while (true) {
      try {
        String input = lerString(prompt + " (formato dd/MM/yyyy): ");
        return LocalDate.parse(input, dateFormatter);
      } catch (DateTimeParseException e) {
        System.out.println("Erro: Formato de data inválido. Use dd/MM/yyyy.");
      }
    }
  }

  public static String lerCpf(String prompt) {
    while (true) {
      String input = lerString(prompt + " (formato xxx.xxx.xxx-xx): ");
      if (input.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
        return input;
      }
      System.out.println("Erro: Formato de CPF inválido. Use xxx.xxx.xxx-xx.");
    }
  }

  public static String lerCnpj(String prompt) {
    while (true) {
      String input = lerString(prompt + " (formato xx.xxx.xxx/xxxx-xx): ");

      if (input.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
        return input;
      }

      System.out.println("Erro: Formato de CNPJ invalido. Use xx.xxx.xxx/xxxx-xx.");
    }
  }
}
