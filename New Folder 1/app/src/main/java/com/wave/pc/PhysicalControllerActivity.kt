package com.wave.pc

import android.os.Bundle
import android.view.InputDevice
import androidx.appcompat.app.AppCompatActivity

class PhysicalControllerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkConnectedControllers()
    }

    private fun checkConnectedControllers() {
        val deviceIds = InputDevice.getDeviceIds()
        for (deviceId in deviceIds) {
            val device = InputDevice.getDevice(deviceId)
            val sources = device.sources
            if ((sources and InputDevice.SOURCE_GAMEPAD == InputDevice.SOURCE_GAMEPAD) ||
                (sources and InputDevice.SOURCE_JOYSTICK == InputDevice.SOURCE_JOYSTICK)) {
                // Controle físico encontrado
            }
        }
    }
}
