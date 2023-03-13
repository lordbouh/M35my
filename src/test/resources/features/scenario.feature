#Gherkin
Feature: Find city
  #Позитивный сценарий: выбираем регион Красноярский край и получем список объявлений
  Scenario: choose region
    Given board of advertisments 'https://drom.ru/'
    Then  choose region 'Красноярский край'
    And assert that region is 'Красноярский край'
  #Негативный сценарий: логин с пустыми полями
  Scenario: log in with blank poles
    Given  board of advertisments 'https://drom.ru/'
    Then  log in without symbols
    And assert that user got message 'Поле должно быть заполнено'
    Then close browser