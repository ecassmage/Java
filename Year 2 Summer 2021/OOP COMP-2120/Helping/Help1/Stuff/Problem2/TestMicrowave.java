package Problem2;
public class TestMicrowave {
    public TestMicrowave(){

    }
    public static void main(String[] args) {

        Microwave myMicrowave = new Problem2.Microwave(0, "Low", "OFF") ;
        myMicrowave.reset();
        
        //first time turning on the machine 
        myMicrowave.setTime() ;  
        myMicrowave.setTime() ; // settig the timer to 1:30 
        myMicrowave.setTime();
        //setting the power 
        myMicrowave.setPowerLvl("Med");
        //start 
        myMicrowave.start(); 
        //stop
        myMicrowave.stop(); 
        //reSet
        myMicrowave.reset();

        ////second time turning on the machine 
        myMicrowave.setTime() ;  
        myMicrowave.setTime() ; 
        myMicrowave.setTime() ; // settig the timer to 2:00
        myMicrowave.setTime();
        //setting the power 
        myMicrowave.setPowerLvl("Low");
        //start 
        myMicrowave.start(); 
        //stop
        myMicrowave.stop(); 

        ////Third time turning on the machine 
        myMicrowave.setTime() ; // settig the timer to 00:30
        //setting the power 
        myMicrowave.setPowerLvl("high");
        //start 
        myMicrowave.start(); 
        //stop
        myMicrowave.stop(); 
        //reSet
        myMicrowave.reset();
        

    

    }
    
}