import java.util.Scanner;
/**
 * Lesson2
 */
//
// 1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
// 2. *Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
// 3. *Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
// 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
// 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
// 6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
// 7. **Сравнить время выполнения пункта 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

public class Lesson2 {

    public static String Reverse (String str){
        if (str == null ||str.length()<=1) return (str);
        return Reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {

            //1
        System.out.println("1. Проверяем является ли одна строка окном другой строки");
        String sourse = "Deep blue sea";
        System.out.println ( "Исходный текст: " + sourse);
        Scanner scannerWindow = new Scanner (System.in);
        System.out.printf("Введите текст для проверки: ");
        String window = scannerWindow.nextLine();
        System.out.println(sourse.contains(window) + "\n");

        //2
         System.out.println("2. Проверяем являются ли две данные строки вращением друг друга");
         String pozitiv = "Red dress";
         System.out.println ( "Исходный текст: " + pozitiv);
         String negativ = new StringBuilder(pozitiv).reverse().toString();
         //System.out.println ("Вращение: " + negativ);
         Scanner scannerNegativ = new Scanner (System.in);
         System.out.printf("Введите текст для проверки: ");
         String neg = scannerNegativ.nextLine();
         System.out.println(negativ.equals(neg) +"\n");

       //3
        System.out.println("3. Возвращаем перевернутую строку");
        String origin = "Black dress";
        System.out.println("Исходный текст: " + origin);
        System.out.println("Перевёрнутый текст: " + Reverse(origin) + "\n");

        //4
        System.out.println("4. Запись результатов вычислений с помощью метода StringBuilder.append()");
        int a = 3;
        int b = 56;
        int sum = a+b;
        int mult = a*b;
        int sub = a-b;
        StringBuilder calc = new StringBuilder();
        calc.append(a + " + " + b +  " = " + sum + "\n");
        calc.append(a + " - " + b +  " = " + sub + "\n");
        calc.append(a + " * " + b +  " = " + mult + "\n");
         System.out.println(calc);

        //5
        System.out.println("5. Заменить символ '=' словом 'равно' ");
        for (int i = calc.indexOf("="); i <calc.lastIndexOf("="); i++){
        calc = calc.insert(calc.indexOf("="), "равно");
        calc = calc.deleteCharAt(calc.indexOf("="));}
        System.out.println(calc);


        //6
        System.out.println("6. Другой способ заменить символ '=' словом 'равно' ");
        StringBuilder calc1 = new StringBuilder();
        calc1.append(a + " + " + b +  " = " + sum + "\n");
        calc1.append(a + " - " + b +  " = " + sub + "\n");
        calc1.append(a + " * " + b +  " = " + mult + "\n");
        for (int i = calc1.indexOf("="); i <calc1.lastIndexOf("="); i++){
        calc1 = calc1.replace(calc1.indexOf("="), calc1.indexOf("=")+1, "равно");}
        System.out.println(calc1);


        //7
        System.out.println("7. Сравнить время выполнения замены подстроки средствами String и StringBuilder");
        String strTime = new String();
        for (int i = 0; i<10000; i++)
        {strTime = strTime + "=";}
        StringBuilder stringBuilderTime = new StringBuilder();
        for (int i = 0; i<10000; i++)
        {stringBuilderTime.append("=");}
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i <strTime.length(); i++){
            strTime = strTime.replace("=", "равно");}
        end = System.currentTimeMillis();
        System.out.println("String:");
        System.out.println(end-start);

        start = System.currentTimeMillis();
        for (int i = stringBuilderTime.indexOf("="); i <stringBuilderTime.lastIndexOf("="); i++){
            stringBuilderTime = stringBuilderTime.replace(stringBuilderTime.indexOf("="), stringBuilderTime.indexOf("=")+1, "равно");}
        end = System.currentTimeMillis();
        System.out.println("StringBuilder:");
        System.out.println(end-start);

    }}







