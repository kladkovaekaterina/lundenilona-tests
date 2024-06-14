Проект по автоматизации тестирования для веб-сайта LUNDENILONA.RU и мобильного андройд приложения LundenIlona

Сайт LUNDENILONA.RU - онлайн-магазин авторской космецевтики. 
Приложение LundenIlona - это женское приложение 6-в-1, включающее в себя расчет индивидуальной дневной калорийности, дневник питания, шагомер, планинг привлекательности, личный гормональный календарь, а также отдельный блок для беременных девушек.

Содержание:
Технологии и инструменты
Примеры автоматизированных тест-кейсов
Сборка в Jenkins
Запуск из терминала
Allure отчет
Интеграция с Allure TestOps
Интеграция с Jira
Уведомление в Telegram при помощи бота
Примеры видео выполнения тестов на Selenoid

Технологии и инструменты:

Примеры автоматизированных тест-кейсов:
APP:
Проверка успешной загрузки navigation bar
Проверка успешной загрузки главного экрана
Проверка успешной загрузки и прохождения onboarding экрана
Проверка корректного открытия окна приложения по клику на иконку
Проверка, что при негативном числе рассчитанных калорий кнопка Next не кликабельна
Проверка, что при установлении корректной информации открывается Гормональный календарь на текущую дату
Проверка, что при положительном числе рассчитанных калорий кнопка Next кликабельна и ведет на следующий экран
WEB:
Проверка успешной авторизации пользователя
Проверка заголовков в верхней части страницы
Поисковый сервер отображает страницу на первой позиции
Проверка, что регистрация неуспешна, если не пройдена капча
Проверка ответа сервера на успешную авторизацию пользователя
Проверка неуспешной авторизации пользователя из-за неверного пароля
Проверка корректного открытия статьи по клику на ссылку в заголовках
Проверка ответа сервера на неуспешную авторизацию пользователя из-за неверного пароля
При клике по ссылке на странице с результатами поиска в Google должно происходить открытие сайта

Сборка в Jenkins:

https://jenkins.autotests.cloud/job/25-KatherineMiers-lundenilona-tests/

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/e9e456e9-5e04-473e-affb-f6288dd87489)

Параметры сборки в Jenkins:
WEB:
driver - remote, local
MOBILE:
host - browserstack, emulation, real

Запуск из терминала:
WEB:
Команда для запуска на remote driver: ./gradlew clean test (или с указанием -Ddriver=remote)
Команда для запуска на local driver: ./gradlew clean test -Ddriver=local
MOBILE:
Команда для запуска на browserstack host: ./gradlew clean test (или с указанием -DdeviceHost=browserstack)
Команда для запуска на emulation host: ./gradlew clean test -DdeviceHost=emulation
Команда для запуска на real host: ./gradlew clean test -DdeviceHost=real

Allure отчет:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/ae2647b6-4a19-4739-84f8-c59f6a9c166a)


Интеграция с Allure TestOps:

https://allure.autotests.cloud/project/4286

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/4009d78c-f295-4b34-8768-4d56c6df6f9a)


Интеграция с Jira:

https://jira.autotests.cloud/browse/HOMEWORK-1263

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/d01b1a51-507f-4741-84f8-b5332eb628f8)


Уведомление в Telegram при помощи бота:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/d4f81a78-898e-4494-a743-da9b0c059cfc)


Примеры видео выполнения тестов на Selenoid:
