// Importieren der JUnit-Klassen zum Testen
import org.junit.jupiter.api.*; 
// Importieren der Assertion-Methoden
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {
	// Das zu testende Objekt
    private StringProcessor stringProcessor; 
//"@BeforeEach"-Methode wird vor jedem Test aufgerufen, 
//um ein neues StringProcessor-Objekt zu erstellen
@BeforeEach
public void setUp() {
  // HIER: Erstellen des Objekts
  stringProcessor = new StringProcessor();
}

//Diese Methode wird nach jedem Test aufgerufen,
//um das StringProcessor-Objekt zu löschen
@AfterEach
public void tearDown() {
 // HIER: Objekt löschen
 stringProcessor = null;
}

//Ein einfacher Test, der überprüft, 
//ob der StringProcessor einen String umkehren kann
@Test
public void testReverse() {
 // Vorbereitung der Testdaten
 String input = "JUnit 5 is awesome!";
 String expectedOutput = "!emosewa si 5 tinUJ";
 
 // Aufruf der zu testenden Methode
 String actualOutput = stringProcessor.reverse(input);
 
 // Überprüfen, ob das Ergebnis korrekt ist
 assertEquals(expectedOutput, actualOutput);
}

//Ein Test, der überprüft, 
//ob der StringProcessor einen leeren String zurückgibt, 
//wenn der Eingabestring null ist
@Test
public void testReverseWithNullInput() {
 // Vorbereitung der Testdaten
 String input = null;
 String expectedOutput = "";
 
 // Aufruf der zu testenden Methode
 String actualOutput = stringProcessor.reverse(input);
 
 // Überprüfen, ob das Ergebnis korrekt ist
 assertEquals(expectedOutput, actualOutput);
}

//Ein Test, der überprüft, 
//ob der StringProcessor eine Ausnahme (Exception) wirft, 
//wenn der Eingabestring leer ist
@Test
public void testReverseWithEmptyInput() {
 // Vorbereitung der Testdaten
 String input = "";
 
 // Überprüfen, ob die Methode eine Ausnahme wirft
 assertThrows(IllegalArgumentException.class, () -> {
     stringProcessor.reverse(input);
 });
}

//Eine Klasse, die einen String umkehrt
static class StringProcessor {
 
 // Diese Methode kehrt den übergebenen String um
 public String reverse(String input) {
     // Überprüfen, ob der Eingabestring null ist
     if (input == null) {
         return "";
     }
     
     // Überprüfen, ob der Eingabestring leer ist
     if (input.length() == 0) {
         throw new IllegalArgumentException("Eingabe kann nicht nichts sein!");
     }
     
     // Umkehren des Strings
     StringBuilder reversed = new StringBuilder();
     for (int i = input.length() - 1; i >= 0; i--) {
         reversed.append(input.charAt(i));
     }
     
     return reversed.toString(); // Rückgabe des umgekehrten Strings
   }
 }
}
