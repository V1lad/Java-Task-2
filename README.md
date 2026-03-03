# Java-task-2

Выполненное домашнее задание №2



## Что внутри

```
src/main/java/ru/bmstu/yabd/
├── Application.java            ✅ готов
├── model/
│   └── Order.java              ✅ готов
├── service/
│   └── OrderService.java       ✅ готов
└── controller/
    └── OrderController.java    ✅ готов
```

## Как запустить

```bash
./gradlew bootRun
```

Проверка после починки:

```bash
# создать заказ
curl -s -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{"product":"Laptop","quantity":1,"price":1299.99}'

# список заказов
curl -s http://localhost:8080/api/orders

# статистика
curl -s http://localhost:8080/api/orders/stats
```
---
## Чеклист самопроверки


- [x] `./gradlew bootRun` запускается без ошибок
- [x] POST создаёт заказ и возвращает JSON с `id`
- [x] GET `/api/orders` возвращает список всех заказов
- [x] GET `/api/orders/{id}` возвращает конкретный заказ
- [x] PUT обновляет заказ
- [x] DELETE удаляет заказ, ответ — 204
- [x] GET `/api/orders/stats` показывает количество и сумму
