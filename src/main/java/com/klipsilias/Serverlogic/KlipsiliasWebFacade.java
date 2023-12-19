package com.klipsilias.Serverlogic;

//Diese Klasse wurde nun zu einer richtigen Facade umgebaut.


import com.klipsilias.Database.DoubleData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.testng.annotations.Test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.util.Optional;
@SpringBootApplication

public class KlipsiliasWebFacade extends Observable implements ServerlogicFacade {
    public static void main(String[] args) throws IOException {
//        Protocol protocol = new Protocol();
//        KlipsiliasWebFacade toll = new KlipsiliasWebFacade();
//        toll.addObserver(protocol);
//        //SecurityData.getInstance();
//        new Grade(1.2, "felstner");
//        new Grade(1.2, "felstner");
//        new Grade(1.3, "pdopatka");
//        //SecurityData.add("pdopatka", "deinemuddaisttoll69");
//        //SecurityData.add("felstner", "123456789");
//        //SecurityData.add("wwalther", "hahahaihai");
//        //SecurityData.login("wwalther", "hahahaihai");
//        Student frank = new Student("elstner", "frank", "felstner", "s1884z105h", true);
//        Lecturer thomas = new Lecturer("thomas", "gottschalk", "tgottschalk", "sjkvuifufi");
//        Administration jonathan = new Administration("Jonathan", "Tah", "jtah", "t7guhwoph");
//        jonathan.viewUsers(frank);
//        frank.getUsersGradeList();
//        toll.log("protokoll.txt");
//        ITSupport harald = new ITSupport("heinz", "harald", "hharald", "135623");
//        harald.viewProtocol();
        SpringApplication.run(KlipsiliasWebFacade.class, args);
    }


    //static int i = 0;
    //private static final Logger logger = Logger.getLogger("id" + i);
    Protocol observer = new Protocol();
    static Grade grade;
    Event event;
    Users user;
    Student student;
    ITSupport itSupport;

    ExamOfficeEmployee examOfficeEmployee;


