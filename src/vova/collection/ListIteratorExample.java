package vova.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static java.lang.System.*;

public class ListIteratorExample {
    public static void main(String[] args) {
        String palindrome = "апапамама амамапапа";
        List<Character> list = new LinkedList<>();
        for (char ch : palindrome.toCharArray()) {
            list.add(ch);
        }
        ListIterator<Character> listIterator = list.listIterator();
        ListIterator<Character> reversedListIterator = list.listIterator(list.size());
        boolean isPalindrome = true;
        int left = 0;
        int right = -1;
        while (listIterator.hasNext() && reversedListIterator.hasPrevious()) {
            if (!listIterator.next().equals(reversedListIterator.previous())) {
                isPalindrome = false;
                break;
            }
            if (left == right) {
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            out.println("YEP..");
        } else {
            out.println("NOPE..");
        }
    }
}
