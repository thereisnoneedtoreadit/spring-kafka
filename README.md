# Сервис, созданный для изучения Apache Kafka. 

Стек:
- java 11
- spring-webflux
- apache kafka 2.4.5
- mongo db

Тело запроса:
```
{
	"name":"name",
	"description":"description",
	"time":"1587304603494"
}
```

Логика:
1. Прием запроса на /tasks (POST)
2. Отправка объекта в kafka
3. Прием того же объекта из kafka
4. Сохранение объекта в mongo

