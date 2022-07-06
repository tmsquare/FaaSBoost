package entities;

/**
 * @author fdse
 */

public class TrainType {
    private String id;

    private int economyClass;

    private int confortClass;

    private int averageSpeed;

    public TrainType(){
        //Default Constructor
    }

    public TrainType(String id, int economyClass, int confortClass) {
        this.id = id;
        this.economyClass = economyClass;
        this.confortClass = confortClass;
    }

    public TrainType(String id, int economyClass, int confortClass, int averageSpeed) {
        this.id = id;
        this.economyClass = economyClass;
        this.confortClass = confortClass;
        this.averageSpeed = averageSpeed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEconomyClass() {
        return economyClass;
    }

    public void setEconomyClass(int economyClass) {
        this.economyClass = economyClass;
    }

    public int getConfortClass() {
        return confortClass;
    }

    public void setConfortClass(int confortClass) {
        this.confortClass = confortClass;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}

//
// public enum TrainType {
//
//     /**
//      * G
//      */
//     GAOTIE    (0,"G"),
//     /**
//      * D
//      */
//     DONGCHE   (1,"D"),
//     /**
//      * C
//      */
//     CHENGJI   (2,"C"),
//     /**
//      * Z
//      */
//     ZHIDA     (3,"Z"),
//     /**
//      * T
//      */
//     TEKUAI    (4,"T"),
//     /**
//      * E
//      */
//     KUAISU    (5,"K"),
//     /**
//      * L
//      */
//     LINKE     (6,"L"),
//     /**
//      * Y
//      */
//     YOULAN    (7,"Y"),
//     /**
//      * S
//      */
//     CHENGJIAO (8,"S"),
//     /**
//      *
//      */
//     OTHER     (9,"");
//
//     private int code;
//      private String name;
//
//     TrainType(int code, String name){
//         this.code = code;
//         this.name = name;
//     }
//
//     public int getCode(){
//         return code;
//     }
//
//     public String getName() {
//         return name;
//     }
//
//     public static String getNameByCode(int code){
//         TrainType[] trainTypeSet = TrainType.values();
//         for(TrainType trainType : trainTypeSet){
//             if(trainType.getCode() == code){
//                 return trainType.getName();
//             }
//         }
//         return trainTypeSet[0].getName();
//     }
// }
//
//