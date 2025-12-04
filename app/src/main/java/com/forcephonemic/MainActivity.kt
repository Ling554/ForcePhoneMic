package com.forcephonemic

import android.media.AudioManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Minimal UI: a button to trigger force mic routing
        val btn = Button(this)
        btn.text = "Force Phone Mic"
        btn.setOnClickListener {
            val success = tryForcePhoneMic()
            Toast.makeText(this, if (success) "Tried to force phone mic" else "Failed to force mic", Toast.LENGTH_SHORT).show()
        }
        setContentView(btn)
    }

    private fun tryForcePhoneMic(): Boolean {
        return try {
            val am = getSystemService(AUDIO_SERVICE) as AudioManager

            // NOTE: many AudioManager methods used here are deprecated or restricted on newer Android versions.
            // They are left as a best-effort demonstration. Real routing may require elevated privileges or Shizuku/root.
            am.mode = AudioManager.MODE_IN_COMMUNICATION
            am.stopBluetoothSco()
            am.isBluetoothScoOn = false

            // Attempt workaround: disable wired headset audio capture if allowed by platform
            try {
                val setWiredHeadsetOn = AudioManager::class.java.getMethod("setWiredHeadsetOn", Boolean::class.javaPrimitiveType)
                setWiredHeadsetOn.invoke(am, false)
            } catch (_: Exception) {
                // ignore reflection failures
            }

            // Toggle microphone mute quickly to reset input device
            am.isMicrophoneMute = true
            Thread.sleep(120)
            am.isMicrophoneMute = false

            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
