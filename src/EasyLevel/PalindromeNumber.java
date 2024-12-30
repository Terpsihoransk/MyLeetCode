package EasyLevel;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindromeFaster(121));
        System.out.println(isPalindromeString(121));
        System.out.println(isTextPalindrome("Искать такси"));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int originalNumber = x;
        int reversedNumber = 0;

        while (x > 0) {
            // Последняя цифра из числа (остаток от деления на 10)
            int digit = x % 10;
            // Сдвигаем цифры перевёрнутого числа на один десятичный разряд влево
            reversedNumber = reversedNumber * 10 + digit;
            // Удаляем последнюю цифру из исходного числа
            x /= 10;
        }
        return originalNumber == reversedNumber;
    }

    // Быстрее потому, что мы не меняем исходное число. Но оба скоростью O(n)
    public static boolean isPalindromeFaster(int x) {
        if (x < 0)
            return false;
        int temp = x;
        int reversed = 0;
        while (temp != 0) {
            reversed = (reversed * 10) + (temp % 10);
            temp /= 10;
        }
        return reversed == x;
    }

    // Можно решить через приведение к строке
    public static boolean isPalindromeString(int x) {
        String text = String.valueOf(x);
        return text.equalsIgnoreCase(new StringBuilder(text)
                .reverse().toString());
    }

    // Чистое определение является ли строка палиндромом
    private static boolean isTextPalindrome(String word) {
        var chars = word.toLowerCase().replaceAll("\\s", "").toCharArray();
        var left = 0;
        var right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
