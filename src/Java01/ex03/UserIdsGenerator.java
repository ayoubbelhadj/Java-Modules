package Java01.ex03;

public class UserIdsGenerator {
    public static UserIdsGenerator instance;
    private Integer LastIdGenerated = 0;

    private UserIdsGenerator(){}

    public static UserIdsGenerator getInstance(){
        if (instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }

    public Integer generateId(){
        LastIdGenerated++;
        return LastIdGenerated;
    }

}