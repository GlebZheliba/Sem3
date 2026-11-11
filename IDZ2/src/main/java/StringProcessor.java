public class StringProcessor {

    public static StringBuilder stringRepeat(String s, int N) {
        if (N < 0) {
            throw new IllegalArgumentException("The argument couldn't be less than zero.");
        }
        StringBuilder a = new StringBuilder("");
        for (int i = 0; i < N; i++) {
            a.append(s);
        }
        return a;
    }

    public static int countInsertion(String a, String b) {
        if (b == null || b.isEmpty()) {
            throw new IllegalArgumentException("The argument couldn't be empty or null.");
        }

        int count = 0;
        int pos = 0;
        while ((pos = a.indexOf(b, pos)) != -1) {
            count++;
            pos += b.length();
        }
        return count;
    }

    public static StringBuilder stringModification1(String a) {
        StringBuilder b = new StringBuilder(a);
        while ((b.indexOf("1") != -1) || (b.indexOf("2") != -1) || (b.indexOf("3") != -1)) {
            if (b.indexOf("1") != -1) {
                b.replace(b.indexOf("1"), b.indexOf("1") + 1, "один");
            }

            if (b.indexOf("2") != -1) {
                b.replace(b.indexOf("2"), b.indexOf("2") + 1, "два");
            }

            if (b.indexOf("3") != -1) {
                b.replace(b.indexOf("3"), b.indexOf("3") + 1, "три");
            }
        }
        return b;
    }

    public static StringBuilder stringModification2(StringBuilder a) {
        for (int i = a.length() - 1; i >= 0; i--) {
            if (i % 2 == 1) {
                a.deleteCharAt(i);
            }
        }

        return a;
    }

    public static StringBuilder reverseOrder(String a) {
        StringBuilder b = new StringBuilder("");
        int wStart = 0;
        boolean isWord = false;
        boolean isWord0 = false;
        int wEnd = 0;
        int start = a.length() - 1;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
                isWord0 = false;
                b.append(' ');
            } else if (isWord0 == false) {
                isWord0 = true;
                for (int j = start; j >= 0; j--) {
                    if (a.charAt(j) != ' ' && isWord == false) {
                        wEnd = j + 1;
                        isWord = true;
                    }
                    if (a.charAt(j) == ' ' && isWord == true || j == 0) {
                        wStart = (a.charAt(j) == ' ') ? j + 1 : 0;
                        start = j - 1;
                        isWord = false;
                        break;
                    }
                }
                b.append(a, wStart, wEnd);
            }
        }
        return b;
    }

    public static StringBuilder from16To10(String a) {
        StringBuilder b = new StringBuilder(a);
        int start = 0;

        while (true) {
            int idx = b.indexOf("0x", start);
            if (idx == -1) {
                break;
            }

            if (idx + 10 > b.length()) {
                break;
            }

            long num = 0;
            boolean isValid = true;

            for (int i = idx + 2; i < idx + 10; i++) {
                char ch = Character.toUpperCase(b.charAt(i));
                int digit;

                if (ch >= '0' && ch <= '9') {
                    digit = ch - '0';
                } else if (ch >= 'A' && ch <= 'F') {
                    digit = 10 + (ch - 'A');
                } else {
                    isValid = false;
                    break;
                }

                num = num * 16 + digit;
            }

            if (isValid) {
                String replacement = String.valueOf(num);
                b.replace(idx, idx + 10, replacement);
                start = idx + replacement.length();
            } else {
                start = idx + 2;
            }
        }
        return b;
    }
}