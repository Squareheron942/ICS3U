import java.util.Scanner;

public class Main {
    static Scanner cin = new Scanner(System.in);
    static char[] allowedTypes = {'P', 'M', 'C', 'G', 'A', 'R'},
    blue = {'P', 'M', 'G'},
    black = {'C', 'A'},
    garbage = {'R'};
    public static void main(String[] args) {

        int n = cin.nextInt();
        cin.nextLine();

        char[][] batches = getBatches(n);

        char charToCount = cin.nextLine().charAt((0));
        int groupSize = cin.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(countItem(batches[i], charToCount));
            System.out.print(' ');
            System.out.print(checkBatch(batches[i]));
            System.out.print(' ');
            System.out.print(primaryCategory(batches[i]));
            System.out.print(' ');
            System.out.print(separateBatch(batches[i], groupSize).length);
            System.out.print(' ');
            System.out.print(isSpoiled(batches[i]));
            System.out.println();
        }

        cin.close();
    }

    static boolean contains(char[] array, char character) {
        for (int i = 0; i < array.length; i++) if (array[i] == character) return true;

        return false;
    }

    static char[][] getBatches(int num) {
        char[][] batches = new char[num][];
        for (int i = 0; i < num; i++) {
            char[] batch = cin.nextLine().toCharArray();
            batches[i] = batch;
        }
        return batches;
    }

    // works
    static int countItem(char[] batch, char item) {
        int count = 0;
        // iterate through and compare each character to given one
        for (int i = 0; i < batch.length; i++) {
            count += batch[i] == item ? 1 : 0;
        }
        return count;
    }

    static boolean checkBatch(char[] batch) {
        for (int i = 0; i < batch.length; i++) if (!contains(allowedTypes, batch[i])) return false;
        return true;
    }

    static String primaryCategory(char[] batch) {
        int[] cat = {0, 0, 0, 0};
        String[] catNames = {"Blue", "Black", "Garbage", "Unidentified"};

        for (int i = 0; i < batch.length; i++) {
            if (contains(blue, batch[i])) cat[0]++;
            else if (contains(black, batch[i])) cat[1]++;
            else if (contains(garbage, batch[i])) cat[2]++;
            else cat[3]++;
        }

        int max = 0, maxCat = 0;
        for (int i = 0; i < 4; i++) {
            if (cat[i] > max) {
                max = cat[i];
                maxCat = i;
            }
        }

        return catNames[maxCat];
    }

    static boolean isSpoiled(char[] batch) {
        int numSpoiled = 0;
        for (int i = 0; i < batch.length; i++) {
            if (!contains(allowedTypes, batch[i]) || batch[i] == 'R') numSpoiled++;
        }
        return numSpoiled / (float)batch.length > 0.1;
    }

    static String[] separateBatch(char[] batch, int groupSize) {
        String items = new String(batch);
        String[] groups = new String[(int)Math.ceil(batch.length / groupSize)];
        for (int i = 0; i < (int)Math.ceil(batch.length / groupSize); i++) {
            if (items.length() >= 2) {
                groups[i] = items.substring(0, groupSize - 1);
                items = items.substring(groupSize);
            } else {
                groups[i] = items;
            }
        }
        return groups;
    }
}