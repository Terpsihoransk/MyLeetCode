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
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }
        return originalNumber == reversedNumber;
    }

    // Быстрее потому, что мы не меняем исходное число. Но оба скоростью O(n)
    public static boolean isPalindromeFaster(int x) {
        if (x < 0)
            return false;
        int originalNumber = x;
        int reversedNumber = 0;

        while (x > 0) {
            reversedNumber = (reversedNumber * 10) + (x % 10);
            x = x / 10;
        }
        return reversedNumber == originalNumber;
    }

    // Можно решить через приведение к строке
    public static boolean isPalindromeString(int x) {
        String text = String.valueOf(x);
        return text.equalsIgnoreCase(new StringBuilder(text)
                .reverse()
                .toString());
    }

    // Чистое определение является ли строка палиндромом
    private static boolean isTextPalindrome(String word) {
        var chars = word
                .toLowerCase()
                .replaceAll("\\s", "")
                .toCharArray();
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
    /**
     * Преобразование в строку String.valueOf(x): Эта операция зависит от количества цифр в числе x.
     * В худшем случае (для очень больших чисел) ее сложность можно считать как O(log10(n)),
     * где n - значение числа. Однако, эта операция выполняется за константу времени.
     * toLowerCase() и replaceAll("\\s", ""): Эти операции работают со строкой, сложность этих операций зависит от длины строки,
     * но в нашем случае длина строки пропорциональна количеству цифр в исходном числе, поэтому это также O(log10(n)).
     * replaceAll может быть несколько медленнее из-за использования регулярных выражений, но порядок сложности остается тем же.
     * toCharArray(): Эта операция также зависит от длины строки, а значит, и от количества цифр в числе, и имеет сложность O(log10(n)).
     * Цикл while (left < right): В этом цикле мы сравниваем символы с левого и правого края строки.
     * В худшем случае цикл выполняется примерно n/2 раз, где n — количество символов в строке.
     * Поэтому, асимптотическая сложность цикла — O(n). Но так как n пропорционально количеству цифр в числе, то это можно также считать как O(log10(n)).
     */
}
