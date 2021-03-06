import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTS {

	private static final String VOICENAME_kevin = "kevin";
	private String text; // string to speech

	public FreeTTS(String text) {
		this.text = text;
	}

	public void speak() {
		Voice voice;
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(VOICENAME_kevin);
		voice.allocate();
		voice.speak(text);
	}
	
	public static void listAllVoices(){
		VoiceManager voiceManager = VoiceManager.getInstance();
		Voice[] voices = voiceManager.getVoices();
		for(Voice voice : voices){
			System.out.println(voice.getName() + "(" + voice.getDescription() + ")");
		}
	}

	public static void main(String[] args) {
		listAllVoices();
		String text = "FreeTTS was written by the Sun Microsystems Laboratories "
				+ "Speech Team and is based on CMU's Flite engine.";
		FreeTTS freeTTS = new FreeTTS(text);
		freeTTS.speak();
	}
}