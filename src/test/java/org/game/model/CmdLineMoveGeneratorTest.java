//package org.game.model;
//
//import org.game.util.ScannerSingleton;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockedStatic;
//import org.mockito.MockitoAnnotations;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class CmdLineMoveGeneratorTest {
//
//    @Mock
//    private Scanner scanner;
//    private CmdLineMoveGenerator moveGenerator;
//    private List<String> validMoves;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        validMoves = List.of("rock", "paper", "scissors");
//        moveGenerator = new CmdLineMoveGenerator(validMoves);
//    }
//
//    @Test
//    void testGenerateMove_ValidInput() {
//        String input = "rock\n";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//
//        try (MockedStatic<ScannerSingleton> mockedScannerSingleton = mockStatic(ScannerSingleton.class)) {
//            Scanner scanner = new Scanner(inputStream);
//            mockedScannerSingleton.when(ScannerSingleton::getScanner).thenReturn(scanner);
//
//            String result = moveGenerator.generateMove();
//
//            assertEquals("rock", result);
//        }
//    }
//
//    @Test
//    void testGenerateMove_ExitCommand() {
//        String input = "exit\n";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//
//        try (MockedStatic<ScannerSingleton> mockedScannerSingleton = mockStatic(ScannerSingleton.class)) {
//            Scanner scanner = new Scanner(inputStream);
//            mockedScannerSingleton.when(ScannerSingleton::getScanner).thenReturn(scanner);
//
//            String result = moveGenerator.generateMove();
//
//            assertEquals("exit", result);
//        }
//    }
//
//    @Test
//    void testGenerateMove_InvalidInputThenValidInput() {
//        String input = "invalid\nrock\n";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//
//        try (MockedStatic<ScannerSingleton> mockedScannerSingleton = mockStatic(ScannerSingleton.class)) {
//            Scanner scanner = new Scanner(inputStream);
//            mockedScannerSingleton.when(ScannerSingleton::getScanner).thenReturn(scanner);
//
//            String result = moveGenerator.generateMove();
//
//            assertEquals("rock", result);
//        }
//    }
//
//    @Test
//    void testGenerateMove_ExceptionWhileReadingInput() {
//        when(scanner.nextLine()).thenThrow(new NoSuchElementException("Mocked exception"));
//
//        String result = moveGenerator.generateMove();
//
//        assertEquals("", result);
//        verify(scanner, atLeastOnce()).nextLine();
//    }
//
//    @Test
//    void testGenerateMove_NullValidMoves() {
//        CmdLineMoveGenerator moveGeneratorNullValidMoves = new CmdLineMoveGenerator(null);
//
//        String result = moveGeneratorNullValidMoves.generateMove();
//
//        assertEquals("", result);
//    }
//
//    @Test
//    void testGenerateMove_EmptyValidMoves() {
//        CmdLineMoveGenerator moveGeneratorEmptyValidMoves = new CmdLineMoveGenerator(List.of());
//
//        String result = moveGeneratorEmptyValidMoves.generateMove();
//
//        assertEquals("", result);
//    }
//}