import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubstringSearch {
    /**
     * searchSubstring - создает префикс функцию
     * @param needle - строка индекс вхождения в текст которой мы ищем
     * @return - оператор возврата
     */
        public static int[] searchSubstring(String needle) {
            int m = needle.length();
            int[] pf = new int[m];
            //Вычисление префикс-функции
            for (int i = 1; i < m; i++) {
                int j = 0;
                while (i + j < m && needle.charAt(j) == needle.charAt(j + i)) {
                    pf[i + j] = Math.max(pf[i + j], j + 1);
                    j++;
                }
            }
            return pf;
        }

    /**
     * KMP - алгоритм Кнутта Морриса Пратта находит индекс первого вхождения искомой подстроки
     * @param haystack - иходный текст
     * @param needle - строка индекс вхождения в текст которой мы ищем
     * @return - оператор возврата
     * @throws IOException - общий класс исключений
     */
        public static Integer[] KMP(String haystack, String needle) throws IOException {
            Integer[] array = {};

            int n = haystack.length();
            int m = needle.length();
            if (m == 0)
                return array;
            int[] prefixF = searchSubstring(needle);
            ArrayList<Integer> found = new ArrayList<>();
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(haystack));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int sum = bufferedReader.read();
            int j = 0;
            for (int i = 0; sum != -1; i++) {
                char c = (char) sum;
                sum = bufferedReader.read();
                if (needle.charAt(j) == c) {
                    j++;
                }
                if (j == m) {
                    found.add(i - j + 1);
                    j = prefixF[j - 1];
                } else if (i < n && needle.charAt(j) != c) {
                    if (j != 0) {
                        j = prefixF[j - 1];
                    }
                }
            }

            Integer[] arr = {};
            arr = (found.toArray(arr));
            return arr;
        }
    }



