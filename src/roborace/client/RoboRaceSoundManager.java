package roborace.client;

import COSC3P91.sound.Sound;
import COSC3P91.sound.SoundManager;
import javax.sound.sampled.AudioFormat;

public class RoboRaceSoundManager extends SoundManager {
            
     public Sound bump,explosion,fanfare,drivingShort,drivingLong,pusher,crusher;
     
     private static RoboRaceSoundManager RoboSound = new RoboRaceSoundManager();
     private long  time;
   
     
    private RoboRaceSoundManager() {
        super(new AudioFormat(8000,8,1,false,false),4);
        super.setSoundPath("./Sounds&Midi/");
        bump = getSound("bump.wav");
        explosion = getSound("explosion.wav");
        fanfare = getSound("fanfare.wav");
        drivingShort = getSound("drivingShort.wav");
        drivingLong = getSound("drivingLong.wav");
        pusher =  getSound("pusher.wav");
        crusher = getSound("crusher.wav");
       time = System.currentTimeMillis();


        
    }
    
    public static RoboRaceSoundManager getInstance(){
        
        return RoboSound;
    }
    
    
     public void playBump(){
         long currTime = System.currentTimeMillis();
         
          if(currTime -this.time>400){
        play(bump);
         }
          time = System.currentTimeMillis();
    }
    
    public void playExplosion(){
         long currTime = System.currentTimeMillis();
         
          if(currTime -this.time>400){
        play(explosion);
          }
          time = System.currentTimeMillis();
    }
    
    public void playFanFare(){
           long currTime = System.currentTimeMillis();
         
          if(currTime -this.time>400){
        play(fanfare);
          }
          time = System.currentTimeMillis();
    }
    
    public void playdrivingShort() {
          long currTime = System.currentTimeMillis();
         
          if(currTime -this.time>400){
        play(drivingShort); 
          }
          time = System.currentTimeMillis();
    }
    
     public void playdrivingLong() {
           long currTime = System.currentTimeMillis();
         
          if(currTime -this.time>400){
           play(drivingLong);
           }
          time = System.currentTimeMillis();
     }
     
      public void playPusher() {
           long currTime = System.currentTimeMillis();
         
          if(currTime -this.time>400){
          play(pusher);
            }
          time = System.currentTimeMillis();
      }
      
      public void playCrusher() {
          long currTime = System.currentTimeMillis();
         
          if(currTime -this.time>400){
          play(crusher);
            }
          time = System.currentTimeMillis();
      }
      
 
}