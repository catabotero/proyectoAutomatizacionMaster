Feature: seleccion libros
  Como usuario del aplicativo quiero seleccionar libros y cantidades de los mismos
  y ver el total a pagar

  Scenario: El usuario inicia sesion en aplicativo de manera exitosa

    Given Que he ingresado a la pagina "http://sahitest.com/demo/training/login.htm"

    And he Ingresado nombre de usuario y Password

      | user | password |

      | test | secret |

    When de click en el boton login

    Then deberia acceder al aplicativo

  Scenario: El usuario selecciona varios libros de distintos tipos
    Given Seleccionar los libros y las cantidades
      | libro | cantidad |

      | java | 3 |

      | ruby | 2 |

      | python | 1 |
    When Agregar al carro de compras
    Then deberia ver un gran total de "1650"