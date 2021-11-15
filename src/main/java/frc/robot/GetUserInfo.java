package frc.robot;

public class GetUserInfo {
    private int option;

    public GetUserInfo(int opt){
        this.option = opt;
    }

    public GetUserInfo(){
        option = 0;
    }

    public int getOption(){
        return option;
    }
    
}
