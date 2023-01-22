package vova.nested_classes;

/*
    Вложенные классы могут быть:
    - статичными
    - не статичными
    - локальными - классы внутри функции
    - анонимные

    Они нужны тогда, когда внутренний (INNER) класс тестно связан с внешним (OUTER) классом и не мыслится отдельно от
    него. Является, своего рода, элементами класса. Как правило, внутренние классы имеют доступ к полям outer классов,
    даже к private полям
 */

public class IntroducingNestedClasses {
    static class IAmStatic {}                // вложен в IntroducingNestedClasses
    class IAmNotStatic {}                    // вложен в IntroducingNestedClasses

    void iKeepClassInsideMe() {
        class ClassThatLivesInsideMethod {}  // вложен в метод iKeepClassInsideMe
    }
}
