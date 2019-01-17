# Tests Unitaire avec JUnit

JUnit est un framework de test unitaire dévelopé pour Java.

JUnit définit deux types de fichiers de tests :
* Les TestCase (cas de test) sont des classes contenant un certain nombre de méthodes de tests. Un TestCase sert généralement à tester le bon fonctionnement d'une classe.
* Une TestSuite permet d'exécuter un certain nombre de TestCase déjà définis.

Il existe plusieurs annotations dans JUnit qu'il est bon de connaitre.

## @Before
- La méthode annotée par @Before est appelée avant chaque méthode de test.

## @After
- La méthode annotée par @After est appelée après chaque test.
  
## @BeforeClass
- La méthode annotée par @BeforeClass est appelée au lancement du testCase.

## @AfterClass
- La méthode annotée par @AfterClass est appelée tout à la fin du testCase.
 
 ## @Test
 - Tous les tests sont des méthodes annotées par @Test, qui font des traitements et vérifient le bon comportement des classes testées par des méthodes assert***(), toute assertion non vérifiée est signalée comme défaillante. Un cas de test (TestCase) peut avoir plusieurs sections @Test. Si une section @Test échoue, le TestCase ne s'arrête pas mais continue sur les sections @Test suivantes (s'il y en a).

En voici un exemple:

```java
public class NomDeMaClass extends TestCase{

    @BeforeClass
    public static void setUpClass() throws Exception {
        // Code exécuté avant l'exécution du premier test (et de la méthode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code exécuté après l'exécution de tous les tests
    }

    @Before
    public void setUp() throws Exception {
        // Code exécuté avant chaque test        
    }

    @After
    public void tearDown() throws Exception {
        // Code exécuté après chaque test
    }
    
    @Test
    public void nomdutest1() {
       // code qui teste une chose, appelé "test1". 
       // Le code contient généralement une assertion pour vérifier si une condition est vraie ou fausse.
    }

    @Test
    public void nomdutest2() {
       // code qui teste autre chose, appelé "test2"
       // Le code contient généralement une assertion pour vérifier si une condition est vraie ou fausse.
    }
}
```
