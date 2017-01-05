package ua.com.lavi

import java.io.IOException
import java.util.*

/**
 * Created by Oleksandr Loushkin on 05.01.2017.
 */

class ApplicationConfig {

    private val configFileName: String = "application.properties"

    fun getProperties(): Properties {
        val properties: Properties = Properties()
        try {
            properties.load(this.javaClass.classLoader.getResourceAsStream(configFileName))
            return properties
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return properties
    }
}
