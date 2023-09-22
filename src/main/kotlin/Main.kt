import org.jsoup.Jsoup
import org.jsoup.helper.HttpConnection
import java.io.BufferedReader
import java.io.DataInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.swing.text.Document

fun main(args: Array<String>) {

    val url = "https://store.steampowered.com/app/1174180/Red_Dead_Redemption_2/"

    //obtenemos el html de la web
    var readHtml = readWeb(url)

    //procedemos a leer el contenido por id,class,p,h1
    //por lo que sea necesario

    val document = Jsoup.connect(url).get() //parseamos el texto a html

    val classSelect=document.select("block_content page_content rightcol glance_ctn game_header_image_ctn img game_header_image_full src").first()

    println(classSelect!!.text())
    println("Program arguments: ${args.joinToString()}")
}

private fun readWeb(ur: String): String {
    val url = URL(ur)

    val conection = url.openConnection() as HttpURLConnection
    conection.requestMethod = "GET" //metodo de respuesta

    //verificamos si la respuesta es correcta osea si es ok 200

    return if (conection.responseCode == 200) {//tod0 ba bine
        val inputStream = conection.inputStream
        val buff = BufferedReader(InputStreamReader(inputStream))

        //procedemos a leer el DOC html linea por
        // linea y adjuntamos todo_ el contenido
        var read: String? = ""

        while (buff.readLine().also { read += it } != null) {//mientras haiga contenido
           // println(read)
        }
        read ?: "no content"

    } else { // lo contario que hay error ena respuesta 400 u otra
        println("ocurrrio un error ${conection.responseCode}")

        "error"
    }


}