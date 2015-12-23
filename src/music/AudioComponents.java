/*
 * Music Visualizations: http:/github.com/michaelbrooks/music-visualization
 * Copyright 2012, Michael Brooks. BSD License.
 */
package music;

import javax.sound.sampled.AudioFormat;

/**
 *
 * @author michael
 */
public class AudioComponents {

    private static AudioComponents instance;
    
    public static AudioComponents getInstance() {
        return instance;
    }

    public AudioComponents() {
        instance = this;
    }

    private Recorder recorder;

    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;
        this.recorder.setAudioComponents(this);
    }

    public Recorder getRecorder() {
        return recorder;
    }

    private AudioOutput audioOut;

    public void setAudioOutput(AudioOutput audioOut) {
        this.audioOut = audioOut;
        this.audioOut.setAudioComponents(this);
    }

    AudioOutput getAudioOutput() {
        return audioOut;
    }
    private GUIManager guiManager;

    public void setGUIManager(GUIManager gui) {
        this.guiManager = gui;
        this.guiManager.setAudioComponents(this);
    }

    public GUIManager getGUIManager() {
        return guiManager;
    }
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
        this.engine.setAudioComponents(this);
    }

    public Engine getEngine() {
        return engine;
    }
    private AudioInput audioInput;

    public void setAudioInput(AudioInput audioInput) {
        this.audioInput = audioInput;
        this.audioInput.setAudioComponents(this);
    }

    public AudioInput getAudioInput() {
        return audioInput;
    }

    private NoiseFilter noiseFilter;

    public void setNoiseFilter(NoiseFilter noiseFilter) {
        this.noiseFilter = noiseFilter;
        this.noiseFilter.setAudioComponents(this);
    }

    NoiseFilter getNoiseFilter() {
        return noiseFilter;
    }

    public void initialize() {
        this.recorder.initialize();
        this.audioInput.initialize();
        this.engine.initialize();
        this.guiManager.initialize();
        this.audioOut.initialize();
        this.noiseFilter.initialize();

        this.audioInput.addListener(engine);
    }

    public void destroy()
    {
        this.audioInput.destroy();
        this.engine.destroy();
        this.guiManager.destroy();
        this.audioOut.destroy();
        this.recorder.destroy();
        this.noiseFilter.destroy();
    }

    public void start() {
        getRecorder().start();
        getAudioInput().start();
        getEngine().start();
        getGUIManager().start();
        getAudioOutput().start();
        getNoiseFilter().destroy();
    }

    public void stop() {
        this.audioInput.stop();
        this.engine.stop();
        this.guiManager.stop();
        this.audioOut.stop();
        this.recorder.stop();
        this.noiseFilter.stop();
    }

    private AudioFormat audioInputFormat;
    private AudioFormat audioOutputFormat;

    public void setAudioInputFormat(AudioFormat audioInputFormat) {
        this.audioInputFormat = audioInputFormat;
    }

    public void setAudioOutputFormat(AudioFormat audioOutputFormat) {
        this.audioOutputFormat = audioOutputFormat;
    }

    public AudioFormat getAudioInputFormat() {
        return audioInputFormat;
    }

    private int audioChunkSize;

    public int getAudioChunkSize() {
        return audioChunkSize;
    }

    public void setAudioChunkSize(int size) {
        this.audioChunkSize = size;
    }

    public AudioFormat getAudioOutputFormat() {
        return audioOutputFormat;
    }
}
