package audio

import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl
import java.util.Timer
import java.util.TimerTask

fun playSound(audioPath: String, volume: Float, durationMills: Long): Clip {
    val audio: File = File(audioPath)
    val audioInput: AudioInputStream = AudioSystem.getAudioInputStream(audio)
    val clip: Clip = AudioSystem.getClip()
    clip.open(audioInput)
    if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)){
        val lautstärke: FloatControl = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
        lautstärke.value = lautstärke.minimum+(0.55f*(lautstärke.maximum-lautstärke.minimum))
        clip.start()
    } else {
        println("Master gain control wird nicht unterstuetzt, wir konnten die Lautstärke so nicht beeinflussen...")
    }
    val test = 0.99f

    val timer = Timer()
    timer.schedule(object : TimerTask() {
        override fun run() {
            clip.stop()
            clip.close()
        }
    }, durationMills)
    return clip
}
fun endSound(clip: Clip){
    clip.stop()
    clip.close()
}