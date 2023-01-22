package vova.nested_classes;

/*
    Вложенные классы могут быть:
    - статичными
    - не статичными
    - локальными - классы внутри функции
    - анонимные
 */

public class IntroducingNestedClasses {
    static class IAmStatic {}                // вложен в IntroducingNestedClasses
    class IAmNotStatic {}                    // вложен в IntroducingNestedClasses

    void iKeepClassInsideMe() {
        class ClassThatLivesInsideMethod {}  // вложен в метод iKeepClassInsideMe
    }
}
