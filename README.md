## Проект по автоматизации тестирования для веб-сайта [LUNDENILONA.RU](https://lundenilona.ru/) и мобильного андройд приложения LundenIlona
* Сайт LUNDENILONA.RU - онлайн-магазин авторской космецевтики, существующий с 2011 года.
* Приложение LundenIlona - это женское приложение 6-в-1, включающее в себя расчет индивидуальной дневной калорийности, дневник питания, шагомер, планинг привлекательности, личный гормональный календарь, а также отдельный блок для беременных девушек.

### Основные особенности проекта:
- Автотесты написаны на языке <code>Java</code> 
- В качестве сборщика используется <code>Gradle</code>
- Использованы фреймворки <code>JUnit 5</code> и <code>Selenide</code>
- При прогоне тестов в дефолтном режиме браузер запускается в <code>Selenoid</code>, приложение в <code>Browserstack</code>
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота
- Осуществлена интеграция с TMS <code>Allure TestOps</code> и <code>Jira</code>

### Навигация:
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Список автоматизированных тест-кейсов</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов из Jenkins</a>
* <a href="#telegram">Уведомление в Telegram при помощи бота</a>
* <a href="#allure">Allure отчет</a>
* <a href="#video">Видео пример прохождения тестов на Selenoid</a>
* <a href="#allure-testops">Интеграция Jenkins с Allure TestOps</a>
* <a href="#jira">Интеграция Allure TestOps с Jira</a>
____

<a id="tools"></a>
### <a name="Технологии и инструменты" style="color:black;"></a>Технологии и инструменты</a>
<p align="center">
<a href="https://www.java.com/">                      <img src="media/logos/java-original.svg"            width="50" height="50"    title="Java"/></a> 
<a href="https://www.jetbrains.com/idea/">            <img src="media/logos/intellij-original.svg"        width="50" height="50"    title="IntelliJ IDEA"/></a>   
<a href="https://github.com/">                        <img src="media/logos/github-original.svg"          width="50" height="50"    title="Github"/></a>
<a href="https://junit.org/junit5/">                  <img src="media/logos/junit-original.svg"           width="50" height="50"    title="JUnit 5"/></a>
<a href="https://gradle.org/">                        <img src="media/logos/gradle-original.svg"          width="50" height="50"    title="Gradle"/></a>
<a href="https://selenide.org/">                      <img src="media/logos/selenide-original.svg"        width="50" height="50"    title="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/">             <img src="media/logos/selenoid-original.svg"        width="50" height="50"    title="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="media/logos/allure-original.svg"          width="50" height="50"    title="Allure"/></a> 
<a href="https://qameta.io/">                         <img src="media/logos/alluretestops - original.svg" width="50" height="50"    title="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/">                    <img src="media/logos/jenkins-original.svg"         width="50" height="50"    title="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="media/logos/jira-original.svg"            width="50" height="50"    title="Jira"/></a>  
<a href="https://web.telegram.org/a/">                <img src="media/logos/telegram-original.svg"        width="50" height="50"    title="Telegram"/></a>
<a href="https://developer.android.com/studio">       <img src="media/logos/androidstudio-original.svg"   width="50" height="50"    title="Android Studio"/></a>
<a href="https://github.com/appium/appium-inspector"> <img src="media/logos/appiuminspector-original.png" width="50" height="50"    title="Appium Inspector"/></a>
<a href="https://www.browserstack.com/">              <img src="media/logos/browserstack-original.png"    width="50" height="50"    title="Browserstack"/></a>
</p>

<a id="cases"></a>
### <a name="Список автоматизированных тест-кейсов" style="color:black;"></a>Список автоматизированных тест-кейсов</a>
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

<a id="console"></a>
### <a name="Запуск тестов из терминала" style="color:black;"></a>Запуск тестов из терминала</a>

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

MOBILE:
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

  - Команда для запуска с указанием ключей deviceHost (browserstack, emulation, real) и driver (remote, local)
    ```bash  
    ./gradlew clean test -DdeviceHost=*указать значение* -Ddriver=*указать значение*
    ```

  - Команда для запуска без указания ключей (все тесты запустятся по дефолту на удаленных фермах: WEB на selenoid ферме, MOBILE на browserstack ферме)
    ```bash  
    ./gradlew clean test
    ```

<a id="jenkins"></a>
### <a name="Запуск тестов из Jenkins" style="color:black;"></a>Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/25-KatherineMiers-lundenilona-tests/)</a>

Для того, чтобы тесты можно было запускать независимо от кого-либо, в <code>Jenkins</code> реализована джоба для удаленного запуска.

