## Проект по автоматизации тестирования для веб-сайта [LUNDENILONA.RU](https://lundenilona.ru/) и мобильного андроид приложения LundenIlona
<p align="center">
<a href="https://lundenilona.ru/"> <img src="media/logos/li.png" width="130" height="33"/></a>
</p>

* Сайт LUNDENILONA.RU - онлайн-магазин авторской космецевтики, существующий с 2011 года.
* Приложение LundenIlona - это женское приложение 6-в-1, включающее в себя расчет индивидуальной дневной калорийности, дневник питания, шагомер, планинг привлекательности, личный гормональный календарь, а также отдельный блок для беременных девушек.

### Основные особенности проекта:
- Проект состоит из веб-тестов (UI), API тестов и мобильных тестов (Android)
- Для локального запуска есть зозможность запустить как все тесты, так и отдельно WEB (UI + API) и MOBILE
- Для локального запуска в дефолтном режиме (без указания ключей) браузер запускается в <code>Selenoid</code>, приложение в <code>Browserstack</code>
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота

### Навигация:
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Список автоматизированных тест-кейсов</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#mobile">Особенности запуска мобильных тестов</a>
* <a href="#jenkins">Запуск тестов из Jenkins</a>
* <a href="#telegram">Уведомление в Telegram при помощи бота</a>
* <a href="#allure">Allure отчет</a>
* <a href="#video">Видео пример прохождения тестов на Selenoid</a>
* <a href="#allure-testops">Интеграция Jenkins с Allure TestOps</a>
* <a href="#jira">Интеграция Allure TestOps с Jira</a>
____


### <a id="tools" style="color:black">Технологии и инструменты</a>
<p align="center">
<a href="https://www.java.com/">                      <img src="media/logos/java-original.svg"            width="45" height="45"    title="Java"/></a> 
<a href="https://www.jetbrains.com/idea/">            <img src="media/logos/intellij-original.svg"        width="45" height="45"    title="IntelliJ IDEA"/></a>   
<a href="https://gradle.org/">                        <img src="media/logos/gradle-original.svg"          width="45" height="45"    title="Gradle"/></a>
<a href="https://junit.org/junit5/">                  <img src="media/logos/junit-original.svg"           width="45" height="45"    title="JUnit 5"/></a>
<a href="https://selenide.org/">                      <img src="media/logos/selenide-original.svg"        width="45" height="45"    title="Selenide"/></a>  
<a href="https://rest-assured.io/">                   <img src="media/logos/restassured-original.png"     width="45" height="45"    title="Rest Assured"/></a>
<a href="https://github.com/">                        <img src="media/logos/github-original.svg"          width="45" height="45"    title="Github"/></a>
<a href="https://www.jenkins.io/">                    <img src="media/logos/jenkins-original.svg"         width="45" height="45"    title="Jenkins"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="media/logos/allure-original.svg"          width="45" height="45"    title="Allure"/></a> 
<a href="https://web.telegram.org/a/">                <img src="media/logos/telegram-original.svg"        width="45" height="45"    title="Telegram"/></a>
<a href="https://aerokube.com/selenoid/">             <img src="media/logos/selenoid-original.svg"        width="45" height="45"    title="Selenoid"/></a>  
<a href="https://www.browserstack.com/">              <img src="media/logos/browserstack-original.png"    width="45" height="45"    title="Browserstack"/></a>
<a href="https://appium.io/docs/en/latest/">          <img src="media/logos/appium-original.png"          width="45" height="45"    title="Appium"/></a>
<a href="https://developer.android.com/studio">       <img src="media/logos/androidstudio-original.svg"   width="45" height="45"    title="Android Studio"/></a>
<a href="https://qameta.io/">                         <img src="media/logos/alluretestops-original.svg"   width="45" height="45"    title="Allure TestOps"/></a>   
<a href="https://www.atlassian.com/ru/software/jira"> <img src="media/logos/jira-original.svg"            width="45" height="45"    title="Jira"/></a>  
</p>

