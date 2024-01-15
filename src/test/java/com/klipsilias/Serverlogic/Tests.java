package com.klipsilias.Serverlogic;

import com.klipsilias.Database.DoubleData;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//JUNIT Test für Blatt 9
class Tests {
    //test makeReservation
    @Mock
    private Room reservationMock = new Room(123131232, "nebenan");

    @Test
    public void testMakeReservationWithValidInput() {
        assertTrue(reservationMock.makeReservation("Monday", 10));
    }

    @Test
    public void testMakeReservationWithInvalidWeekday() {
        assertThrows(IllegalArgumentException.class, () -> reservationMock.makeReservation("Saturday", 10));
    }

    @Test
    public void testMakeReservationWithInvalidTime() {
        assertThrows(IllegalArgumentException.class, () -> reservationMock.makeReservation("Monday", 20));
    }

    @Test
    public void testMakeReservationWithAlreadyReservedRoom() {
        reservationMock.makeReservation("Monday", 10);
        assertFalse(reservationMock.makeReservation("Monday", 10));
    }

    @Test
    public void testMakeReservationWithInvalidTimeAndWeekday() {
        assertThrows(IllegalArgumentException.class,() -> reservationMock.makeReservation("bla", 40));
    }

    //test uploadFile

    private final FileSystemStorageService storageService = mock(FileSystemStorageService.class);

    private final FileUploadController controller = new FileUploadController(storageService);

    @Test
    public void upload_withValidFile_returnsSuccessResponse() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "Hello, world!".getBytes());

        ResponseEntity<ResponseMessage> response = controller.uploadFile(file);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Uploaded the file successfully: test.txt", response.getBody().getMessage());

        verify(storageService).store(file);
    }

//    @Test
//    public void upload_withEmptyFile_returnsErrorResponse() throws Exception {
//        MockMultipartFile file = new MockMultipartFile("file", "", "text/plain", new byte[0]);
//
//        ResponseEntity<ResponseMessage> response = controller.uploadFile(file);
//
//        assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
//        assertEquals("Could not upload the file: test.txt. Error: File is empty", response.getBody().getMessage());
//
//        verify(storageService, never()).store(any());
//    }
//
//    @Test
//    public void upload_withInvalidFileName_returnsErrorResponse() throws Exception {
//        MockMultipartFile file = new MockMultipartFile("file", "invalid.txt", "text/plain", "Hello, world!".getBytes());
//
//        ResponseEntity<ResponseMessage> response = controller.uploadFile(file);
//
//        assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
//        assertEquals("Could not upload the file: invalid.txt. Error: File name is invalid", response.getBody().getMessage());
//
//        verify(storageService, never()).store(any());
//    }


    //test viewUser
    @Mock
    private Users user;

    @Mock
    private Users dummy = new Users("fans", "Hranz", "Hfans", "sophia");

    @Test
    public void testViewUserWithValidAccess() {
        // Erstelle einen Nutzer mit Zugriffsrecht
        user = new Administration("Hans", "franz", "fhans", "sophia");

        // Rufe die Methode `viewUser()` auf
        boolean result = user.viewUser(dummy);

        // Überprüfe das Ergebnis
        assertTrue(result);
    }

    @Test
    public void testViewUserWithEmptyData() {
        user = new Administration("Hans", "franz", "fhans", "sophia");
        Lecturer dummy = null;

        // Rufe die Methode `viewUser()` auf
        boolean result = user.viewUser(dummy);

        // Überprüfe das Ergebnis
        assertTrue(result);
    }

    @Test
    public void testViewUserWithNoAccess() {
        user = new Student("Hans", "franz", "fhans", "sophia", true);

        // Rufe die Methode `viewUser()` auf
        try {
            user.viewUser(dummy);
            fail("Die Methode sollte eine `IllegalCallerException` werfen");
        } catch (IllegalCallerException e) {
            assertEquals("access denied", e.getMessage());
        }
    }

    @Test
    public void testViewUserWithNull() {
        // Rufe die Methode `viewUser()` mit einem `null`-Wert auf
        try {
            user.viewUser(null);
            fail("Die Methode sollte eine `NullPointerException` werfen");
        } catch (NullPointerException e) {
            // erwartet
        }
    }

    //Test getGradeList


    Student users = new Student("Hans", "franz", "fhans", "sophia", true);
    ExamOfficeEmployee grademaker = new ExamOfficeEmployee("","","","");
    @Test
    public void testGetUserGradeListEmptyList() {
        Grade.getList().clear();

        List<DoubleData> userGradelist = users.getUserGradeList();

        assertEquals(0, userGradelist.size());
    }

    @Test
    public void testGetUserGradeListOneElement() {
        grademaker.makeGrade(2.0, "fhans");

        List<DoubleData> userGradelist = users.getUserGradeList();

        assertEquals(1, userGradelist.size());
    }

    @Test
    public void testGetUserGradeListMultipleElements() {

        grademaker.makeGrade(2.0, "fhans");
        grademaker.makeGrade(2.0, "fhans");


        List<DoubleData> userGradelist = users.getUserGradeList();

        assertEquals(2, userGradelist.size());
    }

    //test registerEvent
    @Test
    public void testRegisterEventImmatriculated() {
        Student user = new Student("Hans", "franz", "fhans", "sophia", true);
        Room room = new Room(141144, "drüben");
        ArrayList<Users> toll = new ArrayList<>();
        Event event = new Event(1231131321, room, "morgenfrüh", toll);
        event.addTeilnehmer(user);

        user.registerEvent(event);

        assertTrue(event.getList().contains(user));
    }

    @Test
    public void testRegisterEventNotImmatriculated() {
        Student user = new Student("Hans", "franz", "fhans", "sophia", false);
        Room room = new Room(141144, "drüben");
        ArrayList<Users> toll = new ArrayList<>();
        Event event = new Event(1231131321, room, "morgenfrüh", toll);
        event.addTeilnehmer(user);
        assertFalse(event.getList().contains(user));
    }

    //viewGroupTeilnehmer für Blatt 10 Aufgabe 3
    @Mock
    ArrayList<Users> listeRight = new ArrayList<>();
    Groupy tester = new Groupy("kaffeekränzchen");
    @Test
    public void testTeilnehmerListWithFalseContent(){
        Users user1 = new Users("Kostas", "Lipsilias", "Klipsilias", "password");
        Users user2 = new Users("James", "Bond", "Bond123", "password");
        Users user3 = new Users("James", "Bond", "Bond123", "password");
        listeRight.add(user1);
        listeRight.add(user2);
        listeRight.add(user3);
        Users user4 = new Users("James", "Bond", "Bond123", "password");
        Users user5 = new Users("James", "Bond", "Bond123", "password");
        Users user6 = new Users("James", "Bond", "Bond123", "password");
        tester.addUser(user4);
        tester.addUser(user5);
        tester.addUser(user6);

        assertNotEquals(listeRight, tester.getUsers());
    }

    @Test
    public void testTeilnehmerListRightContent(){
        Users user1 = new Users("Kostas", "Lipsilias", "Klipsilias", "password");
        Users user2 = new Users("James", "Bond", "Bond123", "password");
        Users user3 = new Users("James", "Bond", "Bond123", "password");
        listeRight.add(user1);
        listeRight.add(user2);
        listeRight.add(user3);
        for(int i = 0; i<listeRight.size(); i++){
            tester.addUser(listeRight.get(i));
        }
        assertEquals(listeRight, tester.getUsers());
    }
}
