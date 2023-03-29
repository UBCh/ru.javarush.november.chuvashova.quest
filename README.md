# Quest
## задание
написать небольшой текстовый квест. Вопрос на каждом следующем шаге зависит от предыдущего ответа.

## реализовано
- текстовый квест,вопрос на каждом следующем шаге зависит от предыдущего ответа
- реализовано 27 успешных тестовых сценариев
- Статистика по состоянию острова через указанный  промежуток времени
- размер острова и периодичность отчета задается через графическое меню


## использовано
- MAVEN
- Servlet
- jsp
- JUnit
- log4j
- Selenide
- ALLURE
- mySql

## особенности реализации
- квест универсальный, количество уровней, содержание вопросов , правильных и неправильных ответов, содержание страниц победы и проигрыша, страницы прролога возможно любое, эти данные хранятся в базе данных, и их можно заменить на нужное содержание, образец базы данных  [bd_quest.sql]()


## запуск на локальной машине
- запустить Tomkat9
- выполнить команду run

## не удалось
- при запуске тестов командой mvn - test падает часть тестов из [LogicsServletTest]()
- не удалось настроить CI (GitHub Action)-не получилось прописать в yml запуск томкат на виртуальной машине

## 1.Перечень необходимого установленного ПО

* **Windows 10**
* **IntelliJ IDEA**
* **Java 11**
* **Tomcat 9**


## 2. Перечень сервисов (наличие зарегистрированного аккаунта)

* **Git**