- Используемый стек:
  - <code>Java</code> - автотесты написаны на Java
  - <code>Gradle</code> - инструмент автоматизации сборки
  - <code>JUnit 5</code> - фреймворк для выполнения автотестов
  - <code>Selenide</code> - фреймворк для тестирования WEB и MOBILE
  - <code>Rest Assured</code> - фреймворк для тестирования REST-API
  

- Используемая инфраструктура:
  - <code>Github</code> - хранение кода
  - <code>Jenkins</code> - CI/CD для запуска тестов удаленно
  - <code>Allure</code> - визуализация результатов тестирования
  - <code>Telegram Bot</code> - инструмент для отправки результатов тестирования
  - <code>Selenoid</code> - ферма для удаленного запуска браузера в Docker контейнерах
  - <code>Browserstack</code> - ферма для удаленного запуска мобильных тестов
  - <code>Appium</code>, <code>Android Studio</code> - ПО для запуска мобильных тестов локально и на эмуляторе


- Интеграции:
  - <code>Allure TestOps</code> - тест менеджмент система
  - <code>Jira</code> - инструмент управления проектом


- Генерация данных: <code>Faker</code>


- Параметризация: <code>Owner</code>


### <a id="cases" style="color:black"><img src="media/logos/alluretestops-original.svg" width="20" height="20"/> Список автоматизированных тест-кейсов</a>
WEB:
- [Проверка главной страницы сайта:](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/web/tests/MainPageTests.java)
  - Проверка заголовков в верхней части страницы
  - Проверка, что регистрация неуспешна, если не пройдена капча
  - Проверка корректного открытия статьи по клику на ссылку в заголовках (параметризованный тест)
- [Проверка работы сервера в модуле авторизации:](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/web/tests/AuthorizationApiTests.java)
  - Проверка ответа сервера на успешную авторизацию пользователя
  - Проверка ответа сервера на неуспешную авторизацию пользователя из-за неверного пароля
- [Проверка действий пользователя в модуле авторизации:](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/web/tests/AuthorizationUiTests.java)
  - Проверка успешной авторизации пользователя
  - Проверка неуспешной авторизации пользователя из-за неверного пароля
- [Проверка корректности отображения информации в поисковых сервисах:](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/web/tests/SearchEngineTests.java)
  - Поисковый сервер отображает страницу на первой позиции (параметризованный тест)
  - При клике по ссылке на странице с результатами поиска в Google должно происходить открытие сайта

MOBILE:
- [Проверка onboarding экрана:](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/mobile/tests/OnboardingScreenTests.java)
  - Проверка успешной загрузки и прохождения onboarding экрана
- [Проверка главной страницы приложения:](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/mobile/tests/AppMainPageTests.java)
  - Проверка успешной загрузки navigation bar
  - Проверка успешной загрузки главного экрана
  - Проверка корректного открытия окна приложения по клику на иконку (параметризованный тест)
- [Проверка  модуля 'Гормональный календарь':](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/mobile/tests/HormonalCalendarTests.java)
  - Проверка, что при установлении корректной информации открывается Гормональный календарь на текущую дату 
