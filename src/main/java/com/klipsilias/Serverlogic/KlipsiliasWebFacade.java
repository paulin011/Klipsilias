package com.klipsilias.Serverlogic;

//Diese Klasse wurde nun zu einer richtigen Facade umgebaut.

/*
public class KlipsiliasWebFacade extends Observable implements ServerlogicFacade {
    public static void main(String[] args) throws IOException {
        Protocol protocol = new Protocol();
        KlipsiliasWebFacade toll = new KlipsiliasWebFacade();
        toll.addObserver(protocol);
        SecurityData.getInstance();
        new Grade(1.2, "felstner");
        new Grade(1.2, "felstner");
        new Grade(1.3, "pdopatka");
        SecurityData.add("pdopatka", "deinemuddaisttoll69");
        SecurityData.add("felstner", "123456789");
        SecurityData.add("wwalther", "hahahaihai");
        SecurityData.login("wwalther", "hahahaihai");
        Student frank = new Student("elstner", "frank", "felstner", "s1884z105h", true);
        Lecturer thomas = new Lecturer("thomas", "gottschalk", "tgottschalk", "sjkvuifufi");
        Administration jonathan = new Administration("Jonathan", "Tah", "jtah", "t7guhwoph");
        jonathan.viewUser(frank);
        frank.getUserGradeList();
        toll.log("protokoll.txt");
        ITSupport harald = new ITSupport("heinz", "harald", "hharald", "135623");
        harald.viewProtocol();
    }

    //static int i = 0;
    //private static final Logger logger = Logger.getLogger("id" + i);
    Protocol observer = new Protocol();
    static Grade grade;
    Event event;
    User user;
    Student student;
    ITSupport itSupport;

    ExamOfficeEmployee examOfficeEmployee;


    private static KlipsiliasWebFacade instancePool;
    DataManager dataManager = new DataManager() {
        @Override
        public String getId() {
            return dataManager.getId();
        }

        @Override
        public void setId(String id) {
            dataManager.setId(id);
            log(dataManager.getId());
        }
    };

    DataManagerUser dataManagerUser = new DataManagerUser() {
        @Override
        public void setUsername(String username) {
            dataManagerUser.setUsername(username);
            log(username);
        }

        @Override
        public String getName() {
            return dataManagerUser.getName();
        }

        @Override
        public void setName(String name) {
            dataManagerUser.setName(name);
            log(dataManagerUser.getName());
        }

        @Override
        public String getVorname() {
            return dataManagerUser.getVorname();
        }

        @Override
        public void setVorname(String vorname) {
            dataManagerUser.setVorname(vorname);
            log(dataManagerUser.getVorname());
        }

        @Override
        public void setId(String id) {
            dataManagerUser.setId(id);
            log(dataManagerUser.getId());
        }

        @Override
        public int getAccessLevel() {
            return dataManagerUser.getAccessLevel();

        }

        @Override
        public boolean viewUser(User dummy) {
            log(dummy.toString());
            return dataManagerUser.viewUser(dummy);
        }

        @Override
        public String getId() {
            return dataManagerUser.getId();
        }
    };
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
        public String getId() {
            return dataManagerRoom.getId();
        }

        @Override
        public void setId(String id) {
            dataManager.setId(id);
            log(dataManagerRoom.getId());
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
        public String getId() {
            return dataManagerGrade.getId();
        }

        @Override
        public void setId(String id) {
            dataManagerGrade.setId(id);
            log(dataManagerGrade.getId());
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
        public ArrayList<User> getList() {
            return dataManagerEvent.getList();
        }

        @Override
        public void setTeilnehmer(ArrayList<User> teilnehmer) {
            dataManagerEvent.setTeilnehmer(teilnehmer);
            log(dataManagerEvent.getList().toString());
        }

        @Override
        public void addTeilnehmer(User user) {
            log(user.toString());
            dataManagerEvent.addTeilnehmer(user);
        }

        @Override
        public void deleteTeilnehmer(User user) {
            log(user.toString());
            dataManagerEvent.deleteTeilnehmer(user);
        }

        @Override
        public void setZeitpunkt(String pZeitpunkt) {
            dataManagerEvent.setZeitpunkt(pZeitpunkt);
            log(dataManagerEvent.getZeitpunkt());
        }

        @Override
        public String getId() {
            return dataManagerEvent.getId();
        }

        @Override
        public void setId(String id) {
            dataManagerEvent.setId(id);
            log(dataManagerEvent.getId());
        }
    };
    DataManagerStudent dataManagerStudent = new DataManagerStudent() {
        @Override
        public void getUserGradeList() {
            dataManagerStudent.getUserGradeList();
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


    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    public void log(String message) {
        //notifyObservers(message);
    }

    @Override
    public void notifyObservers(Object arg) {
        if (Objects.nonNull(arg)) {
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

    public void viewProtocol() throws IOException {
        itSupport.viewProtocol();
    }

    public void update(Object o, Object args) {
        observer.update((Observable) o, args);
    }

    public static boolean login(String username, String password) {
        return SecurityData.login(username, password);
    }

    public static SecurityData getInstanceOf() {
        return SecurityData.getInstance();
    }

    public static void add(String username, String password) {
        SecurityData.add(username, password);
    }

    public boolean viewUser(User dummy) {
        return user.viewUser(dummy);
    }

    public void setAccessLevel(int i) {
        log(String.valueOf(i));
        user.setAccessLevel(i);
    }

    public static ArrayList<User> getAllUserList(){
        return User.getList();
    }

    public ArrayList<Room> getRoomList(){
        return Room.getRoomList();
    }

    public void makeGrade(double note, String name){
        log(String.valueOf(note) + name);
        examOfficeEmployee.makeGrade(note, name);
    }
}

*/