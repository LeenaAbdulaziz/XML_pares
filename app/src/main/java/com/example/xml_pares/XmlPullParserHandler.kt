package com.example.xml_pares
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlPullParserHandler {
    private var stu_detiels = ArrayList<Student_details>()
    private var name=""
    private var text: String? = null
    var id=0
    var marks=0


    fun parse(inputStream: InputStream): List<Student_details> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {

                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG ->  when {
                        tagName.equals("id", ignoreCase = true) ->{
                        id = text.toString().toInt()
                        }
                        tagName.equals("name", ignoreCase = true) ->{
                        name=text.toString()
                        }
                   tagName.equals("marks", ignoreCase = true) ->  { marks = text.toString().toInt()}

                        else -> {
                            stu_detiels.add(Student_details(id,name,marks))
                        }
                    }


                    else -> {
                    }

                    }
                eventType = parser.next()

                }



        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stu_detiels
    }
}
