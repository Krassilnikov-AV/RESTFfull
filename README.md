# RESTFfull
**Что такое веб-сервисы RESTful?**
- Веб-сервисы RESTful созданы для лучшей работы в Интернете. Передача репрезентативного состояния (REST) ​​- это архитектурный стиль, который задает ограничения, такие как унифицированный интерфейс, которые при применении к веб-службе вызывают желательные свойства, такие как производительность, масштабируемость и модифицируемость, которые позволяют службам работать лучше всего в Интернете. В архитектурном стиле REST данные и функциональность считаются ресурсами и доступны с использованием унифицированных идентификаторов ресурсов (URI)., как правило, ссылки в Интернете. На ресурсы воздействуют с помощью набора простых, четко определенных операций. Архитектурный стиль REST ограничивает архитектуру архитектурой клиент / сервер и предназначен для использования протокола связи без сохранения состояния, обычно HTTP. В стиле архитектуры REST клиенты и серверы обмениваются представлениями ресурсов с использованием стандартизированного интерфейса и протокола.

Следующие принципы рекомендуют приложениям RESTful быть простыми, легкими и быстрыми:
- Идентификация ресурса через URI . Веб-служба RESTful предоставляет набор ресурсов, которые идентифицируют цели взаимодействия со своими клиентами. Ресурсы идентифицируются с помощью URI, которые обеспечивают глобальное адресное пространство для обнаружения ресурсов и служб. См . Аннотации @Path и шаблоны пути URI для получения дополнительной информации.
- Унифицированный интерфейс : управление ресурсами осуществляется с помощью фиксированного набора из четырех операций создания, чтения, обновления, удаления: PUT , GET , POST и DELETE . PUT создает новый ресурс, который затем может быть удален с помощью DELETE . GET извлекает текущее состояние ресурса в некотором представлении. POST передает новое состояние на ресурс. Посмотрите Ответы на Методы HTTP и Запросы для получения дополнительной информации.
- Сообщения с самоописанием: ресурсы отделены от их представления, чтобы к их содержимому можно было обращаться в различных форматах, таких как HTML, XML, простой текст, PDF, JPEG, JSON и другие. Метаданные о ресурсе доступны и используются, например, для управления кэшированием, обнаружения ошибок передачи, согласования соответствующего формата представления и выполнения аутентификации или контроля доступа. См ответ на HTTP - методы и запросы и с помощью провайдеров Entity на карту HTTP Response и Request Entity органы для получения дополнительной информации.
- Взаимодействие с состоянием через гиперссылки : каждое взаимодействие с ресурсом не имеет состояния; то есть сообщения запроса являются автономными. Взаимодействия с состоянием основаны на концепции явной передачи состояния. Существует несколько методов обмена состояниями, таких как перезапись URI, куки и скрытые поля формы. Состояние может быть встроено в ответные сообщения, чтобы указывать на действительные будущие состояния взаимодействия. См. Использование провайдеров сущностей для сопоставления HTTP-тела ответа и запроса сущностей и «Создание URI» в документе «Обзор JAX-RS» для получения дополнительной информации.

**Создание класса корневых ресурсов RESTful**
- Корневые классы ресурсов - это POJO, которые либо аннотированы @Path, либо имеют хотя бы один метод, аннотированный @Path, или указатель метода запроса , такой как @GET , @PUT , @POST или @DELETE . Методы ресурса - это методы класса ресурса, аннотированные указателем метода запроса. В этом разделе объясняется, как использовать JAX-RS для аннотирования классов Java для создания веб-сервисов RESTful.
- Разработка веб-сервисов RESTful с JAX-RS
JAX-RS - это API языка программирования Java, разработанный для упрощения разработки приложений, использующих архитектуру REST.

API JAX-RS использует аннотации языка программирования Java для упрощения разработки веб-сервисов RESTful. Разработчики украшают файлы классов языка программирования Java аннотациями JAX-RS, чтобы определить ресурсы и действия, которые могут быть выполнены с этими ресурсами. Аннотации JAX-RS являются аннотациями времени выполнения; следовательно, отражение во время выполнения сгенерирует вспомогательные классы и артефакты для ресурса. В архиве приложения Java EE, содержащем классы ресурсов JAX-RS, будут настроены ресурсы, сгенерированы вспомогательные классы и артефакты, а также ресурс, предоставленный клиентам путем развертывания архива на сервере Java EE.

**Распространненные HTTP-запросы программирования Java, которые определены JAX-RS, с кратким описанием их использования.**
- @Path - В @Path значение аннотации появляется относительный путь URI , указывающий , где класс Java будет организован: например, / HelloWorld . Вы также можете встраивать переменные в URI для создания шаблона пути URI. Например, вы можете запросить имя пользователя и передать его приложению в качестве переменной в URI: / helloworld / {имя пользователя}.
- @GET - это обычная операция считывания, которая запрашивает представление ресурса. Операция GET должна реализовываться безопасным образом, то есть не изменять состояние ресурса. Кроме того, запрос GET должен быть идемпотентным. Это означает, что он должен оставлять ресурс в одном и том же состоянии, независимо от того, сколько раз он вызывался: единожды, дважды или больше. Безопасность и идемпотентность обеспечивают значительную стабильность. Когда клиент не получает ответа (например, из-за отказа сети), он может обно-
вить свои запросы, и эти новые запросы будут ожидать того же ответа, который был бы получен при первой попытке, если бы все пошло нормально. При этом состояние ресурса на сервере не повреждается.
- @POST - метод запроса условное обозначение и соответствует аналогичным названием метода HTTP. Метод Java, аннотированный этим указателем метода запроса, будет обрабатывать HTTP-запросы POST. Поведение ресурса определяется методом HTTP, на который отвечает ресурс. Например, может вызываться при прикреплении сообщения к файлу журнала, записи комментария в блог, занесении книги в список и т. д. Следовательно, метод POST не является ни безопасным (состояние ресурса изменяется), ни идемпотентным (при двукратной отправке этого запроса мы получим два новых подчиненных объекта). Если ресурс был создан на исходном сервере, то в ответ должен быть получен код состояния 201 — Создан. В большинстве браузеров генерируются лишь два вида запросов — GET и POST.
- @PUT - предназначен для обновления состояния ресурса, сохраненного по указанному URI. Если URI запроса ссылается на несуществующий ресурс, то ресурс будет создан именно по этому URI. Метод PUT может применяться, например, при обновлении цены на книгу или адреса клиента. Метод PUT небезопасен (так как состояние ресурса обновляется), но идемпотентен: можно многократно отослать один и тот же запрос PUT, а конечное состояние ресурса останется неизменным.
- @DELETE -удаляет ресурс. Ответом на DELETE может быть статусное сообщение, получаемое в теле более подробного сообщения, либо отсутствие статуса вообще. Запрос DELETE также является идемпотентным, но не является безопасным.

