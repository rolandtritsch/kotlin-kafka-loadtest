package com.tenable.loadtest.example.util

import java.io.IOException
import java.util.*

class ApplicationConfig(val configFileName: String) {
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