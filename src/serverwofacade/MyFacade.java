package serverwofacade;

public class MyFacade {
    ScheduleServer scheduleServer = new ScheduleServer();
    private static MyFacade myFacadeObj = null;
    private MyFacade() {}
    public static MyFacade getMyFacadeObject() {
        if (myFacadeObj == null) {
            myFacadeObj = new MyFacade();
        }
        return myFacadeObj;
    }
    public void classStart(){
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
        scheduleServer.releaseProcesses();
    }

	public void classStop() {
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}
