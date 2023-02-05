package vova.nested_classes;

import static java.lang.System.*;

public class AnonymousClassExample {
    public static void main(String[] args) {

        /*
         Я не создаю объект интерфейса (как утверждают на собеседованиях). Я создаю объект анонимного класса,
         т.е. всё то, что я бы делал при создании Local Inner класса
         Другими словами, я создаю класс, который имплементирует интерфейс IMathForAnonymousClass
         и всё это я пишу в одном стейтменте
         */

        IMathForAnonymousClass m = new IMathForAnonymousClass() {
            int c = 10;
            void abc() {
                out.println(doOperation(3, 4) * c);
            }
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };

        IMathForAnonymousClass m2 = new IMathForAnonymousClass() {
            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }
        };
        out.println(m2.doOperation(3, 4));
        out.println(m.doOperation(3, 4));
    }
}

interface IMathForAnonymousClass {
    int doOperation(int a, int b);
}