    private static KlipsiliasWebFacade instancePool;
    DataManager dataManager = new DataManager() {
        @Override
        public Integer getId() {
            return dataManager.getId();
        }

        @Override
        public void setId(Integer id) {
            dataManager.setId(id);
            log(String.valueOf(dataManager.getId()));
        }
    };
    /*
    DataManagerUsers dataManagerUsers = new DataManagerUsers() {
        @Override
        public void setUsersname(String username) {
            dataManagerUsers.setUsersname(username);
            log(username);
        }

        @Override
        public String getName() {
            return dataManagerUsers.getName();
        }

        @Override
        public void setName(String name) {
            dataManagerUsers.setName(name);
            log(dataManagerUsers.getName());
        }

        @Override
        public String getVorname() {
            return dataManagerUsers.getVorname();
        }

        @Override
        public void setVorname(String vorname) {
            dataManagerUsers.setVorname(vorname);
            log(dataManagerUsers.getVorname());
        }

        @Override
        public void setId(String id) {
            dataManagerUsers.setId(id);
            log(dataManagerUsers.getId());
        }

        @Override
        public int getAccessLevel() {
            return dataManagerUsers.getAccessLevel();

        }

        @Override
        public boolean viewUsers(Users dummy) {
            log(dummy.toString());
            return dataManagerUsers.viewUsers(dummy);
        }

        @Override
        public String getId() {
            return dataManagerUsers.getId();
        }
    };
    */
    DataManagerRoom dataManagerRoom = new DataManagerRoom() {
        @Override
        public String getLocation() {
            return dataManagerRoom.getLocation();
        }

        @Override
        public void setLocation(String location) {
            dataManagerRoom.setLocation(location);
            log(dataManagerRoom.getLocation());
        }

        @Override
        public void makeReservation(String day, int time) {
            log(day);
            log(String.valueOf(time));
            dataManagerRoom.makeReservation(day, time);
        }

        @Override
        public Integer getId() {
            return dataManagerRoom.getId();
        }

        @Override
        public void setId(Integer id) {
            dataManager.setId(id);
            log(String.valueOf(dataManagerRoom.getId()));
        }
    };
    DataManagerGrade dataManagerGrade = new DataManagerGrade() {
        @Override
        public double getGradeNumber() {
            return dataManagerGrade.getGradeNumber();
        }

        @Override
        public void setGradeNumber(int gradeNumber) {
            dataManagerGrade.setGradeNumber(gradeNumber);
            log(String.valueOf(dataManagerGrade.getGradeNumber()));
        }

        @Override
        public Integer getId() {
            return dataManagerGrade.getId();
        }

        @Override
        public void setId(Integer id) {
            dataManagerGrade.setId(id);
            log(String.valueOf(dataManagerGrade.getId()));
        }
    };
    DataManagerEvent dataManagerEvent = new DataManagerEvent() {
        @Override
        public Room getVeranstaltungsort() {
            return dataManagerEvent.getVeranstaltungsort();
        }

        @Override
        public void setVeranstaltungsort(Room veranstaltungsort) {
            dataManagerEvent.setVeranstaltungsort(veranstaltungsort);
        }

        @Override
        public String getZeitpunkt() {
            return dataManagerEvent.getZeitpunkt();
        }

        @Override
        public ArrayList<Users> getList() {
            return dataManagerEvent.getList();
        }

        @Override
        public void setTeilnehmer(ArrayList<Users> teilnehmer) {
            dataManagerEvent.setTeilnehmer(teilnehmer);
            log(dataManagerEvent.getList().toString());
        }

        @Override
        public void addTeilnehmer(Users user) {
            log(user.toString());
            dataManagerEvent.addTeilnehmer(user);
        }

        @Override
        public void deleteTeilnehmer(Users user) {
            log(user.toString());
            dataManagerEvent.deleteTeilnehmer(user);
        }

        @Override
        public void setZeitpunkt(String pZeitpunkt) {
            dataManagerEvent.setZeitpunkt(pZeitpunkt);
            log(dataManagerEvent.getZeitpunkt());
        }

        @Override
        public Integer getId() {
            return dataManagerEvent.getId();
        }

        @Override
        public void setId(Integer id) {
            dataManagerEvent.setId(id);
            log(String.valueOf(dataManagerEvent.getId()));
        }
    };
    DataManagerStudent dataManagerStudent = new DataManagerStudent() {
        @Override
        public void getUsersGradeList() {
            dataManagerStudent.getUsersGradeList();
        }

        @Override
        public void registerEvent(Event event) {
            log(event.toString());
            dataManagerStudent.registerEvent(event);
        }

        @Override
        public void deregisterEvent(Event event) {
            log(event.toString());
            dataManagerStudent.deregisterEvent(event);
        }
    };
    private String message;


    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    public void log(String message) {
        //notifyObservers(message);
    }

    @Override
    public void notifyObservers(Object arg) {
        if (arg != null) {
            for (Observer observer : observers) {
                observer.update(this, arg);
            }
        }
    }

    public static KlipsiliasWebFacade getInstance() {
        if (instancePool == null) {
            instancePool = new KlipsiliasWebFacade();
        }
        return instancePool;
    }

    public static ArrayList<DoubleData> getGradeList() {
        return grade.getList();
    }

    public void viewProtocol() throws IOException, IOException {
        itSupport.viewProtocol();
    }

    @Override
    public boolean viewUsers(Users dummy) {
        return user.viewUsers(dummy);
    }

    public void update(Object o, Object args) {
        observer.update((Observable) o, args);
    }

    /*
    public static boolean login(String username, String password) {
        return SecurityData.login(username, password);
    }

    public static SecurityData getInstanceOf() {
        return SecurityData.getInstance();
    }

    public static void add(String username, String password) {
        SecurityData.add(username, password);
    }

     */
    public void setAccessLevel(int i) {
        log(String.valueOf(i));
        user.setAccessLevel(i);
    }

    public static ArrayList<Users> getAllUsersList(){
        return Users.getList();
    }

    public ArrayList<Room> getRoomList(){
        return Room.getRoomList();
    }

    public void makeGrade(double note, String name){
        log(String.valueOf(note) + name);
        examOfficeEmployee.makeGrade(note, name);
    }
//    @Bean

//    public CommandLineRunner testApp(UserRepository repo) {
//        return args -> {
//            repo.save(new Users("James", "Bond", "Bond123", "password"));
//
//            Iterable<Users> allUsers = repo.findAll();
//            System.out.println("All students in DB: " + allUsers);
//
//            Optional<Users> U = repo.findById(1);
//            System.out.println(U.toString());
//        };
//    }
}
