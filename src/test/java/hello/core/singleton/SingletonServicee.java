package hello.core.singleton;

public class SingletonServicee {
    
    private static final SingletonServicee instance = new SingletonServicee();
    
    public static SingletonServicee getInstance() {
        return instance;
    }
    
    private  SingletonServicee() {
        
    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
