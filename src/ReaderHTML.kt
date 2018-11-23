import java.net.*
import java.io.*
import java.util.*
import java.io.BufferedReader
import kotlin.collections.ArrayList


fun main(args: Array<String>){

    print("Podaj URL strony: ")
    val url: URL = URL(readLine())

    val html = ReaderHTML().readHTML(url)

    print("Podaj ścieżke do zapisu pliku txt: ")
    val path = readLine()!!
    ReaderHTML().exportHTMLtoFile(html,path)
}

class ReaderHTML{
    //-------------------Retrieving HTML code---------------------------
    fun readHTML(url: URL): ArrayList<String>{

        val br = BufferedReader(InputStreamReader(url.openStream()))
        var line : String? //One line of HTML code
        val codeHTML = ArrayList<String>() //Array of all HTML codes

        //------------Read line HTML as long as exist--------
            do {
                line = br.readLine()
                if (line == null) break
                codeHTML.add(line)
                println(line)

            } while(true)
        //----------------------------------------------------
        br.close()

        return codeHTML
    }
    //------------------------------------------------------------------

    //----------------Export HTML to .txt------------------
    fun exportHTMLtoFile(text: ArrayList<String>, path: String){
        val file = File(path+ "/result.txt")
        for(i in text){
            file.appendText(i)
            file.appendText("\n")
        }
    }
    //-----------------------------------------------------



}
