# 20220907-2
## Особенности задачи:

1. **Определить, пересекаются ли даты**

   ```java
       // не пересекаются в случае, если старт1 после конца2 ИЛИ старт2 после конца1
       public static boolean isNotOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return start1.isAfter(end2) || start2.isAfter(end1);
    }

      // условие на пересечение (де Морган)
      !start1.isAfter(end2) && !start2.isAfter(end1);
   ```

 2. **Отсортировать так, что если по первому признаку равны, сортируем по второму**
    ```java
    realties.stream()
                .sorted(Comparator
                        .comparing(Realty::getIntersections).reversed()
                        .thenComparing(Realty::getType)
                        .thenComparing(Realty::getAddress)).toList();
    ```

    
Задачи экзамена по Java 07/09/2022 - экзаменуемый 2

Вы помогаете риэлторскому агентству оптимизировать свою работу.
Начали поступать жалобы, что риелторы приводят клиентов на один объект одновременно.
Перед вами стоит задача проанализировать данные и составлять отчет по объектам, на которые чаще всего просиходят пересечения риелторов. Пересечением считается, если риелтор заходит на объект в тот момент, когда там уже находится его коллега. Нарушение идет в счет всем участникам пересечения.
 
Результат следует вывести в файл следующим образом:
   - Каждая строка имеет формат <Тип недвижимости>, <Адрес> - <количество пересечений на объекте за весь период>
   - Строки отсортированы по убыванию количества пересечений за весь период
   - Если количество пересечений совпадает, то сортируем по возрастанию типа недвижимости, затем адреса
   - Имя результирующего файла result.txt
 
На вход подается три файла:
   - employee.csv:
       - Идентификатор риелтора
       - Фамилия
       - Имя
       - Отчество
   - realty.csv
       - Идентификатор объекта недвижимости
       - Тип недвижимости
       - Адрес
   - visit.csv
       - Идентификатор риелтора
       - Идентификатор объекта недвижимости
       - Дата/время прихода на объект
       - Дата/время ухода с объекта
       