Основная страница сборки:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/e9e456e9-5e04-473e-affb-f6288dd87489)

#### <a name="Запуск сборки в Jenkins" style="color:black;"></a>Запуск сборки в Jenkins:</a>

Чтобы запустить сборку в Jenkins необходимо:

- С левой стороны страницы нажать на кнопку "Build with Parameters"
- Выбрать параметры в соответствии с пуктом "Параметры сборки в Jenkins" описанным ниже
- Нажать на кнопку Build

#### <a name="Параметры сборки в Jenkins" style="color:black;"></a>Параметры сборки в Jenkins:</a>

Для запуска сборки необходимо указать требуемые параметры.

WEB:
- DRIVER
  - remote (веб тесты запустятся на selenoid ферме)
  - local (веб тесты запустятся на локальном браузере)
   
MOBILE:
- HOST
  - browserstack (мобильные тесты запустятся на browserstack ферме)
  - emulation (мобильные тесты запустятся на эмуляторе)
  - real (мобильные тесты запустятся на реальном девайсе)

<a id="telegram"></a>
### <a name="Уведомление в Telegram при помощи бота" style="color:black;"></a>Уведомление в Telegram при помощи бота:</a>

После завершения прогона автотестов, в соответствии с настройками в <code>Jenkins</code>, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом прохождения автотестов.

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/d4f81a78-898e-4494-a743-da9b0c059cfc)

<a id="allure"></a>
### <a name="Allure отчет" style="color:black;"></a>Allure [отчет](https://jenkins.autotests.cloud/job/25-KatherineMiers-lundenilona-tests/5/allure/)</a>

После завершения прогона автотестов, в соответствии с настройками в <code>Jenkins</code>, сформируется Allure отчет. Для просмотра отчета необходимо в окне "Build History" нажать на значок Allure, расположенный справа от номера билда. 

Пример основной страницы Allure отчёта: 

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/ae2647b6-4a19-4739-84f8-c59f6a9c166a)

<a id="video"></a>
### <a name="Видео пример прохождения тестов на Selenoid" style="color:black;"></a>Видео пример прохождения тестов на Selenoid:</a>

Для дальнейшего анализа результатов прохожения автотестов в Allure отчете можно переключиться на вкладку "Behaviors". К каждому UI тесту в отчете прилагается видео прогона, скриншот и другие необходимые аттачменты.

Видео пример прохождения тестов на WEB:

<p align="center">
  <img title="web" src="media/gifs/web.gif">
</p>

Видео пример прохождения тестов на MOBILE:

<p align="center">
  <img title="mobile" src="media/gifs/mobile.gif">
</p>

<a id="allure-testops"></a>
### <a name="Интеграция Jenkins с Allure TestOps" style="color:black;"></a>Интеграция Jenkins с [Allure TestOps](https://allure.autotests.cloud/project/4286)</a>

Для того, чтобы поддерживать концепцию test cases as documentation, в соответствии с настройками в <code>Jenkins</code>, в проекте реализована интеграция <code>Jenkins</code> с TMS <code>Allure TestOps</code>. Таким образом ручной тестировщик может создавать в ней ручные тест-кейсы, а автотестировщик может создавать автотесты с Allure шагами и выгружать их в нее. Для этого необходимо:
- Запустить сборку в Jenkins и дождаться ее выполнения
- Зайти на страницу Allure TestOps во вкладку [Launches](https://allure.autotests.cloud/project/4286/launches)
- С правой стороны от названия запуска нажать на кнопку "Close launch"
- Переключиться на вкладку [Test cases](https://allure.autotests.cloud/project/4286/test-cases)
- Можно будет увидеть, что там появились новые автотесты

Страница со списком автоматизированных тест-кейсов:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/4009d78c-f295-4b34-8768-4d56c6df6f9a)

<a id="jira"></a>
### <a name="Интеграция Allure TestOps с Jira" style="color:black;"></a>Интеграция Allure TestOps с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1263)</a>

Для того, чтобы связать TMS с задачами, которые ставят тестироващикам, в соответствии с настройками в <code>Allure TestOps</code>, в проекте реализована интеграция <code>Allure TestOps</code> с инструментом <code>Jira</code>.
Например, в проекте есть @Disabled автотест, который требует доработки, это зафиксировано в <code>Allure TestOps</code>, вся информация по доработке ведется в тикете в <code>Jira</code>.

Страница с ISSUE, упомянутой в <code>Allure TestOps</code>:

![image](https://github.com/kladkovaekaterina/lundenilona-tests/assets/93866007/d01b1a51-507f-4741-84f8-b5332eb628f8)
