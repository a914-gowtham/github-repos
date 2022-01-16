package com.gowtham.core

import com.google.gson.Gson
import org.intellij.lang.annotations.Language

object Utils{


    fun parseJsonString(json: String): HashMap<String,Object>{
        val map: HashMap<String, Object> = Gson().fromJson(
            json,
            HashMap::class.java
        ) as HashMap<String, Object>
        return  map
    }

    fun getLanguageHexColor(language: String,json: String?): String{
        return try {
            val map= parseJsonString(json!!)
            val languageMap= map[language] as Map<*, *>
            val color: String= languageMap["color"] as String? ?: "#FFDE03"
            color
        } catch (e: Exception) {
            e.printStackTrace()
            "#FFDE03"
        }
    }
}
