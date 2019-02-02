import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Helpers {
	
	protected static final AudioFileFormat.Type FILE_TYPE = AudioFileFormat.Type.WAVE;
    private static TargetDataLine line;
    
	public static AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                        channels, signed, bigEndian);
        return format;
    }
	
	
	public static void startRecording() {
        if (line == null) {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        AudioFormat format = getAudioFormat();
                        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

                        // checks if system supports the data line
                        if (!AudioSystem.isLineSupported(info)) {
                            System.out.println("Line not supported");
                            System.exit(0);
                        }
                        line = (TargetDataLine) AudioSystem.getLine(info);
                        line.open(format);
                        line.start();   // start capturing


                        AudioInputStream ais = new AudioInputStream(line);

                        // start recording
                        AudioSystem.write(ais, FILE_TYPE, new File("Test.wav"));

                    } catch (LineUnavailableException ex) {
                        ex.printStackTrace();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

      
                }
            });
            t.start();
        }
    }
	
	public static void stopRecording() {

        if (line != null) {

            line.stop();
            line.close();
            line = null;

        }

    }
}
