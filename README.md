### **Проект с примерами AOP**

###### Какие бывают Advice:

**Before Advice** - выполняется до метода с основной логикой
**After Returning** - выполняется только после нормального окончания метода с основной логикой
**After Throwing** - выполняется после окончания метода с основной логико только, если было выброшено исключение
**After / After finally** - выполняется после окончания метода с основной логикой
**Around** - выполняется до и после основного метода

###### Что такое Pointcut:
Выражение, описывающее, где должен быть применен Advice

_Шаблон Pointcut (жирным шрифтом выделены обязательные элементы)_

**execution**(modifiers-pattern? **return-type-pattern** declaring-type-pattern?
**method-name-pattern(parameters-pattern)** throws-pattern?)

     