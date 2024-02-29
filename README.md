# 20220907-2

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
       