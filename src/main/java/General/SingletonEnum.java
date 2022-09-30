package General;

//Showcasing singleton usage using Enums
//https://dzone.com/articles/java-singletons-using-enum

public enum SingletonEnum {
    INSTANCE;

    int value ;
    public int getValue(){
        return value;
    }

    public  void  setValue(int value){
        this.value = value;
    }

    public static void main(String[] args) {
    SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum.getValue());
        singletonEnum.setValue(5);
        System.out.println(singletonEnum.getValue());
    }
}
