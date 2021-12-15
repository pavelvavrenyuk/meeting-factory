--
-- Data for table `group_of_criteria`
--

INSERT INTO `group_of_criteria`
VALUES (1, 'Spring'),
       (2, 'Java'),
       (3, 'Hibernate'),
       (4, 'Alfresco'),
       (5, 'React');

--
-- Data for table `criterion`
--

INSERT INTO `criterion`
VALUES (1, 'Spring boot', '1'),
       (2, 'Spring secure', '1'),
       (3, 'Lambdas', '2'),
       (4, 'Collections', '2'),
       (5, 'Webscript knowledge', '4'),
       (6, 'Events', '5');

--
-- Data for table `employee`
--

INSERT INTO `employee`
VALUES (1, 'Andrey', 'Zvonov'),
       (2, 'Alexander', 'Hakimov'),
       (3, 'Oleg', 'Torsunov'),
       (4, 'Marina', 'Targakova'),
       (5, 'Vasiliy', 'Tuneev');

--
-- Data for table `meeting`
--

INSERT INTO `meeting`
VALUES (1,
        '2020-06-26',
        'Как тебе твой проект? Нравится ли как все устроено в офисе?',
        'Нужно рассмотреть новый проект для него. Так же выдать ему второй монитор для удобной работы.',
        '[{
         "name":"Java",
         "criteria":
         [{
           "name":"Lambda",
           "grade":"-1",
           "comment":"Нужно обновить знания"
         },
           {
             "name":"Strings",
             "grade":"2",
             "comment":"Отличные знания"
           }]
       },
         {
           "name":"Spring",
           "criteria":
           [{
             "name":"Controllers",
             "grade":"0",
             "comment":"Нужно почитать про различные параметры для валидации значений"
           },
             {
               "name":"JPA",
               "grade":"-2",
               "comment":"Нужно подучить технологию построения запросов"
             },
             {
               "name":"Security",
               "grade":"2",
               "comment":"Отличное понимание"
             }]
         }]',
        '4'),
       (2,
        '2020-06-26',
        'Как тебе новый проект? Как обстановка в команде? Удовлетворен ли ты своим вознаграждением?',
        'Все устраивает, единственное - нужно пересмотреть вознаграждение',
        '[{
          "name":"Java",
          "criteria":
          [{
            "name":"Lambda",
            "grade":"2",
            "comment":"Отличное понимание"
          },
            {
              "name":"Strings",
              "grade":"0",
              "comment":"Нужно подучить работу с StringBuffer и StringBuilder"
            }]
        },
          {
            "name":"Spring",
            "criteria":
            [{
              "name":"Controllers",
              "grade":"1",
              "comment":"Нужно почитать про различные параметры для считывания параметров с запроса"
            },
              {
                "name":"JPA",
                "grade":"0",
                "comment":"Нужно подучить технологию построения запросов"
              },
              {
                "name":"Security",
                "grade":"0",
                "comment":"Нужно подучить"
              }]
          }]',
        '2'),
       (3,
        '2020-06-26',
        'Успеваешь ли с задачами? Получается ли что-то изучать новое? В какой технологии ты считаешь, что больше всего разбираешься?',
        'Помогать с эстимейтом задач. Рассмотреть возможность нового проекта с более новыми технологиями.',
        '[{
          "name":"Java",
          "criteria":
          [{
            "name":"Lambda",
            "grade":"0",
            "comment":"Хорошее понимание, но нужно больше попрактиковаться"
          },
            {
              "name":"Strings",
              "grade":"2",
              "comment":"Отличные знания"
            }]
        },
          {
            "name":"Spring",
            "criteria":
            [{
              "name":"Controllers",
              "grade":"2",
              "comment":"Отличное понимание работы"
            },
              {
                "name":"JPA",
                "grade":"0",
                "comment":"Хорошее понимание, но нужно попрактиковаться"
              },
              {
                "name":"Security",
                "grade":"-2",
                "comment":"Нужно изучить, совершенно не знает"
              }]
          }]',
        '1');