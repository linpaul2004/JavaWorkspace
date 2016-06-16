import java.io.*; 
import javax.sound.sampled.*; 
public class SoundTry extends Thread{

	public void run() { 
		while(true){ 
		 try { 
		    // BG
		    File sf = new File("BG.wav");  
		    AudioInputStream astr = AudioSystem.getAudioInputStream(sf); 
		    AudioFormat afmt = astr.getFormat(); 
	    	DataLine.Info inf = new DataLine.Info(SourceDataLine.class,afmt); 		   
		    SourceDataLine l = (SourceDataLine) AudioSystem.getLine(inf); 		  
		    l.open(afmt); 
		    l.start(); 
		    byte[] buf = new byte[65536]; 		  
		    for( int n=0; (n=astr.read(buf,0,buf.length))>0; ){ 
		       l.write(buf,0,n); 
		    } 		
		    l.drain(); 	 
		    l.close(); 
		    try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    //// BG2
		    File sf2 = new File("BG2.wav");  
		    AudioInputStream astr2 = AudioSystem.getAudioInputStream(sf2); 
		    AudioFormat afmt2 = astr2.getFormat(); 
	    	DataLine.Info inf2 = new DataLine.Info(SourceDataLine.class,afmt2); 		   
		    SourceDataLine l2 = (SourceDataLine) AudioSystem.getLine(inf2); 		  
		    l2.open(afmt2); 
		    l2.start(); 
		    byte[] buf2 = new byte[65536]; 		  
		    for( int n=0; (n=astr2.read(buf2,0,buf2.length))>0; ){ 
		       l2.write(buf2,0,n); 
		    } 		
		    l2.drain(); 	 
		    l2.close(); 
		    try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    //BG3
		    File sf3 = new File("BG3.wav");  
		    AudioInputStream astr3 = AudioSystem.getAudioInputStream(sf3); 
		    AudioFormat afmt3 = astr3.getFormat(); 
	    	DataLine.Info inf3 = new DataLine.Info(SourceDataLine.class,afmt3); 		   
		    SourceDataLine l3 = (SourceDataLine) AudioSystem.getLine(inf3); 		  
		    l3.open(afmt3); 
		    l3.start(); 
		    byte[] buf3 = new byte[65536]; 		  
		    for( int n=0; (n=astr3.read(buf3,0,buf3.length))>0; ){ 
		       l3.write(buf3,0,n); 
		    } 		
		    l3.drain(); 	 
		    l3.close(); 
		    try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    

		} catch (Exception e) { 
		   e.printStackTrace(); 
		  } 
	  }
		
} 

}