- [Проверка  модуля 'Расчет калорий':](https://github.com/kladkovaekaterina/lundenilona-tests/blob/main/src/test/java/mobile/tests/CaloriesCalculationTests.java)
  - Проверка, что при негативном числе рассчитанных калорий кнопка Next не кликабельна
  - Проверка, что при положительном числе рассчитанных калорий кнопка Next кликабельна и ведет на следующий экран


### <a id="console" style="color:black"><img src="media/logos/intellij-original.svg" width="20" height="20"/> Запуск тестов из терминала</a>

Проект можно скачать на локальную машину и запускать тесты через терминал.

*Если необходимо запустить отдельно WEB или MOBILE тесты:*

WEB:
- Команда для запуска на selenoid ферме:
  ```bash  
  ./gradlew clean web_test -Ddriver=remote
  ```
- Команда для запуска на локальном браузере:
  ```bash  
  ./gradlew clean web_test -Ddriver=local
  ```

MOBILE (у запуска мобильных тестов есть особенности, см. раздел "Особенности запуска мобильных тестов" ниже):
- Команда для запуска на browserstack ферме:
  ```bash  
  ./gradlew clean mobile_test -DdeviceHost=browserstack
  ```
- Команда для запуска на эмуляторе:
  ```bash  
  ./gradlew clean mobile_test -DdeviceHost=emulation
  ```
- Команда для запуска на реальном устройстве:
  ```bash  
  ./gradlew clean mobile_test -DdeviceHost=real
  ```

*Если необходимо запустить все тесты:*

  - Команда для запуска с указанием ключей deviceHost (browserstack, emulation, real) и driver (remote, local) (у запуска мобильных тестов есть особенности, см. раздел "Особенности запуска мобильных тестов" ниже)
    ```bash  
    ./gradlew clean test -DdeviceHost=*указать значение* -Ddriver=*указать значение*
    ```

  - Команда для запуска без указания ключей (все тесты запустятся по дефолту на удаленных фермах: WEB на selenoid ферме, MOBILE на browserstack ферме)
    ```bash  
    ./gradlew clean test
    ```


### <a id="mobile" style="color:black"><img src="media/logos/appium-original.png" width="20" height="20"/> Особенности запуска мобильных тестов</a>

EMULATION (-DdeviceHost=emulation)

Для того, чтобы на локальной машине корректно запустить мобильные тесты на эмуляторе, необходимо:

- Установить необходимое ПО по [инструкции](https://autotest.how/appium-setup-for-local-android-tutorial-md)
- Открыть <code>Andoid Studio</code>, в нем открыть Virtual Device Manager
- Запустить образ Pixel 4 API 30 (Android 11.0 "R"), нажав на кнопку "Start" справа от названия образа (поскольку этот образ прописан в owner .properties проекта)
- Открыть командную строку и ввести команду appuim
- Запустить тесты

REAL (-DdeviceHost=real)

Для того, чтобы на локальной машине корректно запустить мобильные тесты на реальном устройстве, необходимо:

- Установить необходимое ПО по [инструкции](https://autotest.how/appium-setup-for-local-android-tutorial-md)
- Подключить реальное устройство через USB к локальной машине, на которой будут запускаться тесты
- Открыть командную строку и через нее зайти в директорию platform-tools (там, где установлена SDK (например, C:\Users\user\AppData\Local\Android\Sdk\platform-tools))
- Ввести команду ./adb devices (результат выполнения команды: слева отображается номер deviceName, справа слово device)
- Изменить значение device.name в resources/mobile/host/real.properties на номер deviceName из предыдущего шага
- Открыть командную строку и ввести команду appuim
- Запустить тесты


### <a id="jenkins" style="color:black"><img src="media/logos/jenkins-original.svg" width="20" height="20"/> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/25-KatherineMiers-lundenilona-tests/)</a>

Для того, чтобы тесты можно было запускать независимо от кого-либо, в <code>Jenkins</code> реализована джоба для удаленного запуска.

Основная страница сборки:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/e9e456e9-5e04-473e-affb-f6288dd87489)

#### <a name="Запуск сборки в Jenkins" style="color:black">Запуск сборки в Jenkins:</a>

Чтобы запустить сборку в Jenkins необходимо:

- С левой стороны страницы нажать на кнопку "Build with Parameters"
- Выбрать параметры в соответствии с пуктом "Параметры сборки в Jenkins" описанным ниже
- Нажать на кнопку Build

#### <a name="Параметры сборки в Jenkins" style="color:black">Параметры сборки в Jenkins:</a>

Для запуска сборки необходимо указать требуемые параметры.

WEB:
- DRIVER
  - remote (веб тесты запустятся на selenoid ферме)
   
MOBILE:
- HOST
  - browserstack (мобильные тесты запустятся на browserstack ферме)

### &nbsp;
### <a id="telegram" style="color:black"><img src="media/logos/telegram-original.svg" width="20" height="20"/> Уведомление в Telegram при помощи бота</a>

После завершения прогона автотестов, в соответствии с настройками в <code>Jenkins</code>, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом прохождения автотестов.

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/d4f81a78-898e-4494-a743-da9b0c059cfc)

<p id="allure-anchor" style="margin-top: -100px; padding-top: 100px;"></p>

### <a id="allure" style="color:black"><img src="media/logos/allure-original.svg" width="20" height="20"/> Allure [отчет](https://jenkins.autotests.cloud/job/25-KatherineMiers-lundenilona-tests/allure/)</a>

После завершения прогона автотестов, в соответствии с настройками в <code>Jenkins</code>, сформируется Allure отчет. Для просмотра отчета необходимо в Jenkins в окне "Build History" нажать на значок Allure, расположенный справа от номера билда. 

Пример основной страницы Allure отчёта: 

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/ae2647b6-4a19-4739-84f8-c59f6a9c166a)