**Методы HTTP, которые используются реже:**
- @HEAD - практически идентичен GET с той оговоркой, что сервер не возвращает в ответ тело сообщения. HEAD может быть полезен при проверке валидности ссылки или размера объекта без передачи этой ссылки или объекта.

- @PathParam - @PathParam аннотации являются типом параметра , который вы можете извлечь для использования в классе ресурсов. Параметры пути URI извлекаются из URI запроса, а имена параметров соответствуют именам переменных шаблона пути URI, указанным в аннотации уровня класса @Path.
- @QueryParam - @QueryParam аннотации являются типом параметра , который вы можете извлечь для использования в классе ресурсов. Параметры запроса извлекаются из параметров запроса URI запроса.
- @Consumes - @Consumes аннотации используются для указания типов MIME медиа представлений ресурс может потреблять, отправленные клиентом.
- @Produces - @Produces аннотации используются для указания типов MIME медиа представлений ресурса может производить и отправлять обратно клиент: например, «текст / обычный» .
- @Provider - @Provider аннотации используются для всего , что представляет интерес для JAX-RS исполнения, таких как MessageBodyReader и MessageBodyWriter . Для HTTP-запросов MessageBodyReader используется для сопоставления тела объекта HTTP-запроса с параметрами метода. На стороне ответа возвращаемое значение сопоставляется с телом объекта ответа HTTP с помощью MessageBodyWriter . Если приложению необходимо предоставить дополнительные метаданные, такие как заголовки HTTP или другой код состояния, метод может вернуть Response, который оборачивает сущность и который может быть построен с использованием Response.ResponseBuilder .

**Коды.состояния.HTTP**
- 100 — Продолжить - Сервер получил заголовки запроса, далее клиент должен прислать тело запроса.
- 101 — Переключение протоколов - Запрашивающая сторона просит сервер переключиться на другой протокол, и сервер соглашается это сделать.
- 200 — Хорошо - Запрос завершен успешно. Тело объекта, если таковое имеется, содержит представление ресурса.
- 201 — Создан - Запрос был выполнен, что привело к созданию нового ресурса.
- 204 — Нет содержимого - Сервер успешно обработал запрос, но не возвратил никакого содержимого.
- 206 — Частичное содержимое - Сервер доставил лишь часть содержимого; это было обусловлено диапазонами заголовков, заданными клиентом.
- 301 — Перемещено навсегда - Запрошенному ресурсу был присвоен новый постоянный URI, и при любых последующих ссылках на данный ресурс следует использовать один из возвращенных URI.
- 304 — Не изменялось - Указывает, что ресурс не изменялся с момента последнего запроса.
- 307 — Временное перенаправление - Запрос должен быть повторен с другим URI; однако в будущих запросах следует по-прежнему использовать исходный URI.
- 308 — Постоянное перенаправление - Этот, а также все последующие запросы должны направляться уже по новому URI.
- 400 — Неверный запрос - Запрос не может быть выполнен из-за синтаксической ошибки.
- 401 — Не авторизован - Похож на 403, но указывает, что для запроса требовалась аутентификация и она не была выполнена.
- 403 — Запрещено -  Запрос был допустимым, но сервер отказался на него отвечать.
- 404 — Не найдено - Сервер не нашел каких-либо ресурсов, соответствующих URI, содержащемуся в запросе.
- 405 — Метод не поддерживается - Запрос был сделан с использованием метода, который не поддерживается ресурсом.
- 406 - неприемлеио - Запрошенный ресурс может сгенерировать только такое содержимое, которое является неприемлемым в соответствии с заголовками Accept, указанными в запросе.
- 500 — Внутренняя ошибка сервера - Сервер столкнулся с неожиданным условием, помешавшим ему выполнить запрос.
- 501 — Не реализовано - Сервер либо не распознает метод запроса, либо не способен выполнить запрос.
- 503 — Служба недоступна - В настоящее время сервер недоступен, поскольку он перегружен запросами или остановлен для техобслуживания; как правило, это временное состояние.
- 505 — Версия HTTP не поддерживается - Сервер не поддерживает ту версию протокола HTTP, которая использовалась в запросе.

_____________________________________________
**описание класса FileSelect и интерфейса FilenameFilter:**

- интерфейс java.io.FilenameFilter может быть реализован для фильтрации имен файлов в определенной папке.
- Интерфейс FilenameFilter содержит метод boolean accept(File dir, String name).
- Класс должен реализовывать этот метод, а каждый тестируемый файл должен быть включен в общий список файлов.
- Метод accept проверяет имя файла на наличие определенного расширения.












 