### <a id="video" style="color:black"><img src="media/logos/selenoid-original.svg" width="20" height="20"/> Видео пример прохождения тестов на Selenoid</a>

Для дальнейшего анализа результатов прохожения автотестов в Allure отчете можно переключиться на вкладку "Behaviors". 
К каждому UI и MOBILE тесту в отчете прилагается:
- видео прогона
- скриншот в момент окончания автотеста
- логи браузерной консоли
- page source

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/9c25dc4f-a6c6-41ab-9d9b-d4b0e30d69ad)

Видео пример прохождения тестов на WEB:

<p align="left">
  <img title="web" src="media/gifs/web.gif">
</p>

Видео пример прохождения тестов на MOBILE:

<p align="left">
  <img title="mobile" src="media/gifs/mobile.gif">
</p>


### <a id="allure-testops" style="color:black"><img src="media/logos/alluretestops-original.svg" width="20" height="20"/> Интеграция Jenkins с [Allure TestOps](https://allure.autotests.cloud/project/4286)</a>

Для того, чтобы поддерживать концепцию test cases as documentation, в соответствии с настройками в <code>Jenkins</code>, в проекте реализована интеграция <code>Jenkins</code> с TMS <code>Allure TestOps</code>. Таким образом ручной тестировщик может создавать в ней ручные тест-кейсы, а автотестировщик может создавать автотесты с Allure шагами и выгружать их в нее. Для этого необходимо:
- Запустить сборку в Jenkins и дождаться ее выполнения
- Зайти на страницу Allure TestOps во вкладку [Launches](https://allure.autotests.cloud/project/4286/launches)
- С правой стороны от названия запуска нажать на кнопку "Close launch"
- Переключиться на вкладку [Test cases](https://allure.autotests.cloud/project/4286/test-cases)
- Можно будет увидеть, что там появились новые автотесты

Страница со списком автоматизированных тест-кейсов:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/4009d78c-f295-4b34-8768-4d56c6df6f9a)


### <a id="jira" style="color:black"><img src="media/logos/jira-original.svg" width="20" height="20"/> Интеграция Allure TestOps с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1263)</a>

Для того, чтобы связать TMS с задачами, которые ставят тестировщикам, в соответствии с настройками в <code>Allure TestOps</code>, в проекте реализована интеграция <code>Allure TestOps</code> с инструментом <code>Jira</code>.
Например, в проекте есть @Disabled автотест, который требует доработки, это зафиксировано в <code>Allure TestOps</code>, вся информация по доработке ведется в тикете в <code>Jira</code>.

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/cf3a05dc-7e39-4526-9d4f-7eef68123fe6)

Страница с ISSUE, упомянутой в <code>Allure TestOps</code>:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/d01b1a51-507f-4741-84f8-b5332eb628f8)